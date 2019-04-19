
package model;

import javafx.scene.paint.Color;

/**
 * <h1>Polygon</h1>
 * The Polygon class is an abstract class that
 * simply draws an equilateral triangle
 *
 *
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */

public abstract class Polygon extends Shape{

    /**
     * This method is a default constructor
     * to create a new instance of this class
     * in the default settings
     */
    public Polygon(){

        super();
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
    public Polygon(double xCoordinate, double yCoordinate, double layerWidth, double layerLength, Color color) throws PaintShopException{
        super(xCoordinate,yCoordinate,layerWidth,layerLength,color);
    }

    /**
     * This method to get
     * the X-Coordinate and Y-Coordinate
     * of each vertex of this shape
     * @return double[] This returns the vertices of this shape.
     */
    protected abstract double[]verticesCalculator();


}

