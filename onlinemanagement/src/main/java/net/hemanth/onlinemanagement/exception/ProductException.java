package net.hemanth.onlinemanagement.exception;

import java.io.Serializable;

public class ProductException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductException() {
		this("Product is not available!");
	}
	
	public ProductException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}

	public String getMessage() {
		return message;
	}
}