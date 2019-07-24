package com.example.dto;

import lombok.Data;

/**
 * @author jone
 */
@Data
public class SendSmsDTO {
	private String templateid;

	private String param;

	private String mobile;

	private String uid;
}
