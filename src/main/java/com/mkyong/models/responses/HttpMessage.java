package com.mkyong.models.responses;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
public class HttpMessage {
	/**
	 * Response message with the successful transaction
	 * 
	 * @param objectName
	 * @param transaction
	 * @return objectName has been transaction successfully.
	 */
	public static String success(String objectName, String transaction) {
		return objectName + " has been " + transaction + " successfully.";
	}

	

	/**
	 * Response message with the fail transaction
	 * 
	 * @param objectName
	 * @param transaction
	 * @return objectName could not transaction.
	 */
	public static String fail(String objectName, String transaction) {
		return objectName + " could not " + transaction + ".";
	}
	
	
	public static String invalid(String objectName, String transaction, String invalidMessage) {
		return objectName + " could not " + transaction + ". " + invalidMessage;
	}

}
