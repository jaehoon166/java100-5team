package java100.app.web.json;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.dao.Cody_CommentDao;
import java100.app.domain.Cody;
import java100.app.domain.Cody_Comment;
import java100.app.domain.Friend;
import java100.app.domain.Member;
import java100.app.service.CodyService;
import java100.app.service.Cody_CommentService;
import java100.app.service.FriendService;

@RestController
@RequestMapping("/friend")
@SessionAttributes("loginUser")
public class FriendController {

    
    @Autowired ServletContext servletContext;
    @Autowired FriendService friendService;
    
    
    @Autowired
    Cody_CommentDao cody_commentDao;

    @Autowired
    CodyService codyService;
    
    @Autowired
    Cody_CommentService cody_commentService;
   
    
    @ModelAttribute(value = "loginUser")
    public Member loginUser() {
        
        Member loginUser = new Member();
        
        return loginUser;
    }
    
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value = "pn", defaultValue = "1") int pageNo,
            @RequestParam(value = "ps", defaultValue = "5") int pageSize,
            @RequestParam(value = "name", required = false) String[] names,
            @RequestParam(value = "oc", required = false) String orderColumn,
            @RequestParam(value = "al", required = false) String align,
            // fd_no  등록된  친구의 m_no
            @RequestParam(value="fd_no", required=false) String fd_no,
            // show_no  등록된 친구 id 
            @RequestParam(value="show_no", required=false) String show_no,
            // cody_no 게시물 no
            @RequestParam(value="codyNo", required=false) String codyNo,
            // codyWno 게시물 작성자 m_no
            @RequestParam(value="codyWno", required=false) String codyWno,
            
            // show_photo 댓글 등록시 로그인유저 사진
            @RequestParam(value="show_photo", required=false) String show_photo,
            
            @ModelAttribute(value = "loginUser") Member loginUser,
            Friend friend,
            Cody_Comment cody_comment) throws Exception {

        if (pageNo < 1) {
            pageNo = 1;
        }

        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }

        HashMap<String, Object> options = new HashMap<>();
        if (fd_no != null) {
            options.put("words", fd_no);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = friendService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        
 HashMap<String, Object> result = new HashMap<>();
        
        if (codyNo != null && codyWno != null) {
            
          
            
            int co_noo = Integer.parseInt(codyNo);
            cody_comment.setCo_no(co_noo);
            cody_comment.setM_no(loginUser.getM_no());
            cody_comment.setId(loginUser.getId());
            cody_comment.setM_photo(loginUser.getM_photo());
            
            result.put("formcomment", cody_comment);
            
            Cody cody = codyService.get(co_noo);
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
            cody.setChangetime(time.format(cody.getDatetime()));
            
            result.put("cody", cody);
            result.put("comment", cody_commentService.list(co_noo));
            
           
            
        }
        
        if (show_no != null) {
            
         
            result.put("showNumber", show_no);
        }
        
        if (fd_no != null) {
        System.out.println(fd_no);
        int m_no2 = Integer.parseInt(fd_no);
        
        
        friend.setM_no(loginUser.getM_no());
        friend.setM_no2(m_no2);
        
        
        
        friendService.delete(friend);
      /*  result.put("deletefd" , friend);*/
        
        }
        
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        
    
        if(loginUser.getM_no() != 0) {
            
        result.put("findByMyNo", friendService.get(loginUser.getM_no()));
        result.put("findFriend", friendService.list(loginUser.getM_no()));

        }
        
      
        result.put("loginUser", loginUser);
        return result;
    }
   
    
    @RequestMapping("add")
    public Object add(
                @ModelAttribute(value = "loginUser") Member loginUser, 
                @RequestParam(value="writer_no", required=false) String writer_no,
                Friend friend) throws Exception {

      
        friend.setM_no(loginUser.getM_no());
        
        int wr_no = Integer.parseInt(writer_no);
        HashMap<String, Object> result = new HashMap<>();
        friend.setM_no2(friendService.get(wr_no).getM_no());
        friend.setId(friendService.get(wr_no).getId());
        
        try {
        friendService.add(friend);
        } catch (Exception e) {
            
           System.out.println("follow 컨트롤러 오류!");
        }
        
        return result;
    }
    
    @RequestMapping("delete")
    public Object delete(int m_no, int m_no2, Friend friend) throws Exception {

        
        friend.setM_no(m_no);
        friend.setM_no2(m_no2);
        
        friendService.delete(friend);
        HashMap<String, Object> result = new HashMap<>();
        
        return result;
    }
}
