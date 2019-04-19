package controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * @author Hussain Al-Bin Hajji
 */
public class FreeDrawController {

    /**
     * indicates if the eraser button is enabled or not
     * @see #eraserButtonHandler(ActionEvent, Canvas, Button)
     */
    private static boolean flag = false;

    /**
     * To give access to the events from the outside.
     */
    public static MouseEvent pressMouseEvent = null;
    public static MouseEvent dragMouseEvent = null;

    /**
     * Instantiate the free drawing process.
     * @param mouseEvent
     * @param canvas
     */
    public static void onMousePressedHandler(MouseEvent mouseEvent, Canvas canvas)
    {
        pressMouseEvent = mouseEvent;
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.beginPath();
        graphicsContext.moveTo(mouseEvent.getX(), mouseEvent.getY());
        graphicsContext.stroke();
    }

    /**
     * Handles the free drawing in the canvas
     * Handles erasing and size of pen/eraser and color.
     * @param mouseEvent
     * @param canvas
     * @param isEraser
     * @param sliderVal
     * @param colorVal
     */
    public static void onMouseDraggedHandler(MouseEvent mouseEvent, Canvas canvas, boolean isEraser, double sliderVal, Color colorVal)
    {
        dragMouseEvent = mouseEvent;

        if (isEraser)
        {
            final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
            graphicsContext.lineTo(mouseEvent.getX(), mouseEvent.getY());
            graphicsContext.setStroke(Color.WHITE);
            graphicsContext.setLineWidth(sliderVal);
            graphicsContext.stroke();
        }
        else
        {
            final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
            graphicsContext.lineTo(mouseEvent.getX(), mouseEvent.getY());
            if(colorVal != null)
            {
            	if (!colorVal.equals(Color.WHITE))
            	{
                	graphicsContext.setStroke(colorVal);
            	}
            }
            else
            {
            	graphicsContext.setStroke(Color.BLACK);
            }
            	
            graphicsContext.setLineWidth(sliderVal);
            graphicsContext.stroke();
        }

    }

    /**
     * Handles  enabling and disabling the eraser.
     * @param actionEvent
     * @param canvas
     * @param eraserButton
     * @return
     */
    public static boolean eraserButtonHandler(ActionEvent actionEvent, Canvas canvas, Button eraserButton)
    {
        if (!flag)
        {
            flag = true;
            eraserButton.setText("Disable Eraser");
        }
        else
        {
            flag = false;
            eraserButton.setText("Enable Eraser");
        }
        return flag;
    }


}
