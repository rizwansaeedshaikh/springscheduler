package com.rizwan.test.springscheduler.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		@SuppressWarnings("resource")
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.setServletContext(servletContext);
		webContext.register(AppConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		servletContext.setInitParameter("contextConfigLocation", "classpath:applicationContext.xml");
		
		servletContext.addListener(ContextLoaderListener.class);

	}

}
