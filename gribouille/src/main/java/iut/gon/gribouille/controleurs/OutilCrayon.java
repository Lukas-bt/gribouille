package iut.gon.gribouille.controleurs;

import iut.gon.gribouille.modele.Figure;
import iut.gon.gribouille.modele.Trace;
import javafx.scene.input.MouseEvent;

public class OutilCrayon extends Outil {
	
	

	public OutilCrayon(Controleur ctrl) {
		super(ctrl);
	}

	@Override
	public void onMousePressed(MouseEvent event) {
		System.out.println("a");
		control.figureCourante = new Trace(control.epaisseur.getValue(), "black", event.getX(), event.getY());
		control.dessin.addFigure(control.figureCourante);
		control.prevX.set(event.getX());
		control.prevY.set(event.getY());
		
		
		
	}


	@Override
	public void onMouseDragged(MouseEvent event) {
		
		control.dessinController.trace(control.prevX.getValue(), control.prevY.getValue(), event.getX(), event.getY());
		control.figureCourante.addPoint(event.getX(), event.getY());
		control.prevX.set(event.getX());
        control.prevY.set(event.getY());
	}
	
}