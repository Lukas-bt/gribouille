package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class CouleursController implements Initializable {
	
	@FXML
	public ColorPicker color_picker;

	@FXML
	public Rectangle col_red;

	@FXML
	public Rectangle col_green;

	@FXML
	public Rectangle col_dark_blue;

	@FXML
	public Rectangle col_light_blue;

	@FXML
	public Rectangle col_pink;

	@FXML
	public Rectangle col_yellow;

	@FXML
	public Rectangle col_black;

	@FXML
	public Rectangle col_white;
	
	public Controleur control;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void setControleur(Controleur c) {
		this.control = c;
	}
	
}