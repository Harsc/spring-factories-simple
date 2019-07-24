package com.example.conf;

import com.example.service.ISmsService;
import com.example.service.impl.ISmsServiceImpl;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jone
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {

	@Bean
	public ISmsService smsService(SmsProperties properties) {
		return new ISmsServiceImpl(properties);
	}
}
