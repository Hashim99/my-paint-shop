package model;

import javafx.scene.paint.Color;


/**
 * @author Hashim Al Ghamdi
 * @author Haitham Al Saeed
 * @author Hussain Al-Bin Hajji
 */



public class Rectangle extends Shape {

	private double width;
	private double length;

	/**
	 * initializing the rectangle
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param width
	 * @param length
	 * @param color
	 * @throws PaintShopException
	 */
	public Rectangle(double xCoordinate, double yCoordinate, double width, double length, Color color)
			throws PaintShopException {

		super(xCoordinate, yCoordinate, width, length, color);
		this.width = width;
		this.length = length;

		if (xCoordinate < 0 || yCoordinate < 0) {
			throw new NegativeCoordinatesException();
		} else if (width <= 0 || length <= 0) {
			throw new InvalidDimensionsException();
		} else {
			setfxShape(new javafx.scene.shape.Rectangle(width, length, color));
			setConnectorValues(getfxShape(), this);
		}

	}

	/**
	 * initializing the rectangle
	 */
	public Rectangle() {
		super();
		this.width = 50;         // width = 50 , length = 30 and Color.BLACK are chosen default values
		this.length = 35;
		setfxShape(new javafx.scene.shape.Rectangle(width, length, Color.BLACK));
		setConnectorValues(getfxShape(), this);
	}

	/**
	 *
	 * @return width
	 */
	public double getWidth() {
		return this.width;
	}

	/**
	 *
	 * @return length
	 */
	public double getLength() {
		return this.length;
	}


	/**
	 * setter for both length and width.
	 * @param newWidth
	 * @param newLength
	 * @throws InvalidDimensionsException
	 */
	public void setDimensions(double newWidth, double newLength) throws InvalidDimensionsException {

		if (newWidth <= 0 || newLength <= 0) {
			throw new InvalidDimensionsException();
		} else {
			this.width = newWidth;
			this.length = newLength;
			((javafx.scene.shape.Rectangle) (this.getfxShape())).setWidth(newWidth);
			((javafx.scene.shape.Rectangle) (this.getfxShape())).setHeight(newLength);
		}

	}

	/**
	 *
	 * @return area
	 */
	public double getArea() {

		return this.width * this.length;
	}

}
