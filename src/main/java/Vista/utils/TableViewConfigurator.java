package Vista.utils;

import Modelo.DAO.Personal.PersonalM;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.lang.reflect.Method;
import java.util.List;

public class TableViewConfigurator {
    public static void initAccesos(TableView<PersonalM> tableView, List<String> columnNames, List<PersonalM> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("La lista de datos está vacía. No se puede inferir el tipo.");
        }

        Class<?> clazz = data.get(0).getClass();

        for (String columnName : columnNames) {
            try {
                String getterMethodName = "get" + capitalize(columnName);

                Method getterMethod = clazz.getMethod(getterMethodName);

                TableColumn<PersonalM, Object> column = new TableColumn<>(capitalize(columnName));

                column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PersonalM, Object>, ObservableValue<Object>>() {
                    @Override
                    public ObservableValue<Object> call(TableColumn.CellDataFeatures<PersonalM, Object> cellData) {
                        try {
                            // Llamamos al método getter para obtener el valor de la propiedad
                            Object value = getterMethod.invoke(cellData.getValue());
                            return new SimpleObjectProperty<>(value);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return new SimpleObjectProperty<>(null);
                        }
                    }
                });

                // Añadimos la columna a la tabla
                tableView.getColumns().add(column);
            } catch (Exception e) {
                System.err.println("Error al acceder a la propiedad '" + columnName + "' en la clase " + clazz.getName());
                e.printStackTrace();
            }
        }

        // Establecemos los datos en la tabla
        ObservableList<PersonalM> observableList = FXCollections.observableArrayList(data);
        tableView.setItems(observableList);
    }

    public static void initPersonalEmpresas(TableView<PersonalM> tableView, List<String> columnNames, List<PersonalM> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("La lista de datos está vacía. No se puede inferir el tipo.");
        }

        Class<?> clazz = data.get(0).getClass(); // Obtenemos la clase de los elementos en la lista

        for (String columnName : columnNames) {
            try {
                // Construimos el nombre del método getter correspondiente (por ejemplo, "getId" para "id")
                String getterMethodName = "get" + capitalize(columnName);

                // Intentamos obtener el método getter
                Method getterMethod = clazz.getMethod(getterMethodName);

                // Creamos una columna para la tabla con el nombre de la columna capitalizado
                TableColumn<PersonalM, Object> column = new TableColumn<>(capitalize(columnName));

                // Usamos un Callback para configurar el CellValueFactory
                column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PersonalM, Object>, ObservableValue<Object>>() {
                    @Override
                    public ObservableValue<Object> call(TableColumn.CellDataFeatures<PersonalM, Object> cellData) {
                        try {
                            // Llamamos al método getter para obtener el valor de la propiedad
                            Object value = getterMethod.invoke(cellData.getValue());
                            return new SimpleObjectProperty<>(value);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return new SimpleObjectProperty<>(null);
                        }
                    }
                });

                // Añadimos la columna a la tabla
                tableView.getColumns().add(column);
            } catch (Exception e) {
                System.err.println("Error al acceder a la propiedad '" + columnName + "' en la clase " + clazz.getName());
                e.printStackTrace();
            }
        }

        // Establecemos los datos en la tabla
        ObservableList<PersonalM> observableList = FXCollections.observableArrayList(data);
        tableView.setItems(observableList);
    }

    private static String capitalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}