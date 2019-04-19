package model;

import javafx.scene.paint.Color;

public class Circle extends Ellipse {

	private double radius;

	/**
	 * Initializes an object of type Circle using given values.
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param radius
	 * @param color
	 * @throws PaintShopException
	 */
	public Circle(double xCoordinate, double yCoordinate, double radius, Color color) throws PaintShopException {
		super(xCoordinate, yCoordinate, radius, radius, color);

		{
			if (xCoordinate < 0 || yCoordinate < 0) {
				throw new NegativeCoordinatesException();
			} else if (radius <= 0) {
				throw new InvalidDimensionsException();
			} else {
				this.radius = radius;
				setfxShape(new javafx.scene.shape.Circle(xCoordinate, yCoordinate, this.radius, color));

				setConnectorValues(getfxShape(), this);
			}
		}
	}

	/**
	 * Initializes an object of type Circle with an empty constructor.
	 *
	 */
	public Circle() {
		super();
		radius = 50;
		setfxShape(new javafx.scene.shape.Circle(50, Color.BLACK));
		setConnectorValues(getfxShape(), this);
	}

	/**
	 * returns the radius of the circle.
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * sets the radius of the circle using a given value.
	 * @param newRadius
	 */
	public void setRadius(double newRadius) throws InvalidDimensionsException {

		if (newRadius <= 0) {
			throw new InvalidDimensionsException();
		} else {
			this.radius = newRadius;
			((javafx.scene.shape.Circle) (this.getfxShape())).setRadius(newRadius);
		}

	}

	/**
	 * returns the area of the circle.
	 * @return area
	 */
	public double getArea() {
		return Math.PI * this.getRadius() * this.getRadius();
	}

}
