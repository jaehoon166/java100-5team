package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;

public interface MemberDao {
    
    int insert(Member member);
    
    List<Member> findAll(Map<String, Object> params);
   
    int countAll();
   
    int delete(int m_no);

    Member findByNo(int m_no);
    
    int update(Member member);

    Member findByEmailAndPassword(Map<String,Object> params);
    
    // 이메일 중복검사
    Member findByEmail(String email);
    
    // 아이디 중복검사
    Member findById(String id);
}















