package iut.gon.gribouille;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import iut.gon.gribouille.modele.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Controller implements Initializable {

	private double prevX;
	private double prevY;
	private Dessin dessin;

	@FXML
	private Label co_x;

	@FXML
	private Label co_y;

	@FXML
	private ColorPicker color_picker;

	@FXML
	private Rectangle col_red;

	@FXML
	private Rectangle col_green;

	@FXML
	private Rectangle col_dark_blue;

	@FXML
	private Rectangle col_light_blue;

	@FXML
	private Rectangle col_pink;

	@FXML
	private Rectangle col_yellow;

	@FXML
	private Rectangle col_black;

	@FXML
	private Rectangle col_white;

	@FXML
	private Pane page;

	@FXML
	private Canvas toile;
	
	private Trace actualTrace;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		toile.widthProperty().bind(page.widthProperty());
		toile.heightProperty().bind(page.heightProperty());
		toile.heightProperty().addListener((obs, oldVal, newVal) -> {
			redessine();
		});
		toile.widthProperty().addListener((obs, oldVal, newVal) -> {
			redessine();
		});
		toile.setOnMouseMoved(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		        co_x.setText(Double.toString(event.getX()));
		        co_y.setText(Double.toString(event.getY()));
		    }
		});


	}

	public void onMousePressed(MouseEvent event) {
		prevX = event.getX();
		prevY = event.getY();
		this.actualTrace = new Trace(1, "black", event.getX(), event.getY());
		dessin.addFigure(actualTrace);
		
	}

	public void onMouseDragged(MouseEvent event) {
		toile.getGraphicsContext2D().strokeLine(prevX, prevY, event.getX(), event.getY());
		actualTrace.addPoint(event.getX(), event.getY());
		prevX = event.getX();
		prevY = event.getY();
		co_x.setText(Double.toString(event.getX()));
        co_y.setText(Double.toString(event.getY()));
	}
	
	
	
	public void redessine() {
		toile.getGraphicsContext2D().clearRect(0, 0, toile.getWidth(), toile.getHeight());;
		List<Figure> tab = dessin.getFigures();
		for(int i = 0; i < tab.size(); i++ ) {
			Figure f = tab.get(i); // redessiner les figures
			List<Point> tabP = f.getPoints();
			for(int j = 0; j < tabP.size() -1; j++) {
				Point p1 = tabP.get(j);
				Point p2 = tabP.get(j+1);
				toile.getGraphicsContext2D().strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
			
		}
	}
	
	public void setDessin(Dessin d) {
		this.dessin = d;
	}

}
