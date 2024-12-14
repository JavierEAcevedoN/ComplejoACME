package Vista.Manager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public abstract class ManagerBuilder {
    public FlowPane buildMainLayout() {
        FlowPane mainLayout = new FlowPane();
        mainLayout.setPrefSize(553.0, 611.0);

        // Adding the top HBox section
        mainLayout.getChildren().add(buildTopBar());

        // Adding the main TabPane section
        mainLayout.getChildren().add(buildMainTabPane());

        return mainLayout;
    }

    private HBox buildTopBar() {
        HBox topBar = new HBox();
        topBar.setPrefSize(553.0, 70.0);
        topBar.getStyleClass().add("brand-color-right");
        topBar.getStylesheets().add(getClass().getResource("/Styles/Base.css").toExternalForm());

        // TextFlow for "ACME"
        TextFlow acmeTextFlow = new TextFlow();
        acmeTextFlow.setPrefSize(221.0, 70.0);
        acmeTextFlow.setTextAlignment(TextAlignment.CENTER);
        acmeTextFlow.setPadding(new Insets(8.0));
        Text acmeText = new Text("ACME");
        acmeText.setFill(javafx.scene.paint.Color.WHITE);
        acmeText.setFont(new Font("DejaVu Sans Bold", 49.0));
        acmeTextFlow.getChildren().add(acmeText);

        // TextFlow for "SuperUsuario"
        TextFlow roleTextFlow = new TextFlow();
        roleTextFlow.setPrefSize(200.0, 70.0);
        roleTextFlow.setTextAlignment(TextAlignment.CENTER);
        roleTextFlow.setPadding(new Insets(18.0));
        Text roleText = new Text(getCurrentUser());
        roleText.setFill(javafx.scene.paint.Color.WHITE);
        roleText.setFont(new Font("Mallanna", 28.0));
        roleTextFlow.getChildren().add(roleText);

        // VBox for Logout Icon
        VBox logOutBox = new VBox();
        logOutBox.setAlignment(Pos.CENTER);
        logOutBox.setPrefSize(97.0, 70.0);
        ImageView logOutImage = new ImageView(new Image("https://static-00.iconduck.com/assets.00/logout-icon-1024x1023-qnlao50d.png"));
        logOutImage.setFitHeight(35);
        logOutImage.setFitWidth(42);
        logOutImage.setCursor(Cursor.HAND);
        logOutBox.getChildren().add(logOutImage);

        // Adding children to topBar
        topBar.getChildren().addAll(acmeTextFlow, roleTextFlow, logOutBox);

        return topBar;
    }

    private TabPane buildMainTabPane() {
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(553.0, 541.0);
        tabPane.setSide(Side.LEFT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Add "Crear Usuario" Tab
        tabPane.getTabs().addAll(getTabs());

        return tabPane;
    }

    protected String getCurrentUser() {
        return "JAVIER";
    };

    protected abstract ArrayList<Tab> getTabs();
}
