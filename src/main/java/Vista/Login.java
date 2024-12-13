package Vista;

import com.acme.complejoacme.AbstractLoginController;
import com.acme.complejoacme.LoginController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Login extends LoginBuilder {
    protected Login(AbstractLoginController controller) {
        super(controller);
    }

    public static Login create(AbstractLoginController controller) {
        return new Login(controller);
    }

    public LoginBuilder withRightPane() {
        FlowPane rightPane = createRightPane();

        Text loginTitle = new Text("Iniciar sistema");
        loginTitle.setFont(new Font(20));

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


        Button loginButton = new Button("Iniciar");
        loginButton.setStyle("-fx-background-color: #008000; -fx-text-fill: white;");
        loginButton.setOnAction(e -> controller.Conect());
        controller.conect = loginButton;

        FlowPane buttonPane = new FlowPane(20, 0);
        buttonPane.setAlignment(Pos.BASELINE_CENTER);
        buttonPane.getChildren().addAll(cancelButton, loginButton);

        rightPane.getChildren().addAll(loginTitle, userLabel, userField, passLabel, passField, buttonPane);

        AnchorPane.setRightAnchor(rightPane, 0.0);
        AnchorPane.setTopAnchor(rightPane, 0.0);
        root.getChildren().add(rightPane);

        return this;
    }
}
