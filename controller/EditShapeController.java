package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;

import java.util.Random;

/**
 * @author Hashim Al Ghamdi
 * @author Hussain Al-Bin Hajji
 * @author Salman Al Ghamdi
 */

public class EditShapeController {

	/**
	 * This method handles the Shape sub-menu from the menu bar
	 * it mostly uses the same logic of the properties box
	 * @see ShapesController
	 * @param actionEvent
	 * @param canvas
	 * @param shapesPane
	 * @param itemNewShape
	 * @param itemEditShape
	 * @param itemCopyShape
	 * @param itemPasteShape
	 * @param itemDeleteShape
	 */
	public static void editShapeHandler(ActionEvent actionEvent, Canvas canvas, Pane shapesPane, MenuItem itemNewShape,
										MenuItem itemEditShape, MenuItem itemCopyShape, MenuItem itemPasteShape, MenuItem itemDeleteShape) {

		// to have control over selected shapes since this handler is not for
		// MouseEvents
		MouseEvent selectedShapeEvent = ShapesController.mouseEvent;

		if (selectedShapeEvent != null) {

			// to shade shape when selected

			DropShadow sh = new DropShadow(2, 4, 4, Color.DARKSALMON);
			((javafx.scene.shape.Shape) selectedShapeEvent.getSource()).setEffect(sh);

			Shape copiedShape = null;

			Shape selectedShape = Shape.getShape((javafx.scene.shape.Shape) selectedShapeEvent.getSource());

			// same code from ShapeController to open properties box

			if (actionEvent.getSource() == itemEditShape) {
				// Shape.getShape((javafx.scene.shape.Shape) event.getSource()).getArea();
				// an example on how to call the methods of the event.
				((javafx.scene.shape.Shape) selectedShapeEvent.getSource()).setEffect(null);

				Shape shape = Shape.getShape((javafx.scene.shape.Shape) selectedShapeEvent.getSource());
				Stage pBox = new Stage();
				Label shapeString = new Label(shape.toString());

				// the pBox will be made of 3 VBoxes and one huge HBox
				VBox v1 = new VBox();
				v1.setPadding(new Insets(10, 10, 10, 10));
				if (shape instanceof model.Rectangle) {
					if (shape.getClass().getSimpleName().equalsIgnoreCase("SQUARE")) {
						// the first column of the pBox.
						Label sideLbl = new Label("Side");
						Label areaLbl = new Label("Area");
						TextField sideTxt = new TextField();
						TextField areaTxt = new TextField();

						Square square = (Square) shape;
						sideTxt.setPromptText(square.getSide() + "");
						sideTxt.setText(square.getSide() + "");

						// since the area is the resultant of calculating the side * side...
						// so it mustn't be changed.
						areaTxt.setPromptText(square.getArea() + "");
						areaTxt.setEditable(false);
						areaTxt.setMouseTransparent(true);
						areaTxt.setFocusTraversable(false);

						// setting the length and width using the text field.
						sideTxt.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

							@Override
							public void handle(KeyEvent arg0) {
								try {
									square.setSide(Double.parseDouble(sideTxt.getText()));
								} catch (NumberFormatException | InvalidDimensionsException e) {
									try {
										square.setSide(50.0);
									} catch (InvalidDimensionsException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}

						});

						v1.getChildren().addAll(sideLbl, sideTxt, areaLbl, areaTxt);
					} else {
						// the first column of the pBox.
						Label widthLbl = new Label("Width");
						Label lengthLbl = new Label("Height");
						Label areaLbl = new Label("Area");
						TextField widthTxt = new TextField();
						TextField lengthTxt = new TextField();
						TextField areaTxt = new TextField();

						Rectangle rec = (Rectangle) shape;

						widthTxt.setPromptText(rec.getWidth() + "");
						widthTxt.setText(rec.getWidth() + "");
						lengthTxt.setPromptText(rec.getLength() + "");
						lengthTxt.setText(rec.getLength() + "");

						// since the area is the resultant of calculating the width
						// and the length, so it mustn't be changed.
						areaTxt.setPromptText(rec.getArea() + "");
						areaTxt.setEditable(false);
						areaTxt.setMouseTransparent(true);
						areaTxt.setFocusTraversable(false);

						// setting the length and width using the text field.
						widthTxt.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

							@Override
							public void handle(KeyEvent arg0) {
								try {
									rec.setDimensions(Double.parseDouble(widthTxt.getText()), rec.getLength());
								} catch (NumberFormatException | InvalidDimensionsException e) {
									// TODO Auto-generated catch block
									try {
										rec.setDimensions(50.0, rec.getLength());
									} catch (InvalidDimensionsException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}

						});

						lengthTxt.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

							@Override
							public void handle(KeyEvent arg0) {
								try {
									rec.setDimensions(rec.getWidth(), Double.parseDouble(lengthTxt.getText()));
								} catch (NumberFormatException | InvalidDimensionsException e) {
									// TODO Auto-generated catch block
									try {
										rec.setDimensions(rec.getWidth(), 35.0);
									} catch (InvalidDimensionsException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}

						});

						v1.getChildren().addAll(widthLbl, widthTxt, lengthLbl, lengthTxt, areaLbl, areaTxt);
					}
				} else if (shape instanceof model.Ellipse) {
					if ((shape.getClass().getSimpleName().equalsIgnoreCase("Circle"))) {
						// the first column of the pBox.
						Label radiusLbl = new Label("Radius");
						Label areaLbl = new Label("Area");
						TextField radiusTxt = new TextField();
						TextField areaTxt = new TextField();

						Circle cir = (Circle) shape;

						radiusTxt.setPromptText(cir.getRadius() + "");
						radiusTxt.setText(cir.getRadius() + "");

						// since the area is the resultant of calculating the width
						// and the length, so it mustn't be changed.
						areaTxt.setPromptText(cir.getArea() + "");
						areaTxt.setEditable(false);
						areaTxt.setMouseTransparent(true);
						areaTxt.setFocusTraversable(false);

						// setting the length and width using the text field.
						radiusTxt.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

							@Override
							public void handle(KeyEvent arg0) {
								try {
									cir.setRadius(Double.parseDouble(radiusTxt.getText()));
								} catch (NumberFormatException | InvalidDimensionsException e) {
									// TODO Auto-generated catch block
									try {
										cir.setRadius(50.0);
									} catch (InvalidDimensionsException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}

						});

						v1.getChildren().addAll(radiusLbl, radiusTxt, areaLbl, areaTxt);
					} else {
						// the first column of the pBox.
						Label horiAxisLbl = new Label("Horizontal Axis");
						Label vertiAxisLbl = new Label("Vertical Axis");
						Label areaLbl = new Label("Area");
						TextField horiAxisTxt = new TextField();
						TextField vertiAxisTxt = new TextField();
						TextField areaTxt = new TextField();

						Ellipse ell = (Ellipse) shape;

						horiAxisTxt.setPromptText(ell.getAxisA() + "");
						horiAxisTxt.setText(ell.getAxisA() + "");
						vertiAxisTxt.setPromptText(ell.getAxisB() + "");
						vertiAxisTxt.setText(ell.getAxisB() + "");

						// since the area is the resultant of calculating the width
						// and the length, so it mustn't be changed.
						areaTxt.setPromptText(ell.getArea() + "");
						areaTxt.setEditable(false);
						areaTxt.setMouseTransparent(true);
						areaTxt.setFocusTraversable(false);

						// setting the length and width using the text field.
						horiAxisTxt.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

							@Override
							public void handle(KeyEvent arg0) {
								try {
									ell.setAxisA(Double.parseDouble(horiAxisTxt.getText()));
								} catch (NumberFormatException | InvalidDimensionsException e) {
									// TODO Auto-generated catch block
									try {
										ell.setAxisA(50.0);
									} catch (InvalidDimensionsException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}

						});

						vertiAxisTxt.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

							@Override
							public void handle(KeyEvent arg0) {
								try {
									ell.setAxisB(Double.parseDouble(vertiAxisTxt.getText()));
								} catch (NumberFormatException | InvalidDimensionsException e) {
									// TODO Auto-generated catch block
									try {
										ell.setAxisB(40.0);
									} catch (InvalidDimensionsException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}

						});

						v1.getChildren().addAll(horiAxisLbl, horiAxisTxt, vertiAxisLbl, vertiAxisTxt, areaLbl, areaTxt);
					}
				}

				VBox v2 = new VBox();

				Label shapeInLbl = new Label("Shape Color");
				Label shapeOutLbl = new Label("Outline Color");

				ColorPicker shapeColor = new ColorPicker();
				ColorPicker outlineColor = new ColorPicker();

				Button clear = new Button("Clear Color");

				shapeColor.setValue(shape.getColor());
				// outlineColor.setValue(Shape.getShape((javafx.scene.shape.Shape)
				// event.getSource()).getColor());
				// this will be held out until we make a stroke for the shape, in the time
				// being, outlineColor will
				// be Black by default.
				outlineColor.setValue(Color.BLACK);

				shapeColor.setOnAction((new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						shape.setColor(shapeColor.getValue());
						shapeString.setText(shape.toString());
					}
				}));

				outlineColor.setOnAction((new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						shape.setStroke(outlineColor.getValue());
					}
				}));

				clear.setOnAction((new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						shape.setColor(Color.WHITE);
						shape.setStroke(Color.BLACK);
						shapeColor.setValue(Color.WHITE);
						outlineColor.setValue(Color.BLACK);
						shapeString.setText(shape.toString());
					}
				}));

				v2.getChildren().addAll(shapeInLbl, shapeColor, shapeOutLbl, outlineColor, clear);

				HBox proBox = new HBox();
				proBox.setSpacing(10);
				proBox.setPadding(new Insets(20, 20, 20, 20));
				proBox.getChildren().addAll(v1, v2);
				proBox.setAlignment(Pos.CENTER);

				HBox info = new HBox();

				info.getChildren().add(shapeString);
				info.setAlignment(Pos.CENTER);

				VBox whole = new VBox();
				whole.getChildren().addAll(proBox, info);
				whole.setAlignment(Pos.CENTER);

				Scene newScene = new Scene(whole, 280, 300);
				pBox.setTitle("Properties Box");
				pBox.setScene(newScene);
				pBox.show();
			}


			// currently not functioning, to be added to later versions

			else if (actionEvent.getSource() == itemCopyShape) {

			}


			// currently not functioning, to be added to later versions

			else if (actionEvent.getSource() == itemPasteShape) {

			}


			else if (actionEvent.getSource() == itemDeleteShape) {

				shapesPane.getChildren().remove(selectedShape.getfxShape());

			}

		}

		if (actionEvent.getSource() == itemNewShape) {

			((javafx.scene.shape.Shape) selectedShapeEvent.getSource()).setEffect(null); // to remove shading

			ContextMenu newShapePU = new ContextMenu();

			/*
			 * all shapes are added with random coordinates and default values, should
			 * include option for customization in later versions
			 */

			MenuItem newCircle = new MenuItem("Circle");
			MenuItem newEllipse = new MenuItem("Ellipse");
			MenuItem newSquare = new MenuItem("Square");
			MenuItem newRectangle = new MenuItem("Rectangle");

			newShapePU.getItems().addAll(newCircle, newEllipse, newSquare, newRectangle);

			newShapePU.show(shapesPane, 400, 150);

			newCircle.setOnAction(e -> {

				Circle c = new Circle();
				c.getfxShape().addEventHandler(MouseEvent.MOUSE_CLICKED, ShapesController.clickHandler);
				try {
					Random rnd = new Random();

					c.setCoordinates(rnd.nextInt((int) shapesPane.getWidth()),
							rnd.nextInt((int) shapesPane.getHeight()));

				} catch (NegativeCoordinatesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				shapesPane.getChildren().add(c.getfxShape());

			});
			newEllipse.setOnAction(e -> {

				Ellipse el = new Ellipse();
				el.getfxShape().addEventHandler(MouseEvent.MOUSE_CLICKED, ShapesController.clickHandler);
				try {
					Random rnd = new Random();

					el.setCoordinates(rnd.nextInt((int) shapesPane.getWidth()),
							rnd.nextInt((int) shapesPane.getHeight()));

				} catch (NegativeCoordinatesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				shapesPane.getChildren().add(el.getfxShape());

			});
			newSquare.setOnAction(e -> {

				Square s = new Square();
				s.getfxShape().addEventHandler(MouseEvent.MOUSE_CLICKED, ShapesController.clickHandler);
				try {
					Random rnd = new Random();

					s.setCoordinates(rnd.nextInt((int) shapesPane.getWidth()),
							rnd.nextInt((int) shapesPane.getHeight()));

				} catch (NegativeCoordinatesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				shapesPane.getChildren().add(s.getfxShape());

			});
			newRectangle.setOnAction(e -> {

				Rectangle r = new Rectangle();
				r.getfxShape().addEventHandler(MouseEvent.MOUSE_CLICKED, ShapesController.clickHandler);
				try {
					Random rnd = new Random();

					r.setCoordinates(rnd.nextInt((int) shapesPane.getWidth()),
							rnd.nextInt((int) shapesPane.getHeight()));

				} catch (NegativeCoordinatesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				shapesPane.getChildren().add(r.getfxShape());

			});
		}

	}
}
