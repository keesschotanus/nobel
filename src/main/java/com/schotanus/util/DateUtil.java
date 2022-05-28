package com.schotanus.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    /**
     * Prevent instantiation.
     */
    private DateUtil() {

    }

    /**
     * Converts a {@link Date} to a {@link LocalDateTime}.
     * @param date The date to convert.
     * @return The converted date or null when the supplied date is null.
     */
    public static LocalDateTime dateToLocalDateTime(final Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Converts a {@link LocalDateTime} to a String.
     * @param date The date to convert.
     * @return A ISO Date/Time string or null when the supplied date is null.
     */
    public static String dateToIsoDateTime(final Date date) {
        return date == null ? "null" : DateTimeFormatter.ISO_DATE_TIME.format(DateUtil.dateToLocalDateTime(date));
    }
}
