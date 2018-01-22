package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;
import java100.app.domain.Score;

// 역할을 강조할 떄는 객체 라는 말보다는 컴퓨넌트라는 말을 사용한다.
// Service 컴포넌트
public interface MemberService {

    List<Member> list(int pageNo, int pageSize, Map<String, Object> options);
    Member get(int no);
    int getTotalCount();
    int add(Member member);
    int update(Member member);
    int delete(int no);
    
}
