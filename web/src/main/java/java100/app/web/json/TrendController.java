package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Member;
import java100.app.domain.Trend;
import java100.app.domain.UploadFile;
import java100.app.service.TrendService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/trend")
@SessionAttributes("loginUser")
public class TrendController {

    @Autowired  ServletContext servletContext;
    @Autowired  TrendService trendService;


    @RequestMapping("list")
    public Object list(
            @RequestParam(value = "pn", defaultValue = "1") int pageNo,
            @RequestParam(value = "ps", defaultValue = "5") int pageSize,
            @RequestParam(value = "words", required = false) String[] words,
            @RequestParam(value = "oc", required = false) String orderColumn,
            @RequestParam(value = "al", required = false) String align,
            Trend trend) throws Exception {
      
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
        
        
        HashMap <String, Object> result = new HashMap<>();
        result.put("list1", trendService.list1(pageNo, pageSize,options));
        return  result ;
    }

    @RequestMapping("add")
    public Object add(
            Trend trend,
            MultipartFile file[],
            @ModelAttribute(value = "loginUser") Member loginUser)
            throws Exception {

        String uploadDir = servletContext.getRealPath("/download");

        ArrayList<UploadFile> uploadFiles = new ArrayList<>();

        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            String Thumbnail = this.Thumbnail(uploadDir,filename,600,600);
            trend.setPhoto(Thumbnail);
            uploadFiles.add(new UploadFile(filename, Thumbnail));
        }

        trendService.add(trend);
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("status", "uploadFiles");
      
        return "result";
    }

    @RequestMapping("update")
    public String update(
            Trend trend,
            MultipartFile file[]) throws Exception {

        
        String uploadDir = servletContext.getRealPath("/download");

        ArrayList<UploadFile> uploadFiles = new ArrayList<>();

        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            String Thumbnail = this.Thumbnail(uploadDir,filename,600,600);
            trend.setPhoto(Thumbnail);
            uploadFiles.add(new UploadFile(filename, Thumbnail));
        }
        

        trendService.update(trend);

        return "redirect:list";
    }
    

    @RequestMapping("delete")
    public Object delete(int tr_no) throws Exception {
     
        trendService.delete(tr_no);
        
        HashMap <String, Object> result = new HashMap<>();
        
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