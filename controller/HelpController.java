package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Hussain Al-Bin Hajji
 */
public class HelpController {

	private static Image[] helpImages = new Image[10];
	private static ImageView imageView = new ImageView();
	private static int tracker = 0;
	private static Button previous = new Button("Previous");
	private static Button next = new Button("Next");

	/**
	 * Opens and new Help window that contains a slide show
	 * To guide the user.
	 * @param event
	 */
	public static void helpHandler(ActionEvent event)
	{
		helpImages[0] = new Image("/view/imgs/Slide1.JPG");
		helpImages[1] = new Image("/view/imgs/Slide2.JPG");
		helpImages[2] = new Image("/view/imgs/Slide3.JPG");
		helpImages[3] = new Image("/view/imgs/Slide4.JPG");
		helpImages[4] = new Image("/view/imgs/Slide5.JPG");
		helpImages[5] = new Image("/view/imgs/Slide6.JPG");
		helpImages[6] = new Image("/view/imgs/Slide7.JPG");
		helpImages[7] = new Image("/view/imgs/Slide8.JPG");
		helpImages[8] = new Image("/view/imgs/Slide9.JPG");
		helpImages[9] = new Image("/view/imgs/Slide10.JPG");

		imageView.setImage(helpImages[tracker]);

		ButtonHandler buttonHandler = new ButtonHandler();

		next.setOnAction(buttonHandler);
		previous.setOnAction(buttonHandler);

		HBox hBox = new HBox();
		hBox.getChildren().addAll(previous, next);
		VBox vBox = new VBox();
		vBox.getChildren().addAll(imageView, hBox);

		vBox.setAlignment(Pos.CENTER);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(50);

		Scene scene = new Scene(vBox, 1280, 800);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Help");
		stage.show();
	}

	/**
	 * @author Hussain Al-Bin Hajji
	 * Helpder class for
	 * @see #helpHandler(ActionEvent)
	 */
	private static class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event)
		{
			if (event.getSource() == next)
			{
				if (tracker < helpImages.length-1)
				{
					tracker++;
					imageView.setImage(helpImages[tracker]);
				}
			}
			else if (event.getSource() == previous)
			{
				if (tracker > 0)
				{
					tracker--;
					imageView.setImage(helpImages[tracker]);
				}
			}
		}
	}

}

