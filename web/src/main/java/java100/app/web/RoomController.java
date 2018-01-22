package java100.app.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java100.app.dao.RoomDao;
import java100.app.domain.Board;
import java100.app.domain.Room;
import java100.app.service.RoomService;


@Controller
@RequestMapping("/room")
public class RoomController {
    
    
    @Autowired RoomService roomService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            
            @RequestParam(value="word", required=false) String[] words,
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
        
        int totalCount =  roomService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 모델에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", roomService.list(pageNo, pageSize, options));
        return "room/list";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "room/form";
    }
    
    @RequestMapping("add")
    public String add(Room room) throws Exception {
        
        roomService.add(room);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        roomService.delete(no);
        return "redirect:list";
    }
}
