package Vista.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

public class TableViewConfigurator {
    public static <T> void init(TableView<T> tableView, List<String> columnNames, List<T> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("La lista de datos está vacía. No se puede inferir el tipo.");
        }

        Class<?> clazz = data.get(0).getClass();

        for (String columnName : columnNames) {
            try {
                Field field = clazz.getDeclaredField(columnName);

                TableColumn<T, ?> column = new TableColumn<>(capitalize(columnName));

                column.setCellValueFactory(new PropertyValueFactory<>(columnName));

                tableView.getColumns().add(column);
            } catch (NoSuchFieldException e) {
                System.err.println("La propiedad '" + columnName + "' no existe en la clase " + clazz.getName());
            }
        }

        ObservableList<T> observableList = FXCollections.observableArrayList(data);
        tableView.setItems(observableList);
    }

    private static String capitalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}