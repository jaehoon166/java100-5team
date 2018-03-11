package java100.app.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        ctx.setAttribute("contextPath", ctx.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
