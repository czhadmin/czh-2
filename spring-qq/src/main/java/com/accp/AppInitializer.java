package com.accp;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
//ȡ��web.xml
public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context=null;
		{
			//ע�������ļ�������������
			context = new AnnotationConfigWebApplicationContext();
			//ָ���������ļ�
			context.register(AppConfiguration.class);
		}
		{
			//ע��DispatcherServlet
			DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
			ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
			servlet.setLoadOnStartup(1);
			servlet.addMapping("/");
		}
		{
			//ע�������
			CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("utf-8");
			
			FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
			//����������·��
			filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		}
		
	}

}
