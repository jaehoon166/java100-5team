package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.FriendDao;
import java100.app.domain.Friend;
import java100.app.service.FriendService;

@Service
public class FriendSerivceimpl implements FriendService{
    @Autowired FriendDao friendDao;

    @Override
    public List<Friend> list(int m_no) {

        HashMap<String, Object> params = new HashMap<>();
       
        params.put("m_no", m_no);
       
        return friendDao.findFriend(params);
    }

    @Override
    public Friend get(int m_no) {
  /* System.out.println(m_no+"도착!");*/
        
        Friend friend = friendDao.findByMyNo(m_no);

        return friend;
    }

    @Override
    public int getTotalCount() {
        
        return friendDao.countAll();
    }

    @Override
    public int add(Friend friend) {
        int count = friendDao.insert(friend);
     /*   System.out.println(friend+"잘도착함~~~~~~~~~~~~~~~~");*/
        
        
        return count;
    }

    @Override
    public int delete(Friend friend) {
        
        int count = friendDao.deleteAllfriendNo(friend);
        
        return count;
    }
}
