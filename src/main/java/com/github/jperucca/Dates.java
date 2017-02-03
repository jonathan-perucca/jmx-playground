package com.github.jperucca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static java.time.ZoneOffset.UTC;

final class Dates {

    private static final String datePattern = "yyyy-MM-dd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);

    static Date parse(String dateAsString) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(dateAsString, formatter);
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Not a parsable date, use pattern " + datePattern);
        }

        return Date.from( localDate.atStartOfDay().toInstant(UTC) );
    }
}
