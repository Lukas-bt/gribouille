package iut.gon.gribouille;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private double prevX;
    private double prevY;
    Canvas dessin;
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("CadreGribouille"), 640, 480);
        dessin = (Canvas) scene.lookup("Canvas");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        	
        	boolean res = Dialogues.confirmation();        	
        	if(!res) {
        		event.consume();
        	}
        });
        
        dessin.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				prevX = event.getX();
				prevY = event.getY();
				
			}
        	
        });
        
        dessin.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				dessin.getGraphicsContext2D().strokeLine(prevX, prevY, event.getX(),event.getY());
				prevX = event.getX();
				prevY = event.getY();
			}
        	
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}