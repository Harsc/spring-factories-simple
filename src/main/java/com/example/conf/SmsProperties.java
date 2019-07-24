package com.example.conf;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jone
 */
@Data
@ConfigurationProperties(value = "sms-config")
public class SmsProperties {
	private String appid;

	private String accoutSid;

	private String authToken;
}
