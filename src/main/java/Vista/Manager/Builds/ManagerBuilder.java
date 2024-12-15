package Vista.Manager.Builds;

import Modelo.DataBaseConection;
import Vista.utils.DraggableWindow;
import com.acme.complejoacme.Manager.ManagerController;
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
import javafx.scene.text.*;

import java.util.ArrayList;

public abstract class ManagerBuilder {
    protected final FlowPane root;

    protected ManagerController controller;

    public ManagerBuilder(ManagerController controller) {
        this.controller = controller;
        this.root = buildMainLayout();
    }

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
        DraggableWindow.init(topBar);
        topBar.setPrefSize(553.0, 70.0);
        topBar.getStyleClass().add("brand-color-right");
        topBar.getStylesheets().add(getClass().getResource("/com/acme/complejoacme/Styles/Base.css").toExternalForm());

        // TextFlow for "ACME"
        TextFlow acmeTextFlow = new TextFlow();
        acmeTextFlow.setPrefSize(221.0, 70.0);
        acmeTextFlow.setTextAlignment(TextAlignment.CENTER);
        acmeTextFlow.setPadding(new Insets(8, 0, 0, 0));
        Text acmeText = new Text("ACME");
        acmeText.setFill(javafx.scene.paint.Color.WHITE);
        acmeText.setFont(Font.font("Arial Black",49));
        acmeText.setWrappingWidth(186.11572265625);
        acmeTextFlow.getChildren().add(acmeText);

        TextFlow emptySpace = new TextFlow();
        emptySpace.setLayoutX(10);
        emptySpace.setLayoutY(10);
        emptySpace.setPrefSize(200, 200);
        emptySpace.setTextAlignment(TextAlignment.CENTER);
        emptySpace.setPadding(new Insets(8, 0, 0, 0));

        // TextFlow for "Role"
        TextFlow roleTextFlow = new TextFlow();
        roleTextFlow.setLayoutX(210);
        roleTextFlow.setLayoutY(10);
        roleTextFlow.setPrefSize(200, 200);
        roleTextFlow.setTextAlignment(TextAlignment.CENTER);

        Text roleDisplay = new Text(DataBaseConection.getCurrentRole());
        roleDisplay.setId("roleDisplay");
        roleDisplay.setBlendMode(javafx.scene.effect.BlendMode.DIFFERENCE);
        roleDisplay.setFill(javafx.scene.paint.Color.WHITE);
        roleDisplay.setFont(new Font("Inter", 20));
        roleDisplay.setWrappingWidth(8.02874755859375);

        roleTextFlow.getChildren().add(roleDisplay);
        roleTextFlow.setPadding(new Insets(18, 0, 0, 0));

        // VBox for Logout Icon
        VBox logOutBox = new VBox();
        logOutBox.setAlignment(Pos.CENTER);
        logOutBox.setPrefSize(97.0, 70.0);
        logOutBox.setCursor(Cursor.HAND);
        logOutBox.setOnMouseClicked(e -> controller.exit());
        controller.logOut = logOutBox;

        ImageView logOutImage = new ImageView(new Image("https://static-00.iconduck.com/assets.00/logout-icon-1024x1023-qnlao50d.png"));
        logOutImage.setFitHeight(35);
        logOutImage.setFitWidth(42);
        logOutBox.getChildren().add(logOutImage);

        // Adding children to topBar
        topBar.getChildren().addAll(acmeTextFlow, emptySpace, roleTextFlow, logOutBox);

        return topBar;
    }

    private TabPane buildMainTabPane() {
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(553.0, 541.0);
        tabPane.setSide(Side.LEFT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        tabPane.getTabs().addAll(getTabs());

        return tabPane;
    }

    public FlowPane build() {
        return root;
    }

    protected abstract ArrayList<Tab> getTabs();
}