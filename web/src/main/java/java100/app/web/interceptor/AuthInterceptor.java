package java100.app.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String pathInfo = request.getPathInfo();

        if (!pathInfo.startsWith("/auth")) {

            HttpSession session = request.getSession();

            if (session.getAttribute("loginUser") == null) {
                response.sendRedirect(request.getServletContext().getContextPath() + "/app/auth/login");
                return false;
            }
        }
        return true;
    }
}
