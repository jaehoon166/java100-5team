package java100.app.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java100.app.domain.Member;

// app으로 들어온 모든 요청
//@WebFilter("/app/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
     
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 세션 보관소에 "loginUser"가 저장되었는지 검사한다.
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse =  (HttpServletResponse) response;
        
        
        //getPathInfo() 리턴값은 /app 을 제외한 나머지 url 값이다.
        String pathInfo = httpRequest.getPathInfo();
        System.out.println(pathInfo);
        if (!pathInfo.startsWith("/auth")) {
            
            HttpSession session = httpRequest.getSession();
            if(session.getAttribute("loginUser") == null) {
                httpResponse.sendRedirect(request.getServletContext().getContextPath() + "/app/auth/login");
                return;
            }
            
        }
    
        chain.doFilter(httpRequest, httpResponse);
        
        
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    
    
}
