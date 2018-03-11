package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Cody;
import java100.app.domain.Liked;

public interface CodyService {
   
    List<Cody> listCodyMemb(int m_no);
    
    List<Cody> list(int pageNo, int pageSize, Map<String, Object> options);
    
    int add(Cody cody);
    int getTotalCount();
    Cody get(int co_no);
    int update(Cody cody);
    int delete(int co_no);
    int liked(Cody cody);
    int findlikecount(int co_no);
    int deleteliked(Cody cody);
}
