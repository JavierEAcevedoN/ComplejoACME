module com.acme.complejoacme {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.acme.complejoacme to javafx.fxml;
    exports com.acme.complejoacme;
    exports com.acme.complejoacme.Login;
    opens com.acme.complejoacme.Login to javafx.fxml;
}