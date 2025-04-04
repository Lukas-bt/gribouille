module iut.gon.gribouille {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens iut.gon.gribouille to javafx.fxml;
    exports iut.gon.gribouille;
}
