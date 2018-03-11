package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Cody_Comment;

public interface Cody_CommentDao {
    List<Cody_Comment> findAll(Map<String,Object> params);
    Cody_Comment findBycody_commentMapNo(int co_no);
    Cody_Comment findBycody_commentMapComNo(int com_no);
    int insert(Cody_Comment cody_comment);
    int deleteAllcody_commentNo(int com_no);
    
    int deleteAllcody_commentCoNo(int co_no);
    int update(Cody_Comment cody_comment);
    int countAll();
}
