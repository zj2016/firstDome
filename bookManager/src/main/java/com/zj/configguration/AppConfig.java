package com.zj.configguration;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zj.book.cache.Cache;
import com.zj.book.cache.impl.RedisCache;

@Configuration
@ComponentScan(basePackages = {"com.zj.book.service.impl"})
@EnableTransactionManagement
@PropertySource(value = "classpath:conf/mybatis/system.properties")
public class AppConfig implements EnvironmentAware{

	private Environment environment;
	
	
	public void setEnvironment(Environment arg0) {
		this.environment = arg0;
	}
	
	//配置redis
	@Bean
	public Cache getRedis(){
		Cache cache = new RedisCache();
		System.out.println(environment.getProperty("redis.url") + "  " + environment.getProperty("redis.database"));
		cache.init(environment.getProperty("redis.url"), Integer.valueOf(environment.getProperty("redis.database")));
		
		return cache;
	}
	
	//配置数据库
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println(environment.getProperty("jdbc.driver") + "==" + environment.getProperty("jdbc.url"));
		dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	
	//配置sqlsessionfactory
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:conf/mybatis/mappers/**/*.xml"));
		
		return sqlSessionFactory;
	}
	
	//配置mybatis
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapper = new MapperScannerConfigurer();
		mapper.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapper.setBasePackage("com.zj.book.mapper");
		
		return mapper;
	}
	
}
