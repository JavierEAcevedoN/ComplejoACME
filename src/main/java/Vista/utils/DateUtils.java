package Vista.utils;

import javafx.scene.control.DatePicker;

import java.sql.Timestamp;
import java.time.LocalDate;

public class DateUtils {
    public static Timestamp convertDatePickerToTimestamp(DatePicker datePicker) {
        LocalDate localDate = datePicker.getValue();
        if (localDate != null) {
            return Timestamp.valueOf(localDate.atStartOfDay());
        }
        return null;
    }
}