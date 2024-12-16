package Vista.utils;

import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class DatePickerObserver {

    public static void init(DatePicker startDatePicker, DatePicker endDatePicker) {

        startDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                endDatePicker.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(newValue));
                    }
                });
            }
        });

        endDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                startDatePicker.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isAfter(newValue));
                    }
                });
            }
        });
    }

    public static void init(DatePicker startDatePicker, DatePicker endDatePicker, Runnable action) {
        startDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                endDatePicker.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isBefore(newValue));
                    }
                });
                checkAndRun(startDatePicker, endDatePicker, action);
            }
        });

        endDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                startDatePicker.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
                    @Override
                    public void updateItem(LocalDate date, boolean empty) {
                        super.updateItem(date, empty);
                        setDisable(empty || date.isAfter(newValue));
                    }
                });
                checkAndRun(startDatePicker, endDatePicker, action);
            }
        });
    }

    private static void checkAndRun(DatePicker startDatePicker, DatePicker endDatePicker, Runnable action) {
        if (startDatePicker.getValue() != null && endDatePicker.getValue() != null) {
            action.run();
        }
    }
}