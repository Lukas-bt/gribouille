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

import iut.gon.gribouille.modele.Dessin;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private double prevX;
    private double prevY;

    @Override
    public void start(Stage stage) throws IOException {
    	Dessin d = new Dessin();
        scene = new Scene(loadFXML("CadreGribouille", d), 640, 480);
        stage.titleProperty().bind(d.nomDuFichierProperty());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        	
        	boolean res = Dialogues.confirmation();        	
        	if(!res) {
        		event.consume();
        	}
        });
        
    }

    static void setRoot(String fxml, Dessin d) throws IOException {
        scene.setRoot(loadFXML(fxml, d));
    }

    private static Parent loadFXML(String fxml, Dessin d) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent p = fxmlLoader.load();
        ((Controller) fxmlLoader.getController()).setDessin(d);
        return p;
    }

    public static void main(String[] args) {
        launch();
    }

}