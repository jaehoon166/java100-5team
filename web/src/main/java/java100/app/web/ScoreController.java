package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.dao.ScoreDao;
import java100.app.domain.Score;
import java100.app.service.ScoreService;

// @Component 대신 @Controller를 붙여 페이지 컨트롤러임을 명시한다.
// 스프링 IoC 컨테이너에서 애노테이션 중에서 객체 생성을 표시하는 애노테이션
// @Component : 일반 클래스에 대해 주로 붙인다.
// @Controller : 웹애플리케이션에서 페이지 컨트롤러 역할을 수행하는 클래스
// @Service : MVC 아키텍처에서 Model 중에 비즈니스 로직을 담당하는 클래스에 붙인다.
// @Repository : MVC 아키텍처의 Model 중에서 데이터 처리를 담당하는 클래스에 붙인다, 주로 DAO 클래스에 붙인다.

 
@Controller
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreService scoreService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
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
        options.put("words", words);
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount =  scoreService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 모델에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", scoreService.list(pageNo, pageSize, options));
        return "score/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("score", scoreService.get(no));
        return "score/view";        
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "score/form";
    }
    
    @RequestMapping("add")
    public String add(Score score) throws Exception {
        
       
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Score score) throws Exception {
        
        scoreService.update(score);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
       
        return "redirect:list";
    }
    
   
    
   
    
   
}
