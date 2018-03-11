package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.Cody_CommentDao;
import java100.app.domain.Cody_Comment;
import java100.app.service.Cody_CommentService;

@Service
public class Cody_CommentServiceImpl implements Cody_CommentService {
    
    @Autowired Cody_CommentDao cody_commentDao;
    
    @Override
    public List<Cody_Comment> list(int co_no) {
        
        HashMap<String, Object> params = new HashMap<>();
        
        params.put("co_no", co_no);
        
        return cody_commentDao.findAll(params);
        
    }

    @Override
    public Cody_Comment get(int co_no) {

        Cody_Comment cody_comment = cody_commentDao.findBycody_commentMapNo(co_no);

        return cody_comment;
    }

    @Override
    public Cody_Comment getComNo(int com_no) {
        Cody_Comment cody_comment = cody_commentDao.findBycody_commentMapComNo(com_no);

        return cody_comment;
    }

    @Override
    public int update(Cody_Comment cody_comment) {
        int count = cody_commentDao.update(cody_comment);

        return count;
    }

    @Override
    public int getTotalCount() {
        return cody_commentDao.countAll();
    }

    @Override
    public int add(Cody_Comment cody_comment) {
        int count = cody_commentDao.insert(cody_comment);

        return count;
    }

    @Override
    public int delete(int com_no) {
        return cody_commentDao.deleteAllcody_commentNo(com_no);
    }

    @Override
    public int deleteByCo_no(int co_no) {
        return cody_commentDao.deleteAllcody_commentCoNo(co_no);
    }

}
