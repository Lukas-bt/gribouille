package iut.gon.gribouille.controleurs;

import iut.gon.gribouille.modele.Etoile;
import javafx.scene.input.MouseEvent;

public class OutilEtoile extends Outil {
	
	double prevX;
	double prevY;

	public OutilEtoile(Controleur ctrl) {
		super(ctrl);
	}

	@Override
	public void onMousePressed(MouseEvent evt) {
		control.figureCourante = new Etoile(control.epaisseur.getValue(), "black", evt.getX(), evt.getY());
		control.dessin.addFigure(control.figureCourante);
		prevX = evt.getX();
		prevY = evt.getY();
		
		
	}

	@Override
	public void onMouseDragged(MouseEvent evt) {
		
		if(control.figureCourante != null) {
			control.figureCourante.addPoint(evt.getX(), evt.getY());
		}
		
		control.dessinController.trace(prevX, prevY, evt.getX(), evt.getY());
		control.prevX.set(evt.getX());
        control.prevY.set(evt.getY());
	}
	
}