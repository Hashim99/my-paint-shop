package controller;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import view.Driver;

import javax.imageio.ImageIO;
import java.io.*;

/**
 * @author Hashim Al Ghamdi
 */


public class FileController {


	/**
	 * FXML fields put in parameters to have access to them.
	 * Handles the File menu-tab
	 * Not all functionaries are working.
	 * @param actionEvent
	 * @param canvas
	 * @param shapesPane
	 * @param itemNew
	 * @param itemOpen
	 * @param itemSave
	 * @param itemSaveAs
	 * @param itemExit
	 */
	public static void fileHandler(ActionEvent actionEvent, Canvas canvas, Pane shapesPane, MenuItem itemNew,
								   MenuItem itemOpen, MenuItem itemSave, MenuItem itemSaveAs, MenuItem itemExit) {



		// clearing pane to clear shapes and clearing canvas for free drawing

		if (actionEvent.getSource() == itemNew) {

			shapesPane.getChildren().clear();
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.clearRect(canvas.getLayoutX(), canvas.getLayoutY(), canvas.getWidth(), canvas.getHeight());
			shapesPane.getChildren().add(canvas);

		}

		// currently not functioning, to be added to later versions

		else if (actionEvent.getSource() == itemOpen) {

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open your painting");
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("mps", "*.mps"));
			File selectedFile = fileChooser.showOpenDialog(Driver.myStage);

			ObjectInputStream read;
			try {
				read = new ObjectInputStream(new FileInputStream(selectedFile));

				try {
					shapesPane = (Pane) read.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * // Scene a = new Scene(selectedFile,300,300); // // //
			 * Driver.myStage.show(selectedFile);
			 */

		}

		// currently not functioning, to be added to later versions

		else if (actionEvent.getSource() == itemSave) {

			FileChooser fileChooser = new FileChooser();

			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("S²H³", "*.S²H³"));
			File mpsFile = fileChooser.showSaveDialog(null);
			shapesPane.getChildren().add(canvas); // to save free drawing
			/*
			 * WritableImage wimPane = new WritableImage((int) shapesPane.getWidth(), (int)
			 * shapesPane.getHeight());
			 *
			 *
			 *
			 * shapesPane.snapshot(null, wimPane);
			 *
			 * try { ImageIO.write(SwingFXUtils.fromFXImage(wimPane, null), "png", mpsFile);
			 * } catch (Exception s) { }
			 */

			ObjectOutputStream out;
			try {
				out = new ObjectOutputStream(new FileOutputStream(mpsFile));
				out.writeObject(shapesPane);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


		// currently not functioning, to be added to later versions

		else if (actionEvent.getSource() == itemSaveAs) {

			FileChooser fileChooser = new FileChooser();

			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("mps", "*.mps"),
					new FileChooser.ExtensionFilter("png", "*.png"));
			File mpsFile = fileChooser.showSaveDialog(null);

			shapesPane.getChildren().add(canvas);

			WritableImage wimPane = new WritableImage((int) shapesPane.getWidth(), (int) shapesPane.getHeight());

			shapesPane.snapshot(null, wimPane);

			try {
				ImageIO.write(SwingFXUtils.fromFXImage(wimPane, null), "png", mpsFile);

			} catch (Exception s) {
			}
		}

		// should add confirmation and saving option in later versions

		else if (actionEvent.getSource() == itemExit) {
			Platform.exit();
		}

	}
}
