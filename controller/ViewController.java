package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;

/**
 * <h1>ViewController</h1>
 * The ViewController class is a class that
 * simply handel the events of view menu list
 *
 *
 *
 *
 * @author  Haitham Alsaeed
 * @version 1.0
 * @since   2019-04-30
 */
public class ViewController {
    @FXML
    private static boolean shapeListSelected = false;
    private static boolean colorPickerSelected = false;
    private static boolean zoomSelected = false;


    /**
     * This method is to show
     * or hide shape list
     * @param event is the event to handel
     * @param shapeList is the shape list
     */
    public static void shapeListHandeler(ActionEvent event,GridPane shapeList){
        if (shapeListSelected)
            showShapeList(shapeList);
        else
            hideShapeList(shapeList);
        shapeListSelected =! shapeListSelected;
    }

    /**
     * This private method is to
     * hide shape list
     * @param shapeList is the shape list
     *                  to hide
     */
    private static void hideShapeList(GridPane shapeList) {
        shapeList.setOpacity(0);
        shapeList.setDisable(true);
    }

    /**
     * This private method is to
     * show hided shape list
     * @param shapeList is the shape list
     *                  to show
     */
    private static void showShapeList(GridPane shapeList) {

        shapeList.setOpacity(1);
        shapeList.setDisable(false);
    }

    /**
     * This method is to show
     * or hide color Picker
     * @param event is the event to handel
     * @param colorPicker is the color Picker
     */
    public static void colorPickerHandeler (ActionEvent event,ColorPicker colorPicker){
        if (!colorPickerSelected)
            hideColorPicker(colorPicker);
        else showColorPicker(colorPicker);
        colorPickerSelected=!colorPickerSelected;
    }

    /**
     * This private method is to
     * hide color Picker
     * @param colorPicker is the color Picker
     *                  to hide
     */
    private static void hideColorPicker(ColorPicker colorPicker) {

        colorPicker.setOpacity(0);
        colorPicker.setDisable(true);
    }


    /**
     * This private method is to
     * show hided color Picker
     * @param colorPicker is the color Picker
     *                  to show
     */
    private static void showColorPicker(ColorPicker colorPicker) {
        colorPicker.setOpacity(1);
        colorPicker.setDisable(false);
    }

    /**
     * This method is to show
     * or hide zoom buttons
     * @param event is the event to handel
     * @param zoomOutButton is the zoom Out Button
     * @param zoomOInButton is the zoom In Button
     */
    public static void zoomHandeler (ActionEvent event,Button zoomOutButton,Button zoomOInButton){
        if (!zoomSelected)
            hideZoom(zoomOutButton,zoomOInButton);
        else
            showZoom(zoomOutButton,zoomOInButton);
        zoomSelected=!zoomSelected;
    }

    /**
     * This private method is to
     * hide zoom buttons
     * @param zoomOutButton is the zoom Out Button
     *                      to hide
     * @param zoomOInButton is the zoom In Button
     *                      to hide
     */
    private static void hideZoom(Button zoomOutButton,Button zoomOInButton) {

        zoomOutButton.setOpacity(0);
        zoomOInButton.setOpacity(0);
    }


    /**
     * This private method is to
     * show hided zoom buttons
     * @param zoomOutButton is the zoom Out Button
     *                      to show
     * @param zoomOInButton is the zoom In Button
     *                      to show
     */
    private static void showZoom(Button zoomOutButton,Button zoomOInButton) {

        zoomOutButton.setOpacity(1);
        zoomOInButton.setOpacity(1);
    }
}
