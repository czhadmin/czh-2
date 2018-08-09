																																																															package com.accp;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;

@Configuration
@ComponentScan
@Import({MybatisConfiguration.class})
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapter {
	//配置视图解析器
		@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setViewClass(JstlView.class);
			resolver.setPrefix("/WEB-INF/");
			resolver.setSuffix(".jsp");
			
			registry.viewResolver(resolver);
			
			super.configureViewResolvers(registry);
		}
		
		//配置静态资源访问<mvc:default-servlet-handler />
		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
			// TODO Auto-generated method stub
			super.configureDefaultServletHandling(configurer);
		}
		
		
		@Bean
		public CommonsMultipartResolver multipartResolver() {
			CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
			commonsMultipartResolver.setMaxInMemorySize(104857600);
			commonsMultipartResolver.setMaxUploadSize(104857600);
			commonsMultipartResolver.setDefaultEncoding("UTF-8");
			return commonsMultipartResolver;
		}
		
		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			{
				//String转换器
				StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("utf-8"));
				List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
				//设置响应头编码，text/html;charset=utf-8
				supportedMediaTypes.add(new MediaType(MediaType.TEXT_HTML, Charset.defaultCharset()));
				converter.setSupportedMediaTypes(supportedMediaTypes);
				
				converters.add(converter);
			}
			
			{
				FastJsonHttpMessageConverter4 converter4 = new FastJsonHttpMessageConverter4();
				List<MediaType> supportedMediaTypes = new ArrayList<>();
			       supportedMediaTypes.add(MediaType.APPLICATION_JSON);
			       supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
			       supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
			       supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
			       supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
			       supportedMediaTypes.add(MediaType.APPLICATION_PDF);
			       supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
			       supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
			       supportedMediaTypes.add(MediaType.APPLICATION_XML);
			       supportedMediaTypes.add(MediaType.IMAGE_GIF);
			       supportedMediaTypes.add(MediaType.IMAGE_JPEG);
			       supportedMediaTypes.add(MediaType.IMAGE_PNG);
			       supportedMediaTypes.add(MediaType.TEXT_PLAIN);
			       supportedMediaTypes.add(MediaType.TEXT_HTML);
			       supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
			       supportedMediaTypes.add(MediaType.TEXT_PLAIN);
			       supportedMediaTypes.add(MediaType.TEXT_XML); 
			       
			       converter4.setSupportedMediaTypes(supportedMediaTypes);
				//配置fastjson
				//设置编码
				converter4.setDefaultCharset(Charset.forName("utf-8"));
				//解决重复引用
				JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
				FastJsonConfig fastJsonConfig = new FastJsonConfig();
//				fastJsonConfig.setDateFormat("yyy-MM-dd");
				converter4.setFastJsonConfig(fastJsonConfig);
				converters.add(converter4);
				
				
			}
			super.configureMessageConverters(converters);
		}
}
