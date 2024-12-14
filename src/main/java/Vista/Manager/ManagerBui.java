package Vista.Manager;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class ManagerBui {

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
        Text roleText = new Text("SuperUsuario");
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
        tabPane.getTabs().add(buildCrearUsuarioTab());

        // Add "Nuevo Registro" Tab
        tabPane.getTabs().add(buildNuevoRegistroTab());

        return tabPane;
    }

    private VBox createLabeledField(String labelText, Control inputControl) {
        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(8.0);

        Label label = new Label(labelText);
        container.getChildren().addAll(label, inputControl);

        return container;
    }

    private Tab buildCrearUsuarioTab() {
        Tab crearUsuarioTab = new Tab("Crear Usuario");

        FlowPane content = new FlowPane();
        content.setAlignment(Pos.CENTER);

        VBox form = new VBox();
        form.setAlignment(Pos.CENTER_RIGHT);
        form.setSpacing(40.0);
        form.setPrefSize(280.0, 541.0);

        // Empresa Section
        VBox empresaSection = createLabeledField("Empresa", new ChoiceBox<>());

        // Rol Section
        VBox rolSection = createLabeledField("Rol del usuario", new ChoiceBox<>());

        // Usuario Section
        VBox usuarioSection = createLabeledField("Usuario", new TextField());

        // Contraseña Section
        VBox contrasenaSection = createLabeledField("Contraseña", new PasswordField());

        // Guardar Button
        Button guardarButton = new Button("Guardar");
        guardarButton.setDefaultButton(true);
        guardarButton.setCursor(Cursor.HAND);

        form.getChildren().addAll(empresaSection, rolSection, usuarioSection, contrasenaSection, guardarButton);
        content.getChildren().add(form);
        crearUsuarioTab.setContent(content);

        return crearUsuarioTab;
    }

    private Tab buildNuevoRegistroTab() {
        Tab nuevoRegistroTab = new Tab("Nuevo Registro");

        FlowPane mainContent = new FlowPane();
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setHgap(20.0);
        mainContent.setPrefWrapLength(10.0);

        TabPane innerTabPane = new TabPane();
        innerTabPane.setPrefSize(522.0, 541.0);
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // "Registrar Personal" Tab
        Tab registrarPersonalTab = new Tab("Registrar Personal");
        FlowPane personalContent = new FlowPane();
        personalContent.setAlignment(Pos.CENTER);
        personalContent.setHgap(20.0);

        GridPane personalForm = new GridPane();
        personalForm.setAlignment(Pos.CENTER);
        personalForm.setPrefSize(491.0, 541.0);
        personalForm.setHgap(20.0);
        personalForm.setVgap(20.0);

        // Column and Row Constraints
        for (int i = 0; i < 2; i++) {
            personalForm.getColumnConstraints().add(new ColumnConstraints(100.0, 100.0, Double.MAX_VALUE));
        }
        for (int i = 0; i < 4; i++) {
            personalForm.getRowConstraints().add(new RowConstraints(30.0, 30.0, Double.MAX_VALUE));
        }

        // Personal Form Fields
        personalForm.add(createLabeledField("Identificacion", new TextField()), 0, 0);
        personalForm.add(createLabeledField("Nombre de la persona", new TextField()), 1, 0);
        personalForm.add(createLabeledField("Dirección de residencia", new TextField()), 0, 1);
        personalForm.add(createLabeledField("Contacto Telefonico", new TextField()), 1, 1);
        personalForm.add(createLabeledField("Tipo de personal", new ChoiceBox<>()), 1, 2);
        personalForm.add(createLabeledField("Usuario de acceso", new TextField()), 0, 2);

        // Guardar Button
        Button guardarPersonalButton = new Button("Guardar");
        guardarPersonalButton.setDefaultButton(true);
        guardarPersonalButton.setCursor(Cursor.HAND);
        personalForm.add(guardarPersonalButton, 1, 3);

        personalContent.getChildren().add(personalForm);
        registrarPersonalTab.setContent(personalContent);
        innerTabPane.getTabs().add(registrarPersonalTab);

        // "Registrar Vehiculo" Tab
        Tab registrarVehiculoTab = new Tab("Registrar Vehiculo");
        FlowPane vehiculoContent = new FlowPane();
        vehiculoContent.setAlignment(Pos.CENTER);

        VBox vehiculoForm = new VBox();
        vehiculoForm.setAlignment(Pos.CENTER_RIGHT);
        vehiculoForm.setSpacing(40.0);
        vehiculoForm.setPrefSize(280.0, 541.0);

        vehiculoForm.getChildren().addAll(
                createLabeledField("Usuario Responsable", new TextField()),
                createLabeledField("Placa del Vehiculo", new TextField()),
                new Button("Guardar") {{
                    setDefaultButton(true);
                    setCursor(Cursor.HAND);
                }}
        );

        vehiculoContent.getChildren().add(vehiculoForm);
        registrarVehiculoTab.setContent(vehiculoContent);
        innerTabPane.getTabs().add(registrarVehiculoTab);

        mainContent.getChildren().add(innerTabPane);
        nuevoRegistroTab.setContent(mainContent);

        return nuevoRegistroTab;
    }

    // Método para crear la pestaña "Permiso Visitante"
    private Tab createPermisoTab() {
        Tab permisoTab = new Tab();
        permisoTab.setText("Permiso Visitante");

        // Crear el FlowPane
        FlowPane flowPane = new FlowPane();
        flowPane.setVgap(10);

        // Crear VBox principal
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        // Crear el primer HBox con el campo de Identificador
        HBox hbox1 = new HBox(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().add(createLabeledField("Identificador", new TextField()));

        // Crear el segundo HBox con las fechas de inicio y fin
        HBox hbox2 = new HBox(25);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(createLabeledField("Fecha de inicio", new DatePicker()),
                createLabeledField("Fecha de fin", new DatePicker()));

        // Crear el botón Guardar
        HBox hbox3 = new HBox();
        hbox3.setAlignment(Pos.CENTER);
        Button guardarButton = new Button("Guardar");
        guardarButton.setDefaultButton(true);
        guardarButton.setCursor(Cursor.HAND);
        hbox3.getChildren().add(guardarButton);

        // Agregar todos los HBox al VBox principal
        vbox.getChildren().addAll(hbox1, hbox2, hbox3);
        flowPane.getChildren().add(vbox);

        // Agregar el FlowPane a la pestaña
        permisoTab.setContent(flowPane);

        return permisoTab;
    }

    // Método para crear la pestaña "Control Ingresos"
    private Tab createControlIngresosTab() {
        Tab controlIngresosTab = new Tab();
        controlIngresosTab.setText("Control Ingresos");

        // Crear FlowPane y TabPane dentro de esta pestaña
        FlowPane flowPane = new FlowPane();
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear los tabs "Acceso Personal" y "Acceso Vehicular"
        Tab accesoPersonalTab = createAccesoPersonalTab();
        Tab accesoVehiculoTab = createAccesoVehiculoTab();
        tabPane.getTabs().addAll(accesoPersonalTab, accesoVehiculoTab);

        flowPane.getChildren().add(tabPane);
        controlIngresosTab.setContent(flowPane);

        return controlIngresosTab;
    }

    // Método para crear la pestaña "Control Salidas"
    private Tab createControlSalidasTab() {
        Tab controlSalidasTab = new Tab();
        controlSalidasTab.setText("Control Salidas");

        // Crear FlowPane y TabPane dentro de esta pestaña
        FlowPane flowPane = new FlowPane();
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear los tabs "Salida Personal" y "Salida Vehicular"
        Tab salidaPersonalTab = createSalidaPersonalTab();
        Tab salidaVehiculoTab = createSalidaVehiculoTab();
        tabPane.getTabs().addAll(salidaPersonalTab, salidaVehiculoTab);

        flowPane.getChildren().add(tabPane);
        controlSalidasTab.setContent(flowPane);

        return controlSalidasTab;
    }

    // Métodos para crear cada uno de los tabs dentro de Control Ingresos
    private Tab createAccesoPersonalTab() {
        Tab accesoPersonalTab = new Tab();
        accesoPersonalTab.setText("Acceso Personal");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(createLabeledField("Identificador del personal", new TextField()));

        Button permitirAccesoButton = new Button("Permitir acceso");
        permitirAccesoButton.setDefaultButton(true);
        permitirAccesoButton.setCursor(Cursor.HAND);

        vbox.getChildren().add(permitirAccesoButton);
        flowPane.getChildren().add(vbox);
        accesoPersonalTab.setContent(flowPane);

        return accesoPersonalTab;
    }

    private Tab createAccesoVehiculoTab() {
        Tab accesoVehiculoTab = new Tab();
        accesoVehiculoTab.setText("Acceso Vehicular");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(createLabeledField("Placa", new TextField()));

        Button permitirAccesoButton = new Button("Permitir acceso");
        permitirAccesoButton.setDefaultButton(true);
        permitirAccesoButton.setCursor(Cursor.HAND);

        vbox.getChildren().add(permitirAccesoButton);
        flowPane.getChildren().add(vbox);
        accesoVehiculoTab.setContent(flowPane);

        return accesoVehiculoTab;
    }

    // Métodos para crear cada uno de los tabs dentro de Control Salidas
    private Tab createSalidaPersonalTab() {
        Tab salidaPersonalTab = new Tab();
        salidaPersonalTab.setText("Salida Personal");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(createLabeledField("Identificador del personal", new TextField()));

        Button registrarSalidaButton = new Button("Registrar Salida");
        registrarSalidaButton.setDefaultButton(true);
        registrarSalidaButton.setCursor(Cursor.HAND);

        vbox.getChildren().add(registrarSalidaButton);
        flowPane.getChildren().add(vbox);
        salidaPersonalTab.setContent(flowPane);

        return salidaPersonalTab;
    }

    private Tab createSalidaVehiculoTab() {
        Tab salidaVehiculoTab = new Tab();
        salidaVehiculoTab.setText("Salida Vehicular");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(createLabeledField("Placa", new TextField()));

        Button registrarSalidaButton = new Button("Registrar Salida");
        registrarSalidaButton.setDefaultButton(true);
        registrarSalidaButton.setCursor(Cursor.HAND);

        vbox.getChildren().add(registrarSalidaButton);
        flowPane.getChildren().add(vbox);
        salidaVehiculoTab.setContent(flowPane);

        return salidaVehiculoTab;
    }

    // Método para crear la pestaña "Disciplinario"
    private Tab createDisciplinarioTab() {
        Tab disciplinarioTab = new Tab();
        disciplinarioTab.setText("Disciplinario");

        // Crear el FlowPane que contiene el TabPane de la pestaña
        FlowPane flowPane = new FlowPane();

        // Crear TabPane interno para la pestaña "Disciplinario"
        TabPane innerTabPane = new TabPane();
        innerTabPane.setSide(Side.RIGHT);
        innerTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear los tabs "Incidentes" y "Restricciones"
        Tab incidentesTab = createIncidentesTab();
        Tab restriccionesTab = createRestriccionesTab();

        innerTabPane.getTabs().addAll(incidentesTab, restriccionesTab);
        flowPane.getChildren().add(innerTabPane);
        disciplinarioTab.setContent(flowPane);

        return disciplinarioTab;
    }

    // Método para crear la pestaña "Incidentes"
    private Tab createIncidentesTab() {
        Tab incidentesTab = new Tab();
        incidentesTab.setText("Incidentes");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        // Contenedor con HBox para seleccionar tipo de incidente y personal implicado
        HBox hbox1 = new HBox(20);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(createLabeledField("Seleccionar Incidente", new ChoiceBox<>()),
                createLabeledField("Identificador del personal Implicado", new TextField()));

        // Contenedor con HBox para la descripción del suceso
        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(createLabeledField("Descripción del suceso", new TextArea()));

        // Contenedor con botones para consultar y registrar incidente
        HBox hbox3 = new HBox(30);
        hbox3.setAlignment(Pos.CENTER);
        Button consultaButton = new Button("Consultar Historial");
        consultaButton.setCursor(Cursor.HAND);
        Button registrarButton = new Button("Registrar Incidente");
        registrarButton.setCursor(Cursor.HAND);
        hbox3.getChildren().addAll(consultaButton, registrarButton);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3);
        flowPane.getChildren().add(vbox);
        incidentesTab.setContent(flowPane);

        return incidentesTab;
    }

    // Método para crear la pestaña "Restricciones"
    private Tab createRestriccionesTab() {
        Tab restriccionesTab = new Tab();
        restriccionesTab.setText("Restricciones");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        // Crear el TabPane interno para "Aplicar Restricción" y "Levantar Restricción"
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear las pestañas de "Aplicar Restricción" y "Levantar Restricción"
        Tab aplicarRestTab = createAplicarRestriccionTab();
        Tab levantarRestTab = createLevantarRestriccionTab();

        tabPane.getTabs().addAll(aplicarRestTab, levantarRestTab);
        flowPane.getChildren().add(tabPane);
        restriccionesTab.setContent(flowPane);

        return restriccionesTab;
    }

    // Método para crear la pestaña "Aplicar Restricción"
    private Tab createAplicarRestriccionTab() {
        Tab aplicarRestTab = new Tab();
        aplicarRestTab.setText("Aplicar Restricción");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        // Contenedor con ChoiceBox para seleccionar restricción y TextField para el personal
        vbox.getChildren().addAll(
                createLabeledField("Seleccionar Restricción", new ChoiceBox<>()),
                createLabeledField("Identificador del personal a Restringir", new TextField())
        );

        // Botones de consulta y aplicar restricción
        HBox hbox = new HBox(30);
        hbox.setAlignment(Pos.CENTER);
        Button consultaButton = new Button("Consultar Historial");
        consultaButton.setCursor(Cursor.HAND);
        Button aplicarButton = new Button("Aplicar Restricción");
        aplicarButton.setCursor(Cursor.HAND);
        hbox.getChildren().addAll(consultaButton, aplicarButton);

        vbox.getChildren().add(hbox);
        flowPane.getChildren().add(vbox);
        aplicarRestTab.setContent(flowPane);

        return aplicarRestTab;
    }

    // Método para crear la pestaña "Levantar Restricción"
    private Tab createLevantarRestriccionTab() {
        Tab levantarRestTab = new Tab();
        levantarRestTab.setText("Levantar Restricción");

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        // Contenedor con TextField para el personal restringido y TextArea para la justificación
        HBox hbox1 = new HBox(20);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(createLabeledField("Identificador del personal Restringido", new TextField()));

        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(createLabeledField("Justificación del levantamiento", new TextArea()));

        // Botón para levantar la restricción
        Button levantarButton = new Button("Levantar Restricción");
        levantarButton.setCursor(Cursor.HAND);

        vbox.getChildren().addAll(hbox1, hbox2, levantarButton);
        flowPane.getChildren().add(vbox);
        levantarRestTab.setContent(flowPane);

        return levantarRestTab;
    }

    // Método para crear el Tab "Reportes"
    public Tab createReportesTab() {
        Tab reportesTab = new Tab("Reportes");

        // FlowPane que contiene el TabPane con sus Tab internos
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(createReportesTabPane());

        reportesTab.setContent(flowPane);
        return reportesTab;
    }

    // Método para crear el TabPane dentro de "Reportes"
    private TabPane createReportesTabPane() {
        TabPane tabPane = new TabPane();
        tabPane.setPrefHeight(541.0);
        tabPane.setPrefWidth(522.0);
        tabPane.setSide(Side.RIGHT);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Agregar los Tabs dentro de este TabPane
        tabPane.getTabs().add(createEstadoPersonalTab());
        tabPane.getTabs().add(createPersonalEmpresasTab());
        tabPane.getTabs().add(createAccesosTab());

        return tabPane;
    }

    // Método para crear el Tab "Estado Personal Autorizado"
    private Tab createEstadoPersonalTab() {
        Tab estadoPersonalTab = new Tab("Estado Personal Autorizado");
        estadoPersonalTab.setId("ReporteEstado");

        // FlowPane que contiene el contenido del Tab
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(createEstadoPersonalContent());

        estadoPersonalTab.setContent(flowPane);
        return estadoPersonalTab;
    }

    // Método para crear el contenido de "Estado Personal Autorizado"
    private VBox createEstadoPersonalContent() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPrefHeight(541.0);
        vbox.setPrefWidth(491.0);

        HBox hbox1 = new HBox(5);
        hbox1.setAlignment(Pos.CENTER_LEFT);
        hbox1.setPrefHeight(100.0);
        hbox1.setPrefWidth(200.0);

        VBox vboxLeft = createCheckBoxesForEstadoPersonal();
        FlowPane flowPaneRight = createFlowPaneForEstadoPersonal();

        hbox1.getChildren().addAll(vboxLeft, flowPaneRight);

        TableView<?> table = createTableForEstadoPersonal();

        vbox.getChildren().addAll(hbox1, table);
        return vbox;
    }

    // Crear CheckBoxes para "Estado Personal Autorizado"
    private VBox createCheckBoxesForEstadoPersonal() {
        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPrefHeight(200.0);
        vbox.setPrefWidth(100.0);

        CheckBox activos = new CheckBox("Activos");
        CheckBox inactivos = new CheckBox("Inactivos");
        CheckBox supervisores = new CheckBox("Supervisores");
        CheckBox guardas = new CheckBox("Guardas");
        CheckBox funcionarios = new CheckBox("Funcionarios");

        vbox.getChildren().addAll(activos, inactivos, supervisores, guardas, funcionarios);
        return vbox;
    }

    // Crear FlowPane para las opciones de "Estado Personal Autorizado"
    private FlowPane createFlowPaneForEstadoPersonal() {
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(8.0);
        flowPane.setPrefHeight(81.0);
        flowPane.setPrefWidth(377.0);

        CheckBox supervisores = new CheckBox("Supervisores");
        CheckBox guardas = new CheckBox("Guardas");
        CheckBox funcionarios = new CheckBox("Funcionarios");

        flowPane.getChildren().addAll(supervisores, guardas, funcionarios);
        return flowPane;
    }

    // Crear la tabla para "Estado Personal Autorizado"
    private TableView<String> createTableForEstadoPersonal() {
        TableView<String> tableView = new TableView<>();
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        TableColumn<String, String> column1 = new TableColumn<>("C1");
        column1.setPrefWidth(75.0);

        TableColumn<String, String> column2 = new TableColumn<>("C2");
        column2.setPrefWidth(75.0);

        tableView.getColumns().addAll(column1, column2);
        return tableView;
    }

    // Método para crear el Tab "Personal Empresas"
    private Tab createPersonalEmpresasTab() {
        Tab personalEmpresasTab = new Tab("Personal Empresas");
        personalEmpresasTab.setId("ReportePersonal");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(createPersonalEmpresasContent());

        personalEmpresasTab.setContent(flowPane);
        return personalEmpresasTab;
    }

    // Método para crear el contenido de "Personal Empresas"
    private VBox createPersonalEmpresasContent() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPrefHeight(541.0);
        vbox.setPrefWidth(491.0);

        HBox hbox = new HBox(5);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefHeight(100.0);
        hbox.setPrefWidth(200.0);

        VBox vboxLeft = createChoiceBoxForPersonalEmpresas();
        FlowPane flowPaneRight = createFlowPaneForPersonalEmpresas();

        hbox.getChildren().addAll(vboxLeft, flowPaneRight);

        TableView<?> table = createTableForPersonalEmpresas();

        vbox.getChildren().addAll(hbox, table);
        return vbox;
    }

    // Crear ChoiceBox para "Personal Empresas"
    private VBox createChoiceBoxForPersonalEmpresas() {
        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefHeight(200.0);
        vbox.setPrefWidth(100.0);

        Label label = new Label("Empresa");
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("Empresa 1", "Empresa 2", "Empresa 3"));

        vbox.getChildren().addAll(label, choiceBox);
        return vbox;
    }

    // Crear FlowPane para "Personal Empresas"
    private FlowPane createFlowPaneForPersonalEmpresas() {
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(8.0);
        flowPane.setPrefHeight(81.0);
        flowPane.setPrefWidth(377.0);

        // Aquí puedes agregar más elementos si es necesario
        return flowPane;
    }

    // Crear la tabla para "Personal Empresas"
    private TableView<String> createTableForPersonalEmpresas() {
        TableView<String> tableView = new TableView<>();
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        TableColumn<String, String> column1 = new TableColumn<>("C1");
        column1.setPrefWidth(75.0);

        TableColumn<String, String> column2 = new TableColumn<>("C2");
        column2.setPrefWidth(75.0);

        tableView.getColumns().addAll(column1, column2);
        return tableView;
    }

    // Método para crear el Tab "Accesos"
    private Tab createAccesosTab() {
        Tab accesosTab = new Tab("Accesos");
        accesosTab.setId("ReporteAccesos");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(createAccesosContent());

        accesosTab.setContent(flowPane);
        return accesosTab;
    }

    // Método para crear el contenido de "Accesos"
    private VBox createAccesosContent() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPrefHeight(541.0);
        vbox.setPrefWidth(491.0);

        HBox hbox = new HBox(5);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(100.0);
        hbox.setPrefWidth(200.0);

        VBox vboxLeft = createDatePickersForAccesos();
        VBox vboxRight = createDatePickersForAccesos();

        hbox.getChildren().addAll(vboxLeft, vboxRight);

        TableView<?> table = createTableForAccesos();

        vbox.getChildren().addAll(hbox, table);
        return vbox;
    }

    // Crear DatePickers para "Accesos"
    private VBox createDatePickersForAccesos() {
        VBox vbox = new VBox(8);
        vbox.setAlignment(Pos.CENTER);

        Label label = new Label("Fecha");
        DatePicker datePicker = new DatePicker();

        vbox.getChildren().addAll(label, datePicker);
        return vbox;
    }

    // Crear la tabla para "Accesos"
    private TableView<String> createTableForAccesos() {
        TableView<String> tableView = new TableView<>();
        tableView.setPrefHeight(574.0);
        tableView.setPrefWidth(491.0);

        TableColumn<String, String> column1 = new TableColumn<>("C1");
        column1.setPrefWidth(75.0);

        TableColumn<String, String> column2 = new TableColumn<>("C2");
        column2.setPrefWidth(75.0);

        tableView.getColumns().addAll(column1, column2);
        return tableView;
    }

    public Tab createMonitorTab() {
        Tab monitorTab = new Tab("Monitor");

        // FlowPane que contiene el contenido del Tab
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(createMonitorContent());

        monitorTab.setContent(flowPane);
        return monitorTab;
    }

    // Método para crear el contenido de "Monitor"
    private VBox createMonitorContent() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPrefHeight(543.0);
        vbox.setPrefWidth(522.0);

        // Crear la tabla para "Monitor"
        TableView<?> table = createMonitorTable();

        vbox.getChildren().add(table);
        return vbox;
    }

    // Método para crear la tabla para "Monitor"
    private TableView<String > createMonitorTable() {
        TableView<String > tableView = new TableView<>();
        tableView.setPrefHeight(543.0);
        tableView.setPrefWidth(522.0);

        // Definir las columnas de la tabla
        TableColumn<String , String > column1 = new TableColumn<>("C1");
        column1.setPrefWidth(75.0);

        TableColumn<String , String > column2 = new TableColumn<>("C2");
        column2.setPrefWidth(75.0);

        tableView.getColumns().addAll(column1, column2);
        return tableView;
    }
}
