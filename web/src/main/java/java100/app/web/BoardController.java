package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Board;
import java100.app.domain.Member;
import java100.app.domain.UploadFile;
import java100.app.service.BoardService;

@Controller
@RequestMapping("/board")
@SessionAttributes("loginUser")
public class BoardController {

    @Autowired
    ServletContext servletContext;
    @Autowired
    BoardService boardService;

    @RequestMapping("list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") int pageNo,
            @RequestParam(value = "ps", defaultValue = "5") int pageSize,
            @RequestParam(value = "words", required = false) String[] words,
            @RequestParam(value = "oc", required = false) String orderColumn,
            @RequestParam(value = "al", required = false) String align, Model model) throws Exception {

        if (pageNo < 1) {
            pageNo = 1;
        }

        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }

        HashMap<String, Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);

        int totalCount = boardService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", boardService.list(pageNo, pageSize, options));
        return "board/list";
    }

    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {

        model.addAttribute("board", boardService.get(no));
        return "board/view";
    }

    @RequestMapping("form")
    public String form() throws Exception {
        return "board/form";

    }

    //@Transactional
    @RequestMapping("add")
    public String add(Board board, MultipartFile[] file, @ModelAttribute(value = "loginUser") Member loginUser)
            throws Exception {

        String uploadDir = servletContext.getRealPath("/download");

        ArrayList<UploadFile> uploadFiles = new ArrayList<>();

        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;

            String filename = this.writeUploadFile(part, uploadDir);

            board.setFilename(filename);
            //uploadFiles.add(new UploadFile(filename));
        }
        System.out.println(board.getFilename());
        board.setFiles(uploadFiles);

        board.setWriter(loginUser);
        
        boardService.add(board);
        

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(Board board, MultipartFile[] file) throws Exception {

        String uploadDir = servletContext.getRealPath("/download");

        ArrayList<UploadFile> uploadFiles = new ArrayList<>();

        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;

            String filename = this.writeUploadFile(part, uploadDir);

            board.setFilename(filename);
            //uploadFiles.add(new UploadFile(filename));
        }
     
        boardService.update(board);

        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        boardService.delete(no);
        return "redirect:list";
    }

    long prevMillis = 0;
    int count = 0;

    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }

        return currMillis + "_" + count++ + extractFileExtName(filename);
    }

    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");

        if (dotPosition == -1)
            return "";

        return filename.substring(dotPosition);
    }

    private String writeUploadFile(MultipartFile part, String path) throws IOException {

        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        return filename;
    }
}