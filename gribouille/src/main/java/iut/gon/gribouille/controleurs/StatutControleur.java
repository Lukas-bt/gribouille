package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class StatutControleur implements Initializable {
	
	@FXML
	Label co_x;

	@FXML Label co_y;
	
	@FXML Label epaisseur;
	@FXML Label color;
	@FXML Label outil;

	public Controleur control;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	public void setControleur(Controleur c) {
		this.control = c;
	}
}