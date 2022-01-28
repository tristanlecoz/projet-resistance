module com.mycompany.projet.resistance {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.projet.resistance to javafx.fxml;
    exports com.mycompany.projet.resistance;
}
