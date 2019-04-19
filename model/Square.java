package model;

import javafx.scene.paint.Color;

public class Square extends Rectangle {
	private double side;  /*we could've used length or width twice but we found that making a new
							 variable "side" would be easier*/

	public Square(double xCoordinate, double yCoordinate, double side, Color color) throws PaintShopException {
		super(xCoordinate, yCoordinate, side, side, color);
		this.side = side;

		if (xCoordinate < 0 || yCoordinate < 0) {
			throw new NegativeCoordinatesException();
		} else if (side <= 0) {
			throw new InvalidDimensionsException();
		} else {
			setfxShape(new javafx.scene.shape.Rectangle(side, side, color)); // no square in javafx library
			setConnectorValues(getfxShape(), this);
		}

	}

	public Square() {
		super();
		side = 50; // side = 50 and Color.Black are chosen default values
		setfxShape(new javafx.scene.shape.Rectangle(side, side, Color.BLACK));
		setConnectorValues(getfxShape(), this);
	}

	/**
	 *
	 * @return side
	 */
	public double getSide() {
		return this.side;
	}

	/**
	 *
	 * @param newSide
	 * @throws InvalidDimensionsException
	 */
	public void setSide(double newSide) throws InvalidDimensionsException {

		if (newSide <= 0) {
			throw new InvalidDimensionsException();
		} else {
			this.side = newSide;
			((javafx.scene.shape.Rectangle) (this.getfxShape())).setWidth(newSide);
			((javafx.scene.shape.Rectangle) (this.getfxShape())).setHeight(newSide);
		}

	}

	/**
	 *
	 * @return area
	 */
	public double getArea() {

		return this.side * this.side; // more convenient than Math.pow
	}

}
