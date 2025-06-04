package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille.Dialogues;
import iut.gon.gribouille.modele.Dessin;
import iut.gon.gribouille.modele.Figure;
import iut.gon.gribouille.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controleur implements Initializable{
	
	public final Dessin dessin = new Dessin();
	public Figure figureCourante;
	public final SimpleDoubleProperty prevX = new SimpleDoubleProperty();
	public final SimpleDoubleProperty prevY = new SimpleDoubleProperty();
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	public Outil outilCourant = new OutilCrayon(this);
	
	
	
	@FXML
	CouleursController couleursController;
	@FXML
	DessinControleur dessinController;
	@FXML
	MenusControleur menusController;
	@FXML
	StatutControleur statutController;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.couleursController.setControleur(this);
		this.dessinController.setControleur(this);
		this.menusController.setControleur(this);
		this.statutController.setControleur(this);
		this.statutController.co_x.textProperty().bind(prevX.asString("%.0f"));
		this.statutController.co_y.textProperty().bind(prevY.asString("%.0f"));
		statutController.epaisseur.textProperty().bind(epaisseur.asString());
        statutController.color.textProperty().bind(couleur.asString());
		
		
	}
	
	public void onEtoile() {
		outilCourant = new OutilEtoile(this);
        statutController.outil.setText("Etoile");
	}
	
	public void onCrayon() {
		outilCourant = new OutilCrayon(this);
        statutController.outil.setText("Crayon");
	}


	public boolean onQuitter() {
		if(Dialogues.confirmation()) {
			return true;
		}
		return false;
	}
	
	
}