package java100.app.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
    @Autowired MemberDao memberDao;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            
            @RequestParam(value="nm", required=false) String[] names,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        
        if(pageNo < 1) {
            pageNo = 1;
        }
        
        if(pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        
        
        
        HashMap<String,Object> options = new HashMap<>();
        options.put("names", names);
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount =  memberService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 모델에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", memberService.list(pageNo, pageSize, options));
        
        
        return "member/list";
    }
    @RequestMapping("add")
    public String add(Member member) throws Exception {
 
            
        memberService.add(member);
        
        return "redirect:list";
    }
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        memberService.delete(no);
        
        
        return "redirect:list";
    }
    @RequestMapping("form")
    public String form() throws Exception {
        
        
        return "member/form";
    }
    @RequestMapping("update")
    public String update(Member member) throws Exception {
        
         
        memberService.update(member);
        
      
        return "redirect:list";
    }
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        
       
        Member member = memberService.get(no);
        
        model.addAttribute("member", member);
        
       
        return "member/view";
    } 
    
    
}
