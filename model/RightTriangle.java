package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * <h1>RightTriangle</h1>
 * The RightTriangle class is a class that
 * simply draws a Right Triangle
 *
 *
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */

public class RightTriangle extends Triangle {

    /**
     * This method is a default constructor
     * to create a new instance of this class
     * in the default settings
     */
    public RightTriangle() {
        super();
        setfxShape(new Polygon(verticesCalculator()));
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
    public RightTriangle(double xCoordinate, double yCoordinate, double layerWidth, double layerLength, Color color) throws PaintShopException {
        super(xCoordinate, yCoordinate, layerWidth, layerLength, color);
        setfxShape(new Polygon(verticesCalculator()));
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
        return new double[]{-50,40,50,40,-50,-45};
    }


}
