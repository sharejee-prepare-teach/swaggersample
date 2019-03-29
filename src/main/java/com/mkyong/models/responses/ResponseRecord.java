package com.mkyong.models.responses;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
public class ResponseRecord<T> extends Response{
	/*
	 * Response record class using with single object
	 */
	private T data;

	
	
	public ResponseRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseRecord(String message, boolean status, T data) {
		super(message, status);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
