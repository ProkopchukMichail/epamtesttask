package restservice.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static restservice.util.DateTimeUtil.parseLocalDate;
import static restservice.util.DateTimeUtil.parseLocalTime;


public class DateTimeFormatters {
    public static class LocalDateFormatter implements Formatter<LocalDate> {


        public LocalDate parse(String text, Locale locale) throws ParseException {
            return parseLocalDate(text);
        }


        public String print(LocalDate lt, Locale locale) {
            return lt.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

    public static class LocalTimeFormatter implements Formatter<LocalTime> {


        public LocalTime parse(String text, Locale locale) throws ParseException {
            return parseLocalTime(text);
        }


        public String print(LocalTime lt, Locale locale) {
            return lt.format(DateTimeFormatter.ISO_LOCAL_TIME);
        }
    }
}
