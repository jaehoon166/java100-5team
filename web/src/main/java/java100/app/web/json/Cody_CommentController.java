package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.dao.Cody_CommentDao;
import java100.app.domain.Cody_Comment;
import java100.app.domain.Member;
import java100.app.domain.UploadFile;
import java100.app.service.Cody_CommentService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/cody_comment")
@SessionAttributes("loginUser")
public class Cody_CommentController {

    
    @Autowired
    ServletContext servletContext;
    @Autowired Cody_CommentService cody_commentService;
    
    @Autowired
    Cody_CommentDao cody_commentDao;

    @RequestMapping("list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") int pageNo,
            @RequestParam(value = "ps", defaultValue = "5") int pageSize,
            @RequestParam(value = "name", required = false) String[] names,
            @RequestParam(value = "oc", required = false) String orderColumn,
            @RequestParam(value = "al", required = false) String align, Model model) throws Exception {

        if (pageNo < 1) {
            pageNo = 1;
        }

        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }

        HashMap<String, Object> options = new HashMap<>();
        options.put("names", names);
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = cody_commentService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        
        
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        //model.addAttribute("list", cody_commentService.list(co_no));
        
        
        return "redirect:../cody/list";
    }

  

    @RequestMapping("add")
    public Object add(Cody_Comment cody_comment , MultipartFile file[]) throws Exception {
      
        String uploadDir = servletContext.getRealPath("/download");
       
        ArrayList<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            String Thumbnail = this.Thumbnail(uploadDir,filename,600,600);
            
            cody_comment.setComment_photo(Thumbnail);
            uploadFiles.add(new UploadFile(filename, Thumbnail));
    }
        
        HashMap<String, Object> result = new HashMap<>();
       
        cody_commentService.add(cody_comment);
        result.put("status", "uploadFiles");
        return result;
    }
    
    @RequestMapping("{com_no}")
    public String view(@PathVariable int com_no, Model model, Cody_Comment cody_comment) throws Exception {

      
        model.addAttribute("commentByCom_no", cody_commentService.getComNo(com_no));
       
        
        return "cody_comment/view";
    }
    
/*    @RequestMapping("form")
    public String form(Cody_Comment cody_comment, Model model, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
        
        
        return "cody_comment/form";
        
    }*/
   
    
    @RequestMapping("update")
    public String update(Cody_Comment cody_comment, Model model, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {

     
        cody_commentService.update(cody_comment);

        return "redirect:../cody/list";
    }
    
    
    @RequestMapping("delete")
    public Object delete(int com_no) throws Exception {

        System.out.println(com_no+"도착!!!!!!!!!!");
        cody_commentService.delete(com_no);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
        
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
    
    private String Thumbnail(String uploadDir, String filename, int width, int height) {
        File image = new File(uploadDir+"//"+filename); 
        File thumbnail = new File(uploadDir+"//s_"+filename); 
        if (image.exists()) { 
            try {
                int pos = filename.lastIndexOf(".");
                String format = filename.substring(pos + 1);
                Thumbnails.of(image).size(width, height).outputFormat(format).toFile(thumbnail);
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        return "s_"+filename;
    }
}
