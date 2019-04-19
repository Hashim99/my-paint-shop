package model;

/**
 *
 * parent class of all the exceptions sub-classes in the program
 *
 * @see Exception
 *
 * @author Salem Bamukhier
 *
 */

public class PaintShopException extends Exception {

	/**
	 * No-arg constructor that calls the no-arg constructor in the super class.
	 *
	 * @see Exception
	 *
	 */
	public PaintShopException() {
		super();
	}

	/**
	 * a constructor with specified error message, calls the constructor in the super class
	 *
	 * @param message descriptive message that is thrown for a particular exception
	 *
	 *
	 */
	public PaintShopException(String message) {
		super(message);
	}



}
