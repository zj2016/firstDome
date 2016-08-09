package com.zj.configguration;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.zj.book.service.impl"})
public class AppConfig implements EnvironmentAware{

	private Environment environment;
	
	@Override
	public void setEnvironment(Environment arg0) {
		this.environment = arg0;
	}
	
	
	

}
