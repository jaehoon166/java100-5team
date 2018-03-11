package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java100.app.domain.Member;
import java100.app.service.MemberService;


@RestController
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class LoginController {
   
    
    @Autowired MemberService memberService;
    
    @RequestMapping(value="login")
    public Object login(
            String email, 
            String pwd,
            String saveEmail,
            HttpServletResponse response,
            HttpSession session,
            Model model) {
        
        Member member = memberService.get(email, pwd);
        
        if (saveEmail != null) {
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
  
        HashMap<String,Object> result = new HashMap<>();
        
        if (member == null) {
            model.addAttribute("loginUser", null);
            result.put("status", "fail"); 
        } else {
            model.addAttribute("loginUser", member);
            result.put("status", "success");
        }
        return result;
    }
    
    @RequestMapping("logout")
    public Object logout(HttpSession session, SessionStatus status) {
        
        // @SessionAttributes에서 관리하는 세션 데이터를 모두 제거한다.
        status.setComplete();
        
        // HttpSession 객체를 무효화시킨다.
        session.invalidate();
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("loginUser")
    public Object loginUser(HttpSession session) throws Exception{
        
        Member member = (Member)session.getAttribute("loginUser");
        
        HashMap<String,Object> result = new HashMap<>();
       
   if (member.getM_no() != 0) {
          
            result.put("status", "success");
            result.put("member", member);
        } else {
            result.put("status", "fail");
        }
      
      
        return result;
    }
}










