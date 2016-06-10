package com.fprochazka.drill.model.exceptions;

/**
 * Created by Michaela Bamburová on 10.06.2016.
 */
public class UcoNotUniqueException extends  Exception {

	public UcoNotUniqueException() {
	}

	public UcoNotUniqueException(String message) {
		super(message);
	}

	public UcoNotUniqueException(String message, Throwable cause) {
		super(message, cause);
	}
}
