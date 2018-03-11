package java100.app.service;

import java.util.List;

import java100.app.domain.Cody_Comment;

public interface Cody_CommentService {
   
    List<Cody_Comment> list(int co_no);
    Cody_Comment get(int co_no);
    Cody_Comment getComNo(int com_no);
    
    int update(Cody_Comment cody_comment);
    int getTotalCount();
    int add(Cody_Comment cody_comment);
    int delete(int com_no);
    int deleteByCo_no(int co_no);
}
