package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.InvalidDimensionsException;
import model.NegativeCoordinatesException;
import view.Driver;

//Main controller to handle with all elements in the main window.

/**
 * @author Hussain Al-Bin Hajji
 */
public class MainController {

	/**
	 *All needed references from MainWindow.fxml file.
	 * @see view
	 */
	@FXML
	private BorderPane borderPane;
	@FXML
	private GridPane shapeList;
	@FXML
	private Button eraserButton;
	@FXML
	private Canvas canvas;
	@FXML
	private Pane shapesPane;
	@FXML
	private MenuItem itemNew;
	@FXML
	private MenuItem itemOpen;
	@FXML
	private MenuItem itemSave;
	@FXML
	private MenuItem itemSaveAs;
	@FXML
	private MenuItem itemExit;
	@FXML
	private MenuItem itemUdno;
	@FXML
	private MenuItem itemRedo;
	@FXML
	private MenuItem itemNewShape;
	@FXML
	private MenuItem itemEditShape;
	@FXML
	private MenuItem itemCopyShape;
	@FXML
	private MenuItem itemPasteShape;
	@FXML
	private MenuItem itemDeleteShape;
	@FXML
	private Slider slider;
	@FXML
	private ColorPicker colorPicker;


	/**
	 * store the value indicated by the slider.
	 */
	private double sliderVal;
	/**
	 * Indicate the end of the dragging of the slider and saves the value in
	 * @see #sliderVal
	 * field for further usage in the following method:
	 * @see #onMouseDraggedHandler(MouseEvent)
	 * @param event used to get the values in the slider after dragging.
	 */
	public void sliderDragDone(MouseEvent event)
	{
		sliderVal = ((Slider) event.getSource()).getValue();
	}

	/**
	 * Stores the value indicated by the color picker.
	 */
	private Color colorVal;

	/**
	 * Handler changing a shape`s color by clicking it and choosing
	 * the color from the color picker.
	 * @see #colorVal , where value is stored/
	 * @see ShapesController#mouseEvent specify the selected shape.
	 * @param event used to get color value.
	 */
	public void colorPickerHandler(ActionEvent event)
	{
		colorVal = ((ColorPicker) event.getSource()).getValue();
		MouseEvent selectedShapeEvent =  ShapesController.mouseEvent;
		if (selectedShapeEvent.getSource() != null)
		{
			if (colorVal != null)
			{
				((javafx.scene.shape.Shape) selectedShapeEvent.getSource()).setFill(colorVal);
			}

		}
		//removes shading that indicates a shape is selected.
		((javafx.scene.shape.Shape) selectedShapeEvent.getSource()).setEffect(null);
	}


	/**
	 * Detects when a shape is dragged.
	 * @see DragAndDropController#onDragDetectedHandler(MouseEvent)
	 * @param mouseEvent
	 */
	public void onDragDetectedHandler(MouseEvent mouseEvent) {
		DragAndDropController.onDragDetectedHandler(mouseEvent);
	}

	/**
	 * Detects where the shape is dragged over.
	 * @see DragAndDropController#onDragOverHandler(DragEvent)
	 * @param dragEvent
	 */
	public void onDragOverHandler(DragEvent dragEvent) {
		DragAndDropController.onDragOverHandler(dragEvent);
	}

	/**
	 * Handles putting the shape into the canvas after dropping it.
	 * @see DragAndDropController#onDragDroppedHandler(DragEvent, Pane)
	 * @param dragEvent
	 * @throws InvalidDimensionsException
	 * @throws NegativeCoordinatesException
	 */
	public void onDragDroppedHandler(DragEvent dragEvent)
			throws InvalidDimensionsException, NegativeCoordinatesException {
		DragAndDropController.onDragDroppedHandler(dragEvent, shapesPane);
	}

	public void fileHandler(ActionEvent actionEvent) {
		FileController.fileHandler(actionEvent, canvas, shapesPane, itemNew, itemOpen, itemSave, itemSaveAs, itemExit);
	}

	/**
	 * @see #flag indicates if the eraser button is cliced or not.
	 * @see #onMouseDraggedHandler(MouseEvent)
	 * @see #eraserButtonHandler(ActionEvent)
	 */
	private boolean flag;

	/**
	 * Handles free drawing on the canvas.
	 * @see FreeDrawController
	 * @param mouseEvent
	 */
	public void onMousePressedHandler(MouseEvent mouseEvent)
	{
		FreeDrawController.onMousePressedHandler(mouseEvent, canvas);
	}

	/**
	 * Handles free drawing on the canvas.
	 * @see FreeDrawController
	 * @param mouseEvent
	 */
	public void onMouseDraggedHandler(MouseEvent mouseEvent)
	{
		FreeDrawController.onMouseDraggedHandler(mouseEvent, canvas, flag, sliderVal, colorVal);
	}

	/**
	 * Handler enabling and disabling the eraser.
	 * @see FreeDrawController#eraserButtonHandler(ActionEvent, Canvas, Button)
	 * @see #flag indicates if the eraser button is cliced or not.
	 * @param actionEvent
	 */
	public void eraserButtonHandler(ActionEvent actionEvent)
	{
		flag = FreeDrawController.eraserButtonHandler(actionEvent, canvas, eraserButton);
	}


	/**
	 * @see EditShapeController
	 * @param actionEvent
	 */
	public void editShapeHandler(ActionEvent actionEvent) {
		EditShapeController.editShapeHandler(actionEvent, canvas, shapesPane, itemNewShape, itemEditShape,
				itemCopyShape, itemPasteShape, itemDeleteShape);
	}


	/**
	 * @see model.Tracker
	 * @see EditUndoRedoController
	 * @param event
	 */
	public void undoHandler(ActionEvent event)
	{
		Driver.tracker.undo(shapesPane);
	}

	/**
	 * @see model.Tracker
	 * @see EditUndoRedoController
	 * @param event
	 */
	public void redoHandler(ActionEvent event)
	{
		Driver.tracker.redo(shapesPane);
	}


	/**
	 * @see model.Tracker
	 * @see EditUndoRedoController
	 * @param event
	 */
	public void editUndoHandler(ActionEvent event)
	{
		EditUndoRedoController.editUndoHandler(shapesPane, itemUdno);
	}

	/**
	 * @see model.Tracker
	 * @see EditUndoRedoController
	 * @param event
	 */
	public void editRedoHandler(ActionEvent event)
	{
		EditUndoRedoController.editRedoHandler(shapesPane, itemRedo);
	}


	//Zooming isn`t working well, commented out for future modifications.
//	public void zoomInHandler(ActionEvent event)
//	{
//		ZoomController.zoomInHandeler(event, canvas, shapesPane, borderPane);
//	}


	/**
	 * Handles Showing the shape list or not.
	 * @see ViewController
	 * @param event
	 */
	public void shapeListHandeler(ActionEvent event)
	{
		ViewController.shapeListHandeler(event, shapeList);
	}

	/**
	 * Handles Showing the color picker or not.
	 * @see ViewController
	 * @param event
	 */
	public void colorPickerViewHandeler(ActionEvent event)
	{
		ViewController.colorPickerHandeler(event, colorPicker);
	}

	/**
	 * It sets the color of the shape from the sub-menu in the Edit menu-tab
	 * @see ColorController
	 * @param event
	 */
	public void shapeColorHandeler(ActionEvent event)
	{
		ColorController.setColor("Select Shape Color");
	}

	/**
	 * It sets the color of the shape from the sub-menu in the Edit menu-tab
	 * @see ColorController
	 * @param event
	 */
	public void shapeStrokeColorHandeler(ActionEvent event)
	{
		ColorController.setColor("Select Stroke Color");
	}

	public void shapeColorClearHandeler(ActionEvent event) {
		Shape shape = (Shape) ShapesController.mouseEvent.getSource();
		model.Shape selectedSahpe = model.Shape.getShape(shape);
		selectedSahpe.setColor(Color.WHITE);
		selectedSahpe.setStroke(Color.BLACK);
		shape.setEffect(null);
	}

	/**
	 * It sets the color of the shape from the sub-menu in the Edit menu-tab
	 * @see ColorController
	 * @param event
	 */
	public void shapeMixedColorHandeler(ActionEvent event){
		ColorController.setMixedColor();
	}


	public void helpHandler(ActionEvent event)
	{
		HelpController.helpHandler(event);
	}


	/**
	 * Connects the canvas to the shapesPane to make both
	 * free drawing and dropping shapes parallel.
	 * @see #canvas
	 * @see #shapesPane
	 */
	public void connectCanvasToPane()
	{
		canvas.widthProperty().bind(shapesPane.widthProperty());
		canvas.heightProperty().bind(shapesPane.heightProperty());
		shapesPane.getChildren().add(canvas);
	}



}
