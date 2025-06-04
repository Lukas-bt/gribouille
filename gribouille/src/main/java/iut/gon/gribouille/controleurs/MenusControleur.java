package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenusControleur implements Initializable {

	public Controleur control;

	@FXML
	private RadioMenuItem crayon;

	@FXML
	private ToggleGroup symboles;

	@FXML
	private RadioMenuItem etoile;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		symboles.selectedToggleProperty().addListener((obs, old, nvl) -> {
			String id = ((RadioMenuItem) nvl).getId();
			if(id.equals("etoile")) {
				control.onEtoile();
			}
			else if (id.equals("crayon")) {
				control.onCrayon();
			}
		});
	}

	public void setControleur(Controleur c) {
		this.control = c;
	}

	public void onQuitte() {
		if (this.control.onQuitter()) {
			Platform.exit();
		}
	}

}