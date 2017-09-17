package com.rizwan.test.springscheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.rizwan.test.springscheduler.service.RefreshTokenService;
import com.rizwan.test.springscheduler.service.impl.RefreshTokenServiceImpl;

@Configuration
@ComponentScan(basePackages="com.rizwan.test")
//@EnableWebMvc
@EnableScheduling
public class AppConfig {

	@Bean
	public RefreshTokenService getRefreshTokenService() {
		return new RefreshTokenServiceImpl();
	}
	
}
