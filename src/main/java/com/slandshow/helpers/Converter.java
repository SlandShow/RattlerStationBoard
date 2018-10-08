package com.slandshow.helpers;

import com.slandshow.models.Schedule;
import com.slandshow.models.TimeSchedule;
import com.slandshow.utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    /**
     * @param stationMain
     * @param schedules
     * @return
     */
    public static List<TimeSchedule> conventDeparture(String stationMain, List<Schedule> schedules) {
        return schedules.stream()
                .filter(schedule -> schedule.getStationArrival().equals(stationMain) && Utils.checkScheduleForToday(schedule))
                .map(x -> {
                    TimeSchedule timeSchedule = new TimeSchedule();
                    timeSchedule.setStation(x.getStationDeparture());
                    timeSchedule.setTrain(x.getTrain());
                    timeSchedule.setTime(Utils.parseToTime(x.getDateDeparture()));
                    return timeSchedule;
                }).collect(Collectors.toList());
    }

    /**
     * @param stationMain
     * @param schedules
     * @return
     */
    public static List<TimeSchedule> convertArrival(String stationMain, List<Schedule> schedules) {
        return schedules.stream()
                .filter(schedule -> schedule.getStationDeparture().equals(stationMain))
                .map(x -> {
                    TimeSchedule timeSchedule = new TimeSchedule();
                    timeSchedule.setStation(x.getStationArrival());
                    timeSchedule.setTrain(x.getTrain());
                    timeSchedule.setTime(Utils.parseToTime(x.getDateArrival()));
                    return timeSchedule;
                }).collect(Collectors.toList());
    }
}
