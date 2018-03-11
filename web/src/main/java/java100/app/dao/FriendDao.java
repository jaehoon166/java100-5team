package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Friend;

public interface FriendDao {
 
    List<Friend> findFriend(Map<String,Object> params);
    Friend findByMyNo(int m_no);

    int insert(Friend friend);
    int deleteAllfriendNo(Friend friend);
    
    
    int countAll();
    
}
