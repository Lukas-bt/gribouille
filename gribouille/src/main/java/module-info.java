module iut.gon.gribouille {
    requires javafx.controls;
    requires javafx.fxml;

    opens iut.gon.gribouille to javafx.fxml;
    exports iut.gon.gribouille;
}
