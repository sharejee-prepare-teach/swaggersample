package com.mkyong.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
public class CustomGenericMessage {

	@JsonProperty("CODE")
	private String code;
	
	@JsonProperty("MESSAGE")
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public CustomGenericMessage(String code, String message){
		this.code = code;
		this.message = message;
	}
	
}
