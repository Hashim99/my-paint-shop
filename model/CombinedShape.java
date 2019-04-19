package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


/**
 * <h1>CombinedShape</h1>
 * The CombinedShape class is an abstract class that
 * simply combines two or more simple shapes to create
 * a new complex shape.
 *
 *
 * this class will be used in next version.
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */


public abstract class CombinedShape extends Polygon {
    private Shape shapefx2;
    private model.Shape shape3;

    /**
     * This method is a default constructor
     * to create a new instance of this class
     * in the default settings
     */
    public CombinedShape(){

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
    public CombinedShape(double xCoordinate, double yCoordinate, double layerWidth, double layerLength, Color color) throws PaintShopException{
        super(xCoordinate,yCoordinate,layerWidth,layerLength,color);
    }

    /**
     * This method is a getter
     * to get the instance of a simple shape
     * of Javafx shapes
     * @return java.shape.Shape This returns an instance of a simple shape.
     */
    public Shape getShapefx2() {

        return shapefx2;
    }

    /**
     * This method is a setter
     * to set the instance of a simple shape
     * of Javafx shapes
     *@param shapefx2 This is the parameter to set the instance of shape
     */
    public void setShapefx2(Shape shapefx2) {

        this.shapefx2 = shapefx2;
    }

    /**
     * This method is a getter
     * to get the instance of a simple shape
     * of My Paint Shop shapes
     * @return model.Shape This returns an instance of a simple shape.
     */
    public model.Shape getShape3() {

        return shape3;
    }

    /**
     * This method is a setter
     * to set the instance of a simple shape
     * of My Paint Shop shapes
     *@param shape3 This is the parameter to set the instance of shape
     */
    public void setShape3(model.Shape shape3) {
        this.shape3 = shape3;
    }
}
