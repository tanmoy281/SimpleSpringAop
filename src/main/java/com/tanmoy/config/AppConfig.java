package com.tanmoy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.tanmoy.aspect.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.tanmoy.service")
public class AppConfig {

	@Bean
	public LoggingAspect lAspect(){
		return new LoggingAspect();
	}
}
