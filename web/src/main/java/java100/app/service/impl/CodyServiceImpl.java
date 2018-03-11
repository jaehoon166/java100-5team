package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.CodyDao;
import java100.app.dao.FileDao;
import java100.app.dao.LikedDao;
import java100.app.domain.Cody;
import java100.app.domain.Liked;
import java100.app.service.CodyService;

@Service
public class CodyServiceImpl implements CodyService{
   

    @Autowired CodyDao codyDao;
    @Autowired FileDao fileDao;
    @Autowired LikedDao likedDao;

    @Override
    public List<Cody> list(int pageNo, int pageSize, Map<String, Object> options) {

        HashMap<String, Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);

        if (options != null) {
            params.putAll(options);
        }

        return codyDao.findAll(params);
    }
    
    
    @Override
    public Cody get(int co_no) {
        codyDao.updateViewCount(co_no);

        Cody cody = codyDao.findByNo2(co_no);

        return cody;
    }

    @Override
    public int getTotalCount() {
        return codyDao.countAll();
    }

    @Override
    public int add(Cody cody) {

        return codyDao.insert(cody);
        
    }

    @Override
    public int update(Cody cody) {
      
        int count = codyDao.update(cody);
        //fileDao.deleteAllByBoardNo(cody.getCo_no());
        return count;
    }
    
    @Override
    public int liked(Cody cody) {
            int count = likedDao.insert(cody.getLiked());
            codyDao.updatelikedCount(cody.getCo_no());
/*            System.out.println("코디 서비스 번호 =" + count );
            System.out.println("코디 서비스에서 코디 게시물 번호" + cody.getCo_no());
            System.out.println("cody" + cody.getCo_no());
            System.out.println(" 코디 tostring ==" + cody.toString());
*/        
        return count;
    }
    
    @Override
    public int delete(int co_no) {
        return codyDao.delete(co_no);
    }


    @Override
    public int findlikecount(int co_no) {
        return codyDao.findlikecount(co_no);
    }

    // 좋아요 두번클릭시 -1 
    @Override
    public int deleteliked(Cody cody) {
      return codyDao.deletelikedCount(cody.getCo_no());
    }


    @Override
    public List<Cody> listCodyMemb(int m_no) {
        HashMap<String, Object> params = new HashMap<>();
        
        params.put("memb_no", m_no);

        return codyDao.findCodyMemb(params);
    }

}
