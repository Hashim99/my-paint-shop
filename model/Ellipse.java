package model;

import javafx.scene.paint.Color;

public class Ellipse extends Shape {

	private double axisA;
	private double axisB;

	/**
	 * Initializes an object of type Ellipse using given values.
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param axisA
	 * @param axisB
	 * @param color
	 * @throws PaintShopException
	 */
	public Ellipse(double xCoordinate, double yCoordinate, double axisA, double axisB, Color color)
			throws PaintShopException {

		super(xCoordinate, yCoordinate, axisA, axisB, color);

		if (xCoordinate < 0 || yCoordinate < 0) {
			throw new NegativeCoordinatesException();
		} else if (axisA <= 0 || axisB <= 0) {
			throw new InvalidDimensionsException();
		} else {
			this.axisA = axisA;
			this.axisB = axisB;
			setfxShape(new javafx.scene.shape.Ellipse(xCoordinate, yCoordinate, this.axisA, this.axisB));
			getfxShape().setFill(color);
			setConnectorValues(getfxShape(), this);
		}
	}

	/**
	 * Initializes an object of type Ellipse with an empty constructor.
	 *
	 */
	public Ellipse() {
		super();
		this.axisA = 50;
		this.axisB = 40;
		setfxShape(new javafx.scene.shape.Ellipse(axisA, axisB));
		getfxShape().setFill(Color.BLACK);
		setConnectorValues(getfxShape(), this);
	}

	/**
	 * sets the axises of the ellipse at the same time using given values.
	 * @param newA
	 * @param newB
	 * @throws InvalidDimensionsException
	 */
	public void setAxises(double newA, double newB) throws InvalidDimensionsException {

		if (newA <= 0 || newB <= 0) {
			throw new InvalidDimensionsException();
		} else {
			this.axisA = newA;
			this.axisB = newB;
			((javafx.scene.shape.Ellipse) (this.getfxShape())).setRadiusX(newA);
			((javafx.scene.shape.Ellipse) (this.getfxShape())).setRadiusY(newB);
		}

	}

	/**
	 * sets the horizontal axis of the ellipse using a given value.
	 * @param newA
	 * @throws InvalidDimensionsException
	 */
	public void setAxisA(double newA) throws InvalidDimensionsException {

		if (newA <= 0) {
			throw new InvalidDimensionsException();
		} else {
			this.axisA = newA;
			((javafx.scene.shape.Ellipse) (this.getfxShape())).setRadiusX(newA);
		}

	}

	/**
	 * sets the vertical axis of the ellipse using a given value.
	 * @param newB
	 * @throws InvalidDimensionsException
	 */
	public void setAxisB(double newB) throws InvalidDimensionsException {

		if (newB <= 0) {
			throw new InvalidDimensionsException();
		} else {
			this.axisB = newB;
			((javafx.scene.shape.Ellipse) (this.getfxShape())).setRadiusY(newB);
		}

	}

	/**
	 * returns the horizontal axis of the ellipse.
	 * @return major axis
	 */
	public double getAxisA() {
		return this.axisA;
	}

	/**
	 * returns the vertical axis of the ellipse.
	 * @return minor axis.
	 */
	public double getAxisB() {
		return this.axisB;
	}

	/**
	 * returns the area of the ellipse.
	 * @return area
	 */
	public double getArea() {
		return Math.PI * this.getAxisA() * this.getAxisB();
	}

}
