package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.conf.SmsProperties;
import com.example.dto.SendSmsDTO;
import com.example.enums.ENUM_SMSAPI_URL;
import com.example.service.ISmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author jone
 */
public class ISmsServiceImpl implements ISmsService {

	@Autowired
	private RestTemplate restTemplate;

	private String appid;

	private String accountSid;

	private String authToken;

	public ISmsServiceImpl(SmsProperties properties) {
		this.appid = properties.getAppid();
		this.accountSid = properties.getAccoutSid();
		this.authToken = properties.getAuthToken();
	}

	/**
	 * 单独发送
	 * @param smsDTO dto
	 * @return string
	 */
	@Override
	public String sendSms(SendSmsDTO smsDTO) {
		JSONObject object = new JSONObject();
		object.put("sid", accountSid);
		object.put("token", authToken);
		object.put("appid", appid);
		object.put("templateid", smsDTO.getTemplateid());
		object.put("param", smsDTO.getParam());
		object.put("mobile", smsDTO.getMobile());
		if (smsDTO.getUid() != null) {
			object.put("uid", smsDTO.getUid());
		}
		else {
			object.put("uid", "");
		}
		String s = JSON.toJSONString(object);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Object> objectHttpEntity = new HttpEntity<Object>(s, httpHeaders);
		restTemplate.postForObject(ENUM_SMSAPI_URL.SENDBATCHSMS.getUrl(), objectHttpEntity,String.class);
		return null;
	}

	/**
	 * 批量发送
	 * @param smsDTO dto
	 * @return string
	 */
	@Override
	public String sendBatchSms(SendSmsDTO smsDTO) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("sid", accountSid);
		jsonObject.put("token", authToken);
		jsonObject.put("appid", appid);
		jsonObject.put("templateid", smsDTO.getTemplateid());
		jsonObject.put("param", smsDTO.getParam());
		jsonObject.put("mobile", smsDTO.getMobile());
		if (smsDTO.getUid()!=null){
			jsonObject.put("uid",smsDTO.getUid());
		}else {
			jsonObject.put("uid","");
		}
		String json = JSONObject.toJSONString(jsonObject);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
		String result = restTemplate.postForObject(ENUM_SMSAPI_URL.SENDBATCHSMS.getUrl(), httpEntity, String.class);
		return result;

	}
}
