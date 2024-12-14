package Vista;
import com.acme.complejoacme.AbstractLoginController;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public abstract class LoginBuilder {

    protected final AnchorPane root;

    AbstractLoginController controller;

    protected LoginBuilder(AbstractLoginController controller) {
        this.root = new AnchorPane();
        this.controller = controller;
        root.setPrefSize(775, 494);
    }

    protected FlowPane createRightPane() {
        FlowPane rightPane = new FlowPane();
        rightPane.setPrefSize(466, 494);
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        rightPane.setVgap(10);
        return rightPane;
    }


    public LoginBuilder withLeftPane() {
        // Crear AnchorPane principal
        AnchorPane leftPane = new AnchorPane();
        leftPane.setPrefHeight(494.0);
        leftPane.setPrefWidth(309.0);
        leftPane.getStyleClass().add("brand-color");
        leftPane.getStylesheets().add(getClass().getResource("/com/acme/complejoacme/Styles/Base.css").toExternalForm());

        // Crear el primer TextFlow con el texto "ACM"
        TextFlow textFlowACM = new TextFlow();
        textFlowACM.setLayoutY(168.0);
        textFlowACM.setPrefHeight(74.0);
        textFlowACM.setPrefWidth(251.0);
        textFlowACM.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        Text textACM = new Text("ACM");
        textACM.setFill(javafx.scene.paint.Color.WHITE);
        textACM.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textACM.setStrokeWidth(0.0);
        textACM.setFont(Font.font("DejaVu Sans", FontWeight.BOLD,72));
        textFlowACM.getChildren().add(textACM);

        // Crear el ImageView con la imagen
        ImageView logo = new ImageView(new Image("https://www.giantbomb.com/a/uploads/square_small/3/34651/3461096-wile-e.-coyote.png"));
        logo.setFitHeight(152.0);
        logo.setFitWidth(144.0);
        logo.setLayoutX(90.0);
        logo.setLayoutY(78.0);
        logo.setPreserveRatio(true);

        // Crear el segundo TextFlow con el texto "E"
        TextFlow textFlowE = new TextFlow();
        textFlowE.setLayoutX(16.0);
        textFlowE.setLayoutY(168.0);
        textFlowE.setPrefHeight(84.0);
        textFlowE.setPrefWidth(230.0);
        textFlowE.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);

        Text textE = new Text("E");
        textE.setFill(javafx.scene.paint.Color.WHITE);
        textE.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textE.setStrokeWidth(0.0);
        textE.setFont(Font.font("DejaVu Sans", FontWeight.BOLD,72));
        textFlowE.getChildren().add(textE);

        // Crear el tercer TextFlow con el texto "Complejo Empresarial"
        TextFlow textFlowSubtitle = new TextFlow();
        textFlowSubtitle.setLayoutX(29.0);
        textFlowSubtitle.setLayoutY(247.0);
        textFlowSubtitle.setPrefHeight(31.0);
        textFlowSubtitle.setPrefWidth(230.0);
        textFlowSubtitle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        Text textSubtitle = new Text("Complejo Empresarial");
        textSubtitle.setFill(javafx.scene.paint.Color.WHITE);
        textSubtitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textSubtitle.setStrokeWidth(0.0);
        textSubtitle.setFont(Font.font("DejaVu Sans", 20.0));
        textFlowSubtitle.getChildren().add(textSubtitle);

        // Crear el cuarto TextFlow con el texto "v 0.1"
        TextFlow textFlowVersion = new TextFlow();
        textFlowVersion.setLayoutX(40.0);
        textFlowVersion.setLayoutY(449.0);
        textFlowVersion.setPrefHeight(31.0);
        textFlowVersion.setPrefWidth(230.0);
        textFlowVersion.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        Text textVersion = new Text("v 0.1");
        textVersion.setFill(javafx.scene.paint.Color.WHITE);
        textVersion.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textVersion.setStrokeWidth(0.0);
        textVersion.setFont(Font.font("DejaVu Sans", 12.0));
        textFlowVersion.getChildren().add(textVersion);

        // Añadir todos los hijos al AnchorPane principal
        leftPane.getChildren().addAll(textFlowACM, logo, textFlowE, textFlowSubtitle, textFlowVersion);


        // Attach to root
        AnchorPane.setLeftAnchor(leftPane, 0.0);
        AnchorPane.setTopAnchor(leftPane, 0.0);
        root.getChildren().add(leftPane);

        return this;
    }

    public abstract LoginBuilder withRightPane();

    public AnchorPane build() {
        return root;
    }
}
