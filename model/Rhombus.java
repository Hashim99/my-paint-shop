package model;

import javafx.scene.paint.Color;

/**
 * <h1>Rhombus</h1>
 * The Rhombus class is a class that
 * simply draws a Rhombus
 *
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */

public class Rhombus extends Polygon{

    /**
     * This method is a default constructor
     * to create a new instance of this class
     * in the default settings
     */
    public Rhombus() {
        super();
        setfxShape(new javafx.scene.shape.Polygon(verticesCalculator()));
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
    public Rhombus(double xCoordinate, double yCoordinate, double layerWidth, double layerLength, Color color) throws PaintShopException {
        super(xCoordinate, yCoordinate, layerWidth, layerLength, color);
        setfxShape(new javafx.scene.shape.Polygon(verticesCalculator()));
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

        return new double[]{68.99998474121094, -1.0, 109.0, 64.0, 148.99998474121094, -1.0, 108.99998474121094, -66.0};
    }

    /**
     * This method is a getter
     * to get the area of this
     * shape
     * @return double This returns the area of this shape.
     */
    @Override
    public double getArea(){

        return 0.5*getLayerLength()*getLayerWidth();
    }

}
