package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.LikedDao;
import java100.app.domain.Liked;
import java100.app.service.LikedService;

@Service
public class LikedServiceImpl implements LikedService {

    @Autowired LikedDao likedDao;
    
    @Override
    public List<Liked> list(int co_no) {
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("co_no", co_no);
        
        return likedDao.findAll(params);
    }

    @Override
    public Liked get(int co_no) {
        
        Liked liked = likedDao.findBylikeNo(co_no);
        
        return liked;
    }

    @Override
    public int add(Liked liked) {
        
        int count = likedDao.insert(liked);
        return count;
    }

    @Override
    public int delete(int co_no) {
       return likedDao.deleteAllBylikedNo(co_no);
    }

    
    //Liked 테이블  코디 리스트에서 한번에 출력
    @Override
    public List<Liked> getAll() {
        return likedDao.countAll();
    }
    
    

}
