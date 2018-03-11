package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Member;
import java100.app.domain.UploadFile;
import java100.app.service.CodyService;
import java100.app.service.MemberService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/member")
public class MemberController {
   
    @Autowired ServletContext servletContext;
    @Autowired MemberService memberService;
    @Autowired CodyService codyService;
    
    static Logger logger = Logger.getLogger(MemberController.class);
    
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align
            ) throws Exception {

        logger.fatal("fatal.......");
        logger.error("error........");
        logger.warn("warn.........");
        logger.info("info.........");
        logger.debug("debug..........");
        logger.trace("trace ,........");
        
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
        
        
        int totalCount = memberService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        HashMap<String, Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", memberService.list(pageNo, pageSize, options));
        
        return result;
    }

    @RequestMapping("{m_no}")
    public Object view(@PathVariable int m_no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("codybook", codyService.listCodyMemb(m_no));
        result.put("member", memberService.get(m_no));
        
        result.put("data", memberService.get(m_no));
        return result;
    }

    @RequestMapping("add")
    public Object add(Member member) throws Exception {
        
        memberService.add(member);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status" , "success"); 
        return result;
    }
    
    
    @RequestMapping("update")
    public Object update(
            Member member, MultipartFile file[]) throws Exception {
       
        String uploadDir = servletContext.getRealPath("/download");
        
        ArrayList<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile part : file) {
            if (part.isEmpty())
                continue;
            String filename = this.writeUploadFile(part, uploadDir);
            String Thumbnail = this.Thumbnail(uploadDir,filename,150,150);
            
            member.setM_photo(Thumbnail);
            uploadFiles.add(new UploadFile(filename, Thumbnail));
            
    }
        memberService.update(member);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "uploadFiles");
        return result;
    }
    
    @RequestMapping("delete")
    public Object delete(int m_no) throws Exception {

        memberService.delete(m_no);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    long prevMillis = 0;
    int count = 0;
    
    // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
    // 파일명에서 뒤의 확장자명을 추출한다.
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
    
    // 이메일 중복검사를 실행
    @RequestMapping(value = "check-memb-email", method = RequestMethod.GET)
    @ResponseBody
    public String checkMembEmail(@RequestParam String email) throws Exception {
        boolean exist = memberService.isMatchMemberEmail(email);
        System.out.println(exist);
        return "{\"success\": " + exist + "}";
    }
    
    // 아이디 중복검사를 실행
    @RequestMapping(value = "check-memb-id", method = RequestMethod.GET)
    @ResponseBody
    public String checkMembId(@RequestParam String id) throws Exception {
        boolean exist = memberService.isMatchMemberId(id);
        return "{\"success\": " + exist + "}";
    }
}








