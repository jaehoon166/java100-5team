package java100.app.service;

import java.util.List;

import java100.app.domain.Friend;

public interface FriendService {
    List<Friend> list(int m_no);
    Friend get(int m_no);
    
    //int update(Cody_Comment cody_comment);
    
    int getTotalCount();
    
    int add(Friend friend);
    int delete(Friend friend);
}
