package view;

import controller.HelpController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Tracker;

/**
 * @author Hussain Al-Bin Hajji
 */
public class Driver extends Application {

    /**
     * The only tracker object, no other shall be created.
     * @see Tracker
     */
    public static Tracker tracker = new Tracker();

    public static MainController mainController = new MainController();

    /**
     * give reference to other classes.
     */
    public static Stage myStage = null;
    @Override
    public void start(Stage primaryStage) throws Exception {
        myStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        loader.setController(mainController);
        Parent root = loader.load();
        mainController.connectCanvasToPane();

        primaryStage.setTitle("My Paint Shop");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
