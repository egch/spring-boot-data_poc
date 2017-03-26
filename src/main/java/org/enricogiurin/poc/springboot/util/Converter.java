package org.enricogiurin.poc.springboot.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by enrico on 3/6/17.
 */
public class Converter {
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static LocalDate stringToLocalDate(String localDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return LocalDate.parse(localDate, dtf);
    }

    public static String localDateToString(LocalDate localDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return dtf.format(localDate);
    }
}
