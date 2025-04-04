package iut.gon.gribouille;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.ButtonType;

public class Dialogues{
	
	public static boolean confirmation() {
		Alert a = new Alert(AlertType.CONFIRMATION, "Êtes-vous sûr ?", ButtonType.YES,ButtonType.NO);
		ButtonType type = a.showAndWait().get();
		return type == ButtonType.YES;
	}
}