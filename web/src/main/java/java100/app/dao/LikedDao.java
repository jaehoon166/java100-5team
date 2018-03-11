package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Liked;

public interface LikedDao {
    List<Liked> findAll(Map<String,Object> params);
    Liked findBylikeNo(int co_no);
    int insert(Liked liked);
    int deleteAllBylikedNo(int co_no);
    
    //Liked 테이블  코디 리스트에서 한번에 출력
    List<Liked> countAll();
}
