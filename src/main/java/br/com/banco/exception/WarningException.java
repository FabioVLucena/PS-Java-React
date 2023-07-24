package br.com.banco.exception;

public class WarningException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6208639110446954203L;

	public WarningException(String errorMessage) {
		super(errorMessage);
	}
}
