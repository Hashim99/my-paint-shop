package model;

import javafx.scene.paint.Color;

import java.util.HashMap;

/**
 * @author Hashim Al Ghamdi
 * @author Haitham Al Saeed
 * @author Hussain Al-Bin Hajji
 */

public abstract class Shape {
	private double xCoordinate;
	private double yCoordinate;
	private double layerWidth;
	private double layerLength;
	private Color color;
	private Color strokeColor;
	/**
	 * reference to gain access to javafx library
	 */
	private javafx.scene.shape.Shape fxShape;
	/**
	 * to always connect our shape to the fxShape.
	 */
	private static HashMap<javafx.scene.shape.Shape, Shape> connector;

	public Shape(double xCoordinate, double yCoordinate, double layerWidth, double layerLength, Color color)
			throws PaintShopException {

		if (xCoordinate < 0 || yCoordinate < 0) {
			throw new NegativeCoordinatesException();
		}

		else if (layerWidth <= 0 || layerLength <= 0) {
			throw new InvalidDimensionsException();
		} else {

			this.xCoordinate = xCoordinate;
			this.yCoordinate = yCoordinate;
			this.layerWidth = layerWidth;
			this.layerLength = layerLength;
			this.color = color;
			fxShape = null; // // we can't make fxshape without knowing the type
			connector = new HashMap<>();
		}

	}

	public Shape() {

		this.xCoordinate = 0.0;
		this.yCoordinate = 0.0;
		this.layerWidth = 0.0;
		this.layerLength = 0.0;
		this.color = Color.BLACK;
		this.strokeColor = Color.BLACK;
		fxShape = null;
		connector = new HashMap<>();
	}

	/**
	 *
	 * @return outline color
	 */
	public Color getStroke() {
		return this.strokeColor;
	}

	/**
	 *
	 * @param newColor
	 */
	public void setStroke(Color newColor) {
		this.strokeColor = newColor;
		this.fxShape.setStroke(newColor); // stroke = outline
	}

	/**
	 * Takes the fxSahpe object, and returns the associated Shape object from the map.
	 * @param fxShape
	 * @return Shape object, from MyPaintShop no FX.
	 */
	public static Shape getShape(javafx.scene.shape.Shape fxShape) {
		return connector.get(fxShape);
	}

	/**
	 * used to connect both the fxShape and the Shape in a map.
	 * Called with the construction of every object.
	 * @param fxShape
	 * @param shape
	 */
	public void setConnectorValues(javafx.scene.shape.Shape fxShape, Shape shape) {
		connector.put(fxShape, shape);
	}

	/**
	 * Not used in current version.
	 * @return
	 */
	public double getLayerWidth() {
		return this.layerWidth;
	}

	/**
	 * Not used in current version.
	 * @return
	 */
	public double getLayerLength() {
		return this.layerLength;
	}

	/**
	 * set the position
	 * @see controller.DragAndDropController
	 * @param newXCoordinate
	 * @param newYCoordinate
	 * @throws NegativeCoordinatesException
	 */
	public void setCoordinates(double newXCoordinate, double newYCoordinate) throws NegativeCoordinatesException {

		if (newXCoordinate < 0 || newYCoordinate < 0) {
			throw new NegativeCoordinatesException();
		} else {

			this.xCoordinate = newXCoordinate;
			this.yCoordinate = newYCoordinate;
			this.fxShape.setLayoutX(newXCoordinate);
			this.fxShape.setLayoutY(newYCoordinate);
		}

	}

	/**
	 *
	 * @return x-value
	 */
	public double getXCoordinates() {
		return this.xCoordinate;
	}

	/**
	 *
	 * @return y-value
	 */
	public double getYCoordinates() {
		return this.yCoordinate;
	}

	/**
	 * Not used in current version.
	 * @param newLayerWidth
	 * @param newLayerLength
	 * @throws InvalidDimensionsException
	 */
	public void setLayerDimensions(double newLayerWidth, double newLayerLength) throws InvalidDimensionsException {

		if (newLayerWidth <= 0 || newLayerLength <= 0) {
			throw new InvalidDimensionsException();
		} else { // layer dimensions are not in use right now could be for later versions

			this.layerWidth = newLayerWidth;
			this.layerLength = newLayerLength;
		}

	}

	/**
	 *
	 * @return color of shape
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 *
	 * @param newColor
	 */
	public void setColor(Color newColor) {
		this.color = newColor;
		this.fxShape.setFill(newColor); // the color of our shape is applied to the javafx shape
	}

	/**
	 *
	 * @return fx shape associated to our Shape object
	 */
	public javafx.scene.shape.Shape getfxShape() {
		return this.fxShape;
	}

	/**
	 * Create a suitable fx shape object.
	 * @param newfxShape
	 */
	public void setfxShape(javafx.scene.shape.Shape newfxShape) {
		this.fxShape = newfxShape;
	}

	/**
	 *
	 * @return area specific to shape.
	 */
	public abstract double getArea(); // area depends on type of shape

	/**
	 *
	 * @return string representation
	 */
	public String toString() {
// ** toString in color class returns RGB code so we defined toString for some selected famous colors

		if (this.color == Color.BLACK) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Black" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.BLUE) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Blue" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.WHITE) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: White" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.GREEN) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Green" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.YELLOW) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Yellow" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.BROWN) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Brown" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.SKYBLUE) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Sky blue" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.ORANGE) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Orange" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.RED) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Red" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.GREY) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Grey" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.PURPLE) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Purple" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.PINK) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Pink" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.VIOLET) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Violet" + "\nArea: " + this.getArea() + "cm²";
		}
		if (this.color == Color.BEIGE) {
			return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
					+ "\nY coordinate: " + this.yCoordinate + "\nColor: Beige" + "\nArea: " + this.getArea() + "cm²";
		}
		return "This " + this.getClass().getSimpleName() + " has" + "\nX coordinate: " + this.xCoordinate
				+ "\nY coordinate: " + this.yCoordinate + "\nColor: " + this.color.toString() + "\nArea: "
				+ this.getArea() + "cm²";
	}

}
