package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Cody;

public interface CodyDao {
    List<Cody> findCodyMemb(Map<String,Object> params);
    List<Cody> findAll(Map<String,Object> params);
    int insert(Cody cody);
    Cody findByNo(int co_no);
    Cody findByNo2(int co_no);
    int countAll();
    int updateViewCount(int co_no);
    int updatelikedCount(int co_no);
    int deletelikedCount(int co_no);
    int update(Cody cody);
    int delete(int co_no);
    int findlikecount(int co_no);
}
