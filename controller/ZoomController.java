package controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * <h1>ZoomController</h1>
 * The ZoomController class is a class that
 * simply handel the events of zooming
 * in or out the shapesPane and
 * the canvas
 *
 *
 * this class will be used in next version.
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */
public class ZoomController {
    /**
     * This method is to zoom in
     * the shapesPane and the canvas
     * @param event is the event to handel
     * @param canvas is the canvas
     * @param shapesPane is the shapes Pane
     * @param borderPane is the border Pane
     */
    public static void zoomInHandeler (ActionEvent event, Canvas canvas, Pane shapesPane, BorderPane borderPane) {


        canvas.setScaleX(1.2);
        canvas.setScaleY(1.2);
        shapesPane.setScaleX(1.2);
        shapesPane.setScaleY(1.2);



    }

    /**
     * This method is to zoom out
     * the shapesPane and the canvas
     * @param event is the event to handel
     * @param canvas is the canvas
     * @param shapesPane is the shapes Pane
     */
    public static void zoomOutHandeler (ActionEvent event, Canvas canvas,Pane shapesPane ) {

        canvas.setScaleX(0.8);
        canvas.setScaleY(0.8);
        shapesPane.setScaleX(0.8);
        shapesPane.setScaleY(0.8);
    }

}
