package com.slandshow.utils;

import com.slandshow.models.Schedule;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

    public static final String URL_SCHEDULES = "http://localhost:8080/api/board/schedule/today";
    public static final String URL_STATIONS = "http://localhost:8080/api/board/stations";
    public static final String URL_SCHEDULE_BY_ID = "http://localhost:8000/schedule/get/";

    private static final Logger log = Logger.getLogger(Utils.class);

    public static String parseToTime(String date) {
        Date dateToday = parseToDateTime(date);
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        return localDateFormat.format(dateToday);
    }

    public static Date getTodayDateTime() throws ParseException {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        return parseToDate(df.format(date));
    }

    public static Date parseToDateTime(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static Date parseToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(date);
    }

    public static boolean checkScheduleForToday(Schedule schedule) {
        try {
            log.info("schedule " + schedule.getStationDepartureName() + " - " + schedule.getStationArrivalName() + " " + schedule.getDateDeparture() + " " + schedule.getDateArrival());
            Date dateArrival = parseToDate(schedule.getDateArrival());
            Date dateToday = getTodayDateTime();
            log.info("arrival" + dateArrival + " today" + dateToday + " status " + dateArrival.equals(dateToday));
            return dateArrival.equals(dateToday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
