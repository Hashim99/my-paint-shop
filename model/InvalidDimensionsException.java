package model;

/**
 *
 * An exception class to handle problems with shapes dimensions.
 *
 * @see  PaintShopException
 *
 * @author Salem Bamukhier
 *
 */

public class InvalidDimensionsException extends PaintShopException {

	/**
	 * No-arg constructor that calls the no-arg constructor in the super class.
	 */

	public InvalidDimensionsException() {
		super("Invalid Dimensions! \nTry Again.");
	}

	/**
	 * a constructor with specified error message, calls the constructor in the super class.
	 *
	 * @param message descriptive message that is thrown for a particular exception
	 *
	 *
	 */

	public InvalidDimensionsException(String message) {
		super(message);
	}



}
