package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Polygon;

/**
 * <h1>Heart</h1>
 * The Heart class is an abstract class that
 * simply draws the shape of Heart
 * made of a triangle and two semicircle
 *
 *
 * this class will be used in next version.
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */
public class Heart extends CombinedShape
{

    /**
     * This method is a default constructor
     * to create a new instance of this class
     * in the default settings
     */
    public Heart(){
        super();
        setfxShape(initializeArc1());
        setShapefx2(initializeArc2());
        setShape3(initializeEquilateralTriangle());

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
    public Heart(double xCoordinate, double yCoordinate, double layerWidth, double layerLength, Color color) throws PaintShopException{
        super(xCoordinate,yCoordinate,layerWidth,layerLength,color);
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
        double [] i = {-50.0000114440918,-83.99998474121094,11.499988555908203,41.00001525878906,73.99998474121094,-83.99998474121094};
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

        return 0;
    }

    /**
     * This private method is
     * to initialize the first arc of this
     * combined shape
     * @return Arc This returns the initialized Arc.
     */
    private Arc initializeArc1(){
        Arc arc = new Arc();
        arc.setLayoutX(45.0);
        arc.setLayoutY(262.0);
        arc.setLength(180.0);
        arc.setRadiusX(31);
        arc.setRadiusY(31);
        return arc;
    }

    /**
     * This private method is
     * to initialize the second arc of this
     * combined shape
     * @return Arc This returns the initialized Arc.
     */
    private Arc initializeArc2(){
        Arc arc = new Arc();
        arc.setLayoutX(107.0);
        arc.setLayoutY(262.0);
        arc.setLength(180.0);
        arc.setRadiusX(31);
        arc.setRadiusY(31);
        return arc;
    }

    /**
     * This private method is
     * to initialize the Equilateral Triangle of this
     * combined shape
     * @return Arc This returns the initialized Triangle.
     */
    private EquilateralTriangle initializeEquilateralTriangle(){
        EquilateralTriangle equilateralTriangle = new EquilateralTriangle();
        equilateralTriangle.setfxShape(new Polygon(verticesCalculator()));
        return equilateralTriangle;
    }
}
