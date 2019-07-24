package com.example.service;

import com.example.dto.SendSmsDTO;

/**
 * @author jone
 */
public interface ISmsService {

	/**
	 * 单独发送
	 * @param smsDTO dto
	 * @return string
	 */
	String sendSms(SendSmsDTO smsDTO);

	/**
	 * 批量发送
	 * @param smsDTO dto
	 * @return string
	 */
	String sendBatchSms(SendSmsDTO smsDTO);
}
