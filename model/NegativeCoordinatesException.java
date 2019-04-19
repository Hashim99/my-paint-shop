package model;

/**
 *
 * The canvas accepts positive x and y coordinates only, and this class deal with
 * problems involving negative coordinates.
 *
 * @see  PaintShopException
 *
 * @author Salem Bamukhier
 *
 */

public class NegativeCoordinatesException extends PaintShopException {

	/**
	 * No-arg constructor that calls the no-arg constructor in the super class.
	 */

	public NegativeCoordinatesException() {
		super("Negative Coordinates! \nTry Again.");
	}

	/**
	 * a constructor with specified error message, calls the constructor in the super class.
	 *
	 * @param message descriptive message that is thrown for a particular exception
	 *
	 *
	 */

	public NegativeCoordinatesException(String message) {
		super(message);
	}



}
