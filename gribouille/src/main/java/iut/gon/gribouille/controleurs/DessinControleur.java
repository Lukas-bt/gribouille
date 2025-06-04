package iut.gon.gribouille.controleurs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.gribouille.modele.Dessin;
import iut.gon.gribouille.modele.Etoile;
import iut.gon.gribouille.modele.Figure;
import iut.gon.gribouille.modele.Point;
import iut.gon.gribouille.modele.Trace;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DessinControleur implements Initializable {
	
	@FXML
	public Pane page;

	@FXML
	public Canvas toile;

	public Controleur control;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toile.widthProperty().bind(page.widthProperty());
		toile.heightProperty().bind(page.heightProperty());
		toile.heightProperty().addListener((obs, oldVal, newVal) -> {
			control.dessine();
		});
		toile.widthProperty().addListener((obs, oldVal, newVal) -> {
			control.dessine();
		});
		
	}
	
	public void setControleur(Controleur c) {
		this.control = c;
	}
	
	
	public void efface() {
		 toile.getGraphicsContext2D().clearRect(0, 0, toile.getWidth(), toile.getHeight());
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		toile.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}
	
	public void setEpaisseur(int epaisseur) {
		toile.getGraphicsContext2D().setLineWidth(epaisseur);
	}
	
	public void onMousePressed(MouseEvent event) {
		
		control.outilCourant.onMousePressed(event);

	}

	public void onMouseDragged(MouseEvent event) {
		
		control.outilCourant.onMouseDragged(event);

	}
	
	public void onMouseMoved(MouseEvent mouseEvent) {
        control.prevX.set(mouseEvent.getX());
        control.prevY.set(mouseEvent.getY());
    }
	
	
	
}