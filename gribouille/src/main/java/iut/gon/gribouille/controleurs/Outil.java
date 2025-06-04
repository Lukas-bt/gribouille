package iut.gon.gribouille.controleurs;

import javafx.scene.input.MouseEvent;

public abstract class Outil {
	
	protected Controleur control;
	
	public Outil(Controleur ctrl){
		this.control = ctrl;
	}
	
	
	public abstract void onMousePressed(MouseEvent evt);
	public abstract void onMouseDragged(MouseEvent evt);
	
	
	
}