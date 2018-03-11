package java100.app.web.json;

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

import java100.app.dao.Cody_CommentDao;
import java100.app.domain.Cody_Comment;
import java100.app.domain.Member;
import java100.app.service.Cody_CommentService;

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
    public Object add(Cody_Comment cody_comment) throws Exception {

        System.out.println("이곳에 오긴 옴~~");
        
        System.out.println(cody_comment+"덧글~~~~~~~~~~~~");
        
        HashMap<String, Object> result = new HashMap<>();
       
        cody_commentService.add(cody_comment);
        
        return result;
    }
    
    @RequestMapping("{com_no}")
    public String view(@PathVariable int com_no, Model model, Cody_Comment cody_comment) throws Exception {

      
        model.addAttribute("commentByCom_no", cody_commentService.getComNo(com_no));
       
        
        return "cody_comment/view";
    }
    
    @RequestMapping("form")
    public String form(Cody_Comment cody_comment, Model model, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {
        
        
        return "cody_comment/form";
        
    }
   
    
    @RequestMapping("update")
    public String update(Cody_Comment cody_comment, Model model, @ModelAttribute(value = "loginUser") Member loginUser) throws Exception {

     
        cody_commentService.update(cody_comment);

        return "redirect:../cody/list";
    }
    
    
    @RequestMapping("delete")
    public String delete(int com_no) throws Exception {

        System.out.println(com_no+"도착!!!!!!!!!!");
        cody_commentService.delete(com_no);
        return "redirect:../cody/list";
        
                }
    
    
}
