package org.enricogiurin.poc.springboot.util;

import static org.junit.Assert.*;
import org.junit.*;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by enrico on 3/6/17.
 */
public class ConverterTest {
    @Test
    public void stringToLocalDate() throws Exception {
        LocalDate localDate = Converter.stringToLocalDate("2017-01-01");
        assertEquals(Month.JANUARY, localDate.getMonth());

    }

}