package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired MemberDao memberDao;

    static Logger logger = Logger.getLogger(MemberServiceImpl.class);
    
    
    @Override
    public List<Member> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        logger.debug("MemberService.list()..... 호출됨 ");
        HashMap<String, Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);

        if (options != null) {
            params.putAll(options);
        }

        return memberDao.findAll(params);
    }
    
    @Override
    public Member get(String email, String pwd) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("pwd", pwd);
        
        return memberDao.findByEmailAndPassword(params);
    }
    @Override
    public Member get(int m_no) {
        return memberDao.findByNo(m_no);
    }

    @Override
    public int getTotalCount() {
        return memberDao.countAll();
    }
    @Override
    public int add(Member member) {

        return memberDao.insert(member);
    }
 
    @Override
    public int update(Member member) {
        return memberDao.update(member);
    }

    @Override
    public int delete(int m_no) {
        return memberDao.delete(m_no);
    }
    
    @Override
    public boolean isMatchMemberId(String id) {
        return memberDao.findById(id) == null;
    }
    @Override
    public boolean isMatchMemberEmail(String email) {
        return memberDao.findByEmail(email) == null;
    }
    
}
