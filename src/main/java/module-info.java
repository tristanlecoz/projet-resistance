module com.mycompany.projet.resistance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens com.mycompany.projet.resistance to javafx.fxml;
    exports com.mycompany.projet.resistance;
}
