package controller;

import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import view.Driver;


public class EditUndoRedoController {

	/**
	 * @see model.Tracker
	 * @param shapesPane
	 * @param itemUdno
	 */
	public static void editUndoHandler(Pane shapesPane, MenuItem itemUdno) {
		Driver.tracker.undo(shapesPane);
	}

	/**
	 * @see model.Tracker
	 * @param shapesPane
	 * @param itemRedo
	 */
	public static void editRedoHandler(Pane shapesPane, MenuItem itemRedo) {
		Driver.tracker.redo(shapesPane);
	}
}
