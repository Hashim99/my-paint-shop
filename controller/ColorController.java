package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * <h1>ColorController</h1>
 * The ColorController class is a class that
 * simply handel the events of controlling colors
 *
 *
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */
public class ColorController {
    private static Color color;
    private static Color tempColor;

    private static MouseEvent selectedShapeEvent = ShapesController.mouseEvent;
    private static model.Shape shape = model.Shape.getShape((javafx.scene.shape.Shape) selectedShapeEvent.getSource());



    /**
     * This  method is to
     * open a small window to
     * select a new color for the
     * shape or the outer line of
     * the shape
     * @param title is the title of
     *              the stage
     */
    public static void setColor(String title) {

        color = shape.getColor();
        Button selectionButton = new Button("Select");
        selectionButton.setLayoutX(139);
        selectionButton.setLayoutY(128);
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLayoutX(28);
        colorPicker.setLayoutY(71);
        colorPicker.setValue(shape.getColor());
        AnchorPane colorView = new AnchorPane();
        colorView.setLayoutX(229);
        colorView.setLayoutY(66);
        colorView.setPrefSize(62, 26);
        colorView.setBackground(new Background(new BackgroundFill(tempColor, CornerRadii.EMPTY, Insets.EMPTY)));
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(selectionButton, colorPicker, colorView);
        Scene scene = new Scene(root, 325, 168);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tempColor = colorPicker.getValue();
                colorView.setBackground(new Background(new BackgroundFill(tempColor, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });

        selectionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                color=tempColor;
                if (title.equalsIgnoreCase("Select Stroke Color"))
                {
                    shape.setStroke(color);
                }
                else
                    shape.setColor(color);
                stage.close();
            }
        });
        shape.getfxShape().setEffect(null);
    }


    /**
     * This  method is to
     * open a small window to
     * generate a new color for the
     * shape
     */
    public static void setMixedColor(){
        color=shape.getColor();
        Button selectionButton = new Button("Select");
        selectionButton.setLayoutX(123);
        selectionButton.setLayoutY(127);
        VBox sliderVBox = new VBox(20);
        Slider redSlider = new Slider(0,1,0);
        Slider greenSlider = new Slider(0,1,0);
        Slider blueSlider = new Slider(0,1,0);
        sliderVBox.getChildren().addAll(redSlider,greenSlider,blueSlider);
        VBox labelVBox = new VBox(15);
        Label redLabel = new Label("Red");
        Label greenLabel = new Label("Green");
        Label blueLabel = new Label("Blue");
        labelVBox.getChildren().addAll(redLabel,greenLabel,blueLabel);
        HBox hBox = new HBox(20);//layoutX="14.0" layoutY="14.0" prefHeight="100.0" prefWidth="298.0"
        hBox.setLayoutX(14);
        hBox.setLayoutY(14);
        hBox.setPrefSize(298,100);
        hBox.getChildren().addAll(sliderVBox,labelVBox);
        AnchorPane colorView = new AnchorPane();
        colorView.setLayoutX(14);
        colorView.setLayoutY(127);
        colorView.setPrefSize(50, 26);
        AnchorPane root = new AnchorPane();
        root.setPrefSize(247,168);
        root.getChildren().addAll(selectionButton,hBox,colorView);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Color Mixer");
        stage.show();
        redSlider.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                tempColor = Color.color(redSlider.getValue(),greenSlider.getValue(),blueSlider.getValue());
                colorView.setBackground(new Background(new BackgroundFill(tempColor, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        greenSlider.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                tempColor = Color.color(redSlider.getValue(),greenSlider.getValue(),blueSlider.getValue());
                colorView.setBackground(new Background(new BackgroundFill(tempColor, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        blueSlider.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                tempColor = Color.color(redSlider.getValue(),greenSlider.getValue(),blueSlider.getValue());
                colorView.setBackground(new Background(new BackgroundFill(tempColor, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
        selectionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                color = tempColor;
                shape.setColor(color);
                stage.close();
            }
        });
        shape.getfxShape().setEffect(null);
    }

}
