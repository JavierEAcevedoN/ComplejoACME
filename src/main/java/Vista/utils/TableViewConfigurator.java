package Vista.utils;

import Modelo.DAO.CAPersonal.CAPersonalM;
import Modelo.DAO.CAPersonal.CCAPersonal;
import Modelo.DAO.Personal.PersonalM;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TableViewConfigurator {
    static int contar = 0;

    public static <T> void init(TableView<T> tableView, List<String> columnNames, List<T> data) {
        tableView.getColumns().clear();
        tableView.getItems().clear();
        if (data.isEmpty()) {
            return;
        }

        Class<?> clazz = data.get(0).getClass(); 

        for (String columnName : columnNames) {
            try {
                
                String getterMethodName = "get" + capitalize(columnName);

                
                Method getterMethod = clazz.getMethod(getterMethodName);

                
                Class<?> returnType = getterMethod.getReturnType();

                
                TableColumn<T, Object> column = new TableColumn<>(capitalize(columnName));

                
                column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<T, Object>, ObservableValue<Object>>() {
                    @Override
                    public ObservableValue<Object> call(TableColumn.CellDataFeatures<T, Object> cellData) {
                        try {
                            
                            Object value = getterMethod.invoke(cellData.getValue());

                            
                            if (isCustomClass(returnType)) {
                                
                                
                                String className = returnType.getSimpleName();
                                switch (className) {
                                    case "PersonalM":

                                        if (contar > 0) {
                                            contar = 0;
                                            break;
                                        }
                                        contar++;

                                        init(tableView, List.of("id_Personal"), data);
                                        break;
                                    default:
                                        
                                        return new SimpleObjectProperty<>(value);
                                }
                            } else {
                                
                                return new SimpleObjectProperty<>(value);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            return new SimpleObjectProperty<>(null);
                        }
                        return null;
                    }
                });

                
                tableView.getColumns().add(column);

            } catch (Exception e) {
                System.err.println("Error al acceder a la propiedad '" + columnName + "' en la clase " + clazz.getName());
                e.printStackTrace();
            }
        }

        
        ObservableList<T> observableList = FXCollections.observableArrayList(data);
        tableView.setItems(observableList);
    }

    public static <T> void initThread(TableView<T> tableView, List<String> columnNames, List<T> data) {
        tableView.getColumns().clear();
        tableView.getItems().clear();

        if (data == null) {
            return;
        }

        Class<?> clazz = data.getClass(); 

        for (String columnName : columnNames) {
            try {
                
                String getterMethodName = "get" + capitalize(columnName);

                
                Method getterMethod = clazz.getMethod(getterMethodName);

                
                Class<?> returnType = getterMethod.getReturnType();

                
                TableColumn<T, Object> column = new TableColumn<>(capitalize(columnName));

                
                column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<T, Object>, ObservableValue<Object>>() {
                    @Override
                    public ObservableValue<Object> call(TableColumn.CellDataFeatures<T, Object> cellData) {
                        try {
                            
                            Object value = getterMethod.invoke(cellData.getValue());

                            
                            if (isCustomClass(returnType)) {
                                
                                
                                String className = returnType.getSimpleName();
                                switch (className) {
                                    case "PersonalM":
                                        if (contar > 0) {
                                            contar = 0;
                                            break;
                                        }
                                        contar++;
                                        
                                        init(tableView, List.of("id_Personal"), data);
                                        break;
                                    default:
                                        
                                        return new SimpleObjectProperty<>(value);
                                }
                            } else {
                                
                                return new SimpleObjectProperty<>(value);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return new SimpleObjectProperty<>(null);
                        }
                        return null;
                    }
                });

                
                tableView.getColumns().add(column);

            } catch (Exception e) {
                System.err.println("Error al acceder a la propiedad '" + columnName + "' en la clase " + clazz.getName());
                e.printStackTrace();
            }
        }

        
        ObservableList<T> observableList = FXCollections.observableArrayList(data);
        tableView.setItems(observableList);
    }

    
    private static boolean isCustomClass(Class<?> clazz) {
        
        return !(clazz.isPrimitive() || clazz == String.class || clazz.isEnum() || isWrapperType(clazz));
    }

    
    private static boolean isWrapperType(Class<?> clazz) {
        return clazz == Integer.class || clazz == Long.class || clazz == Double.class ||
                clazz == Float.class || clazz == Boolean.class || clazz == Character.class ||
                clazz == Byte.class || clazz == Short.class || clazz == Void.class;
    }

    
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    
    public static void actualizarTablaPeriodicamente(TableView<MonitorRes> tableView, Timestamp time) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        
        Runnable task = new Runnable() {
            @Override
            public void run() {
                
                CCAPersonal ccapersonal = CCAPersonal.getInstance();

                
                ccapersonal.reiniciarP();
                ccapersonal.getLista();

                
                List<MonitorRes> lista = ccapersonal.obtenerMonitorRes();
                lista = lista.stream().filter(i->i.getFechaEntrada().after(time)).collect(Collectors.toList());

                List<MonitorRes> finalLista = lista;
                Platform.runLater(() -> {
                    
                    TableViewConfigurator.init(tableView, List.of("id", "fechaEntrada", "fechaSalida", "id_Personal", "nombre", "usuarioSistema"), finalLista);
                });
            }
        };

        
        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }
}