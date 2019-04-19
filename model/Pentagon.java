package model;

import javafx.scene.paint.Color;

/**
 * <h1>Pentagon</h1>
 * The Pentagon class is a class that
 * simply draws a Pentagon
 *
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */
public class Pentagon extends Polygon {

    /**
     * This method is a default constructor
     * to create a new instance of this class
     * in the default settings
     */
    public Pentagon() {
        super();
        javafx.scene.shape.Polygon pentagon = new javafx.scene.shape.Polygon(verticesCalculator());
        pentagon.setRotate(190);
        setfxShape(pentagon);
        setConnectorValues(getfxShape(), this);
    }

    /**
     * This method is a  constructor
     * to create a new instance of this class
     * in the modified settings
     * @param xCoordinate This is the first parameter to set the X-Coordinate
     * @param yCoordinate  This is the second parameter to set the Y-Coordinate
     * @param layerWidth  This is the third parameter to set the layer width
     * @param layerLength  This is the forth parameter to set the layer length
     * @param color  This is the fifth parameter to set the color
     * @exception PaintShopException an general error.
     * @see PaintShopException
     */
    public Pentagon(double xCoordinate, double yCoordinate, double layerWidth, double layerLength, Color color) throws PaintShopException {
        super(xCoordinate, yCoordinate, layerWidth, layerLength, color);
        javafx.scene.shape.Polygon pentagon = new javafx.scene.shape.Polygon(verticesCalculator());
        pentagon.setRotate(170);
        setfxShape(pentagon);
        setConnectorValues(getfxShape(), this);
    }

    /**
     * This method to get
     * the X-Coordinate and Y-Coordinate
     * of each vertex of this shape
     * @return double[] This returns the vertices of this shape.
     */
    @Override
    protected double[] verticesCalculator() {
        double[] i = {115,-25,105,33,159,64,199,18,173,-35};
        return i;
    }

    /**
     * This method is a getter
     * to get the area of this
     * shape
     * @return double This returns the area of this shape.
     */
    @Override
    public double getArea() {
        return getfxShape().computeAreaInScreen();
    }
}
