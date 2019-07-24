package com.example.enums;

import lombok.Getter;

/**
 * @author jone
 */

@Getter
public enum ENUM_SMSAPI_URL {
//
	SENDSMS("https://open.ucpaas.com/ol/sms/sendsms"),
	SENDBATCHSMS("https://open.ucpaas.com/ol/sms/sendsms_batch");
	private String url;

	ENUM_SMSAPI_URL(String url) {
		this.url = url;
	}
}
