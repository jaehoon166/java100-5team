package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;
 
public interface MemberService {
    int add(Member member);
    int update(Member member);
    int getTotalCount();
    List<Member> list(int pageNo, int pageSize, Map<String, Object> options);
    int delete(int m_no);
    Member get(int m_no);
    Member get(String email, String pwd);
    public boolean isMatchMemberEmail(String email);
    public boolean isMatchMemberId(String id);
}
