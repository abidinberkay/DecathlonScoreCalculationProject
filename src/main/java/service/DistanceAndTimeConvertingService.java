package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DistanceAndTimeConvertingService {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MILISECONDS_IN_SECOND = 100;

    public static BigDecimal getMeters(String value) {
        return new BigDecimal(value);
    }

    public static BigDecimal getCentimeters(String value) {
        return new BigDecimal(value).multiply(new BigDecimal("100")).setScale(6, RoundingMode.DOWN);
    }

    public static BigDecimal getMinuteToSecond(String value) {

        BigDecimal result = null;

        DateFormat formatter = new SimpleDateFormat("mm.ss.SS");
        try {
            Date date = formatter.parse(value);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            result = getSeconds(calendar);
        } catch (ParseException e) {
            result = BigDecimal.ZERO;
        }
        return result;
    }

    public static BigDecimal getSecond(String value) {

        BigDecimal result = null;

        DateFormat formatter = new SimpleDateFormat("ss.SS");
        try {
            Date date = formatter.parse(value);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            result = getSeconds(calendar);
        } catch (ParseException e) {
            result = BigDecimal.ZERO;
        }
        return result;
    }

    public static BigDecimal getSeconds(Calendar cal) {
        return BigDecimal.valueOf(cal.get(Calendar.MINUTE) * SECONDS_IN_MINUTE + cal.get(Calendar.SECOND)
                + ((float) cal.get(Calendar.MILLISECOND)) / MILISECONDS_IN_SECOND);
    }
}
