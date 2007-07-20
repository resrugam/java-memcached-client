package net.spy.memcached.ops;

import java.io.IOException;


/**
 * Exceptions thrown when protocol errors occur.
 */
public final class OperationException extends IOException {

	private final Operation.ErrorType type;

	/**
	 * General exception (no message).
	 */
	public OperationException() {
		super();
		type=Operation.ErrorType.GENERAL;
	}

	/**
	 * Exception with a message.
	 *
	 * @param eType the type of error that occurred
	 * @param msg the error message
	 */
	public OperationException(Operation.ErrorType eType, String msg) {
		super(msg.substring(eType.getSize()));
		type=eType;
	}

	/**
	 * Get the type of error.
	 */
	public Operation.ErrorType getType() {
		return type;
	}

	@Override
	public String toString() {
		String rv=null;
		if(type == Operation.ErrorType.GENERAL) {
			rv="OperationException: " + type;
		} else {
			rv="OperationException: " + type + ": " + getMessage();
		}
		return rv;
	}
}
