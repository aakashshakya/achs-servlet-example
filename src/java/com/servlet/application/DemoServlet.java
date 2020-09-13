package com.servlet.application;


import javax.servlet.*;
import java.io.IOException;

public class DemoServlet implements Servlet {
   private ServletConfig config = null;
   @Override
   public void init(ServletConfig servletConfig) throws ServletException {
       System.out.println("Inside init servlet.");
       this.config = servletConfig;
   }

   @Override
   public ServletConfig getServletConfig() {
       return null;
   }

   @Override
   public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
       System.out.println("Servlet service");
   }

   @Override
   public String getServletInfo() {
       return null;
   }

   @Override
   public void destroy() {
       System.out.println("Destroying the servlet.");
   }
}
