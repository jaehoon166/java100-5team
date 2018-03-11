package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Cody;
import java100.app.domain.Cody_Comment;
import java100.app.domain.Liked;
import java100.app.domain.Member;
import java100.app.domain.UploadFile;
import java100.app.service.CodyService;
import java100.app.service.Cody_CommentService;
import java100.app.service.LikedService;
import java100.app.service.MemberService;
import java100.app.service.TrendService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/cody")
@SessionAttributes("loginUser")
public class CodyController {

    @Autowired ServletContext servletContext;
    @Autowired CodyService codyService;
    @Autowired LikedService likedService;
    @Autowired Cody_CommentService cody_commentService;
    @Autowired MemberService memberService;
    @Autowired TrendService trendService;
  
    @ModelAttribute(value = "loginUser")
    public Member loginUser() {
        
        Member loginUser = new Member();

        return loginUser;
        
    }
    

  @RequestMapping("list")
    public Object list(
            @RequestParam(value = "pn", defaultValue = "1") int pageNo,
            @RequestParam(value = "ps", defaultValue = "5") int pageSize,
            @RequestParam(value = "words", required = false) String[] words,
            @RequestParam(value = "tops", required = false) String[] tops,
            @RequestParam(value = "pants", required = false) String[] pants,
            @RequestParam(value = "oc", required = false) String orderColumn,
            @RequestParam(value = "al", required = false) String align,
            @ModelAttribute(value = "loginUser") Member loginUser,
            Cody cody ,Liked liked
            ) throws Exception {

        if (pageNo < 1) {
            pageNo = 1;
        }

        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }

        HashMap<String, Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        } else if (tops != null && tops[0].length() > 0) {
            options.put("tops", tops);
        } else if (pants != null && pants[0].length() > 0) {
            options.put("pants", pants);
        }

        options.put("orderColumn", orderColumn);
        options.put("align", align);

        int totalCount = codyService.getTotalCount();
        
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        HashMap<String, Object> result = new HashMap<>();

        // Liked 테이블 리스트에서 한번에 출력
        result.put("likedAll" , likedService.getAll());
        result.put("loginUser" , loginUser);
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", codyService.list(pageNo, pageSize, options));
        return result;
    }

  
    @RequestMapping("{co_no},{writer_no}")
    public Object view(
            @PathVariable int co_no,
            @ModelAttribute(value = "loginUser") Member loginUser,
            Cody cody,
            Cody_Comment cody_comment) throws Exception {
        
     /*   System.out.println(loginUser.getM_no()+"도d착~~~~~~~~~~~~~~~~~~");
        System.out.println(cody);*/
        
            HashMap<String, Object> result = new HashMap<>();
            
         if(cody.getWriter_no() != loginUser.getM_no()) {

            System.out.println(loginUser);
            cody_comment.setM_no(loginUser.getM_no());
            cody_comment.setId(loginUser.getId());
            result.put("cody", codyService.get(co_no));
            result.put("lista", likedService.list(co_no));
            result.put("formcomment", cody_comment);
            return result;
        } 
        
      
        else {
        
            System.out.println(loginUser);
            cody_comment.setM_no(loginUser.getM_no());
            cody_comment.setId(loginUser.getId());
            result.put("cody", codyService.get(co_no));
            result.put("lista", likedService.list(co_no));
            result.put("formcomment", cody_comment);
            return result;
        }
    }

    @RequestMapping("add")
    public Object add(Cody cody, MultipartFile file[], 
            @ModelAttribute(value = "loginUser") Member loginUser)
            throws Exception {
   /*     System.out.println("add controller 실행");
        System.out.println(cody);
        System.out.println(cody.getCo_no());
        System.out.println(loginUser.getM_no());
        */
        
    String uploadDir = servletContext.getRealPath("/download");
        
        ArrayList<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            String Thumbnail = this.Thumbnail(uploadDir,filename,600,600);
            
            cody.setCo_photo(Thumbnail);
            uploadFiles.add(new UploadFile(filename, Thumbnail));
    }
        
        cody.setWriter(loginUser);
        codyService.add(cody);
     
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "uploadFiles");
        return result;

    }

    @RequestMapping("update")
    public Object update(
            Cody cody,
            MultipartFile[] file, 
            @ModelAttribute(value = "loginUser") Member loginUser,
            Liked liked) throws Exception {

        String uploadDir = servletContext.getRealPath("/download");

        ArrayList<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            String Thumbnail = this.Thumbnail(uploadDir,filename,600,600);
            
            cody.setCo_photo(Thumbnail);
            uploadFiles.add(new UploadFile(filename, Thumbnail));
        }
        
        System.out.println(cody.getCo_photo());
        System.out.println(cody.getTitle());


        codyService.update(cody);

        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "uploadFiles");
        return result;
    }

    @RequestMapping("liked")
    public Object liked(
            Cody cody,
            @ModelAttribute(value = "loginUser") Member loginUser,
            Liked liked) throws Exception {

        liked.setCo_no(cody.getCo_no());
        liked.setM_no(loginUser.getM_no());
        liked.setName(loginUser.getId());
        liked.setLikedcount(+1); 
        
        cody.setLiked(liked);
        System.out.println("코디 getliked" + cody.getLiked());
        
        codyService.liked(cody);
        HashMap<String, Object> result = new HashMap<>();
        result.put("like" , liked);
        try {
            codyService.liked(cody);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("중복으로 누를수 없습니다.");
            
        }

        return result;
    }
    
    
    @RequestMapping("likedelete")
    public Object likedelete(
            Cody cody,
            @ModelAttribute(value = "loginUser") Member loginUser,
            Liked liked) throws Exception {

        liked.getCo_no();
        liked.getM_no();
        
        
        codyService.liked(cody);
        HashMap<String, Object> result = new HashMap<>();
        result.put("like" , liked);
        try {
            codyService.liked(cody);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("중복으로 누를수 없습니다.");
            
        }

        return result;
    }

    @RequestMapping("delete")
    public Object  delete(int co_no) throws Exception {
        likedService.delete(co_no);
        codyService.delete(co_no);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("stauts", "success");
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