package Vista.utils;

import javafx.scene.control.DatePicker;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtils {
    public static Timestamp convertDatePickerToTimestamp(DatePicker datePicker) {
        LocalDate localDate = datePicker.getValue();
        if (localDate != null) {
            return Timestamp.valueOf(localDate.atStartOfDay());
        }
        return null;
    }
}