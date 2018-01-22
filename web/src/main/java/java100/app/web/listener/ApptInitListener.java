package java100.app.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApptInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 웹 애플리케이션이 시작될떄 호출
        ServletContext ctx = sce.getServletContext();
        
        ctx.setAttribute("contextPath", ctx.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
     // 웹 애플리케이션이 종료될떄 호출
        
    }

    
    
}
