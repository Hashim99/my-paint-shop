package controller;

import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import model.*;

/**
 * @author Hussain Al-Bin Hajji
 * @version 1.0
 * @since   19-Apr-2019
 */
public class DragAndDropController {


    /**
     * Detects dragging and starts it.
     * specify the dragged shape for further usage in:
     * @see #onDragDroppedHandler(DragEvent, Pane)
     * @param mouseEvent
     */
    public static void onDragDetectedHandler(MouseEvent mouseEvent)
    {
        Dragboard dragboard = ((javafx.scene.shape.Shape) mouseEvent.getSource()).startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();

        //Depending on the dragged shape, a string us set to
        //the dragboard as content to be used for the creation on drop
        if (mouseEvent.getSource() instanceof javafx.scene.shape.Rectangle)
        {
            if (((javafx.scene.shape.Rectangle) mouseEvent.getSource()).getHeight() == ((javafx.scene.shape.Rectangle) mouseEvent.getSource()).getWidth())
            {
                content.putString("SQUARE");
            }
            else
            {
                content.putString(mouseEvent.getSource().getClass().getSimpleName());
            }
        }
        else if (mouseEvent.getSource() instanceof javafx.scene.shape.Polygon)
        {
            //Specify which polygon is it by checking the number of vertices.
            if (((javafx.scene.shape.Polygon) mouseEvent.getSource()).getPoints().size() == 10)
            {
                content.putString("PENTAGON");
            }
            else if (((javafx.scene.shape.Polygon) mouseEvent.getSource()).getPoints().size() == 8)
            {
                content.putString("Rhombus");
            }
            else if (((javafx.scene.shape.Polygon) mouseEvent.getSource()).getPoints().size() == 6)
            {
                if (((javafx.scene.shape.Polygon) mouseEvent.getSource()).getStrokeWidth() == 1.1)
                {
                    content.putString("ISO");
                }
                else if (((javafx.scene.shape.Polygon) mouseEvent.getSource()).getStrokeWidth() == 1.11)
                {
                    content.putString("EQ");
                }
                else if (((javafx.scene.shape.Polygon) mouseEvent.getSource()).getStrokeWidth() == 1.111)
                {
                    content.putString("RIGHT");
                }

            }
        }
        else
        {
            content.putString(mouseEvent.getSource().getClass().getSimpleName());
        }

        dragboard.setContent(content);
        mouseEvent.consume();
    }

    /**
     * lets the shapesPane (shapes canvas) accept the dragged shape.
     * @param dragEvent
     */
    public static void onDragOverHandler(DragEvent dragEvent)
    {
        if (dragEvent.getDragboard().hasString())
        {
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }
        dragEvent.consume();
    }

    /**
     * It creates the shape and puts it in the mouse position
     * It specifies the shape using the content in the dragboard.
     * @see #droppingHelper(Shape, DragEvent, Pane)
     * @param dragEvent
     * @param shapesPane where shapes will be added
     * @throws InvalidDimensionsException
     * @throws NegativeCoordinatesException
     */
    public static void onDragDroppedHandler(DragEvent dragEvent, Pane shapesPane) throws InvalidDimensionsException, NegativeCoordinatesException
    {
        Dragboard dragboard = dragEvent.getDragboard();
        String dragboardContent;
        if (dragboard.hasString())
        {
            dragboardContent = dragboard.getString().toUpperCase();
            switch (dragboardContent)
            {
                case "CIRCLE": droppingHelper(new Circle(), dragEvent, shapesPane); break;
                case "ELLIPSE": droppingHelper(new Ellipse(), dragEvent, shapesPane); break;
                case "RECTANGLE": droppingHelper(new Rectangle(), dragEvent, shapesPane); break;
                case "SQUARE": droppingHelper(new Square(), dragEvent, shapesPane); break;
                case "PENTAGON": droppingHelper(new Pentagon(), dragEvent, shapesPane); break;
                case "RHOMBUS": droppingHelper(new Rhombus(), dragEvent, shapesPane); break;
                case "ISO": droppingHelper(new IsoscelesTriangle(), dragEvent, shapesPane); break;
                case "EQ": droppingHelper(new EquilateralTriangle(), dragEvent, shapesPane); break;
                case "RIGHT": droppingHelper(new RightTriangle(), dragEvent, shapesPane); break;
                case "MOVING SHAPE":
                    try
                    {
                        Shape.getShape(((javafx.scene.shape.Shape) ShapesController.draggedShapeEvent.getSource())).setCoordinates(dragEvent.getX(), dragEvent.getY());
                    }
                    catch (Exception e)
                    {
                        e.getCause();
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Error instantiating dropping");
            }
        }
    }

    /**
     * adds the required handlers and set the position relative to mouse.
     * adds it to the shapesPane.
     * @param shape
     * @param dragEvent
     * @param shapesPane
     * @throws NegativeCoordinatesException
     */
    private static void droppingHelper(Shape shape, DragEvent dragEvent, Pane shapesPane) throws NegativeCoordinatesException
    {
        //Adds the required handlers.
        shape.getfxShape().addEventHandler(MouseEvent.MOUSE_CLICKED, ShapesController.clickHandler);
        shape.getfxShape().addEventHandler(MouseEvent.DRAG_DETECTED, ShapesController.dragDetectedHandler);

        shape.setCoordinates(dragEvent.getX(), dragEvent.getY());
        shapesPane.getChildren().add(shape.getfxShape());
    }
}
