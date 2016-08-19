package com.zj.configguration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zj.book.controller")
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	private final static String CONTENT_TYPE = "text/html;charset=utf-8";

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public VelocityConfigurer getVelocityConfig(){
		Properties properties = new Properties();
		properties.put("input.encoding", "UTF-8");
		properties.put("output.encoding", "UTF-8");
		properties.put("contentType", CONTENT_TYPE);
		
		VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
		velocityConfigurer.setResourceLoaderPath("WEB-INF/views/");
		velocityConfigurer.setVelocityProperties(properties);
		return velocityConfigurer;
	}
	
	
	@Bean
	public ViewResolver getViewResolver(){
		
		VelocityViewResolver velocityView = new VelocityViewResolver();
		velocityView.setSuffix(".html");
		velocityView.setAllowRequestOverride(true);
		velocityView.setAllowSessionOverride(true);
		velocityView.setExposeRequestAttributes(true);
		velocityView.setExposeSessionAttributes(true);
		velocityView.setRequestContextAttribute("rc");
		velocityView.setDateToolAttribute("dateTool");
		velocityView.setNumberToolAttribute("numberTool");
		velocityView.setContentType(CONTENT_TYPE);
		return velocityView;
	}
	
}
