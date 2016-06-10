package com.fprochazka.drill.model.exceptions;

public class DrillCodeNotUniqueException extends Exception {

	public DrillCodeNotUniqueException() {
	}

	public DrillCodeNotUniqueException(String message) {
		super(message);
	}

	public DrillCodeNotUniqueException(String message, Throwable cause) {
		super(message, cause);
	}
}
