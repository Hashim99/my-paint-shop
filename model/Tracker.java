package model;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.Stack;

/**
 * @author Hussain Al-Bin Hajji
 * @author Salem Bamukhair
 */
public class Tracker {
    /**
     * Stores the undo-ed events, last in first out.
     */
    private Stack<Shape> redos;


    public Tracker()
    {
        redos = new Stack<>();
    }


    /**
     *Takes out the last addition and pushes it into the redo stack.
     * @param shapesPane
     */
    public void undo(Pane shapesPane)
    {
        int size = shapesPane.getChildren().size();

        try
        {
            Shape shape = (Shape) shapesPane.getChildren().get(size-1);
            redos.push(shape);
            shapesPane.getChildren().remove(size-1);
        }
        catch (Exception e)
        {
        }
    }

    /**
     * Bring back the last undo-ed addition, and pops it from the stack.
     * @param shapesPane
     */
    public void redo(Pane shapesPane)
    {
        try
        {
            Shape shape = redos.peek();
            shapesPane.getChildren().add(shape);
            redos.pop();
        }
        catch (Exception e)
        {
        }
    }
}