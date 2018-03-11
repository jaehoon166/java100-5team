package java100.app.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import java100.app.domain.Member;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object handler)
            throws Exception {
        
        
        String pathInfo = request.getPathInfo();

        if (!pathInfo.startsWith("/auth")) {
            
            // 세션 보관소에 "loginUser"가 저장되었는지 검사한다.
            HttpSession session = request.getSession();
            
            
            Member member = (Member) session.getAttribute("loginUser");
            
            //session.getAttribute("loginUser")
            if (member.getM_no() == 0) {
                response.sendRedirect(request.getServletContext().getContextPath() + "/app/auth/login");
                return false;
                // 로그인 된 상태가 아니라면 다음 인터셉터의 실행을 모두 멈추고,
                // 즉시 로그인 폼으로 간다.
            }
        }
        return true;
        
    }
}

