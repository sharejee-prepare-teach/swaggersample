package com.mkyong.exceptions;

import org.springframework.validation.Errors;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
public class InvalidRequestException extends RuntimeException {
	
	private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() { return errors; }

}
