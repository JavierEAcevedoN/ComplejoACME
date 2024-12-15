package Vista.Login;

import com.acme.complejoacme.Login.AbstractLoginController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SuperLogin extends LoginBuilder{

    protected SuperLogin(AbstractLoginController controller) {
        super(controller);
    }

    public static SuperLogin create(AbstractLoginController controller) {
        return new SuperLogin(controller);
    }
    @Override
    public LoginBuilder withRightPane() {
        FlowPane rightPane = createRightPane();

        Text dbTitle = new Text("Conexion a Base de datos");
        dbTitle.setFont(new Font(20));

        Label dbAddressLabel = new Label("Direccion base de datos");
        TextField dbAddress = new TextField();
        controller.dbadress = dbAddress;

        Label dbPortLabel = new Label("Puerto");
        TextField dbPort = new TextField();
        controller.dbport = dbPort;

        Label userLabel = new Label("Usuario");
        TextField userField = new TextField();
        controller.user = userField;

        Label passLabel = new Label("Contraseña");
        PasswordField passField = new PasswordField();
        controller.pass = passField;

        Button cancelButton = new Button("Cancelar");
        cancelButton.setStyle("-fx-background-color: #FF0000FF; -fx-text-fill: white;");
        cancelButton.setOnAction(e -> controller.close());
        controller.cancel = cancelButton;

        Button connectButton = new Button("Conectar");
        connectButton.setStyle("-fx-background-color: #008000; -fx-text-fill: white;");
        connectButton.setOnAction(e -> controller.Conect());
        controller.conect = connectButton;

        FlowPane buttonPane = new FlowPane(20, 0);
        buttonPane.setAlignment(Pos.BASELINE_CENTER);
        buttonPane.getChildren().addAll(cancelButton, connectButton);

        rightPane.getChildren().addAll(dbTitle, dbAddressLabel, dbAddress, dbPortLabel, dbPort,userLabel, userField, passLabel, passField, buttonPane);

        AnchorPane.setRightAnchor(rightPane, 0.0);
        AnchorPane.setTopAnchor(rightPane, 0.0);
        root.getChildren().add(rightPane);

        return this;
    }
}