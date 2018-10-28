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
        List<TimeSchedule> tmp= schedules.stream()
                .filter(schedule -> schedule.getStationArrivalName().equals(stationMain) && Utils.checkScheduleForToday(schedule))
                .map(x -> {
                    TimeSchedule timeSchedule = new TimeSchedule();
                    timeSchedule.setStation(x.getStationDepartureName());
                    timeSchedule.setTrain(x.getTrainName());
                    timeSchedule.setTime(Utils.parseToTime(x.getDateDeparture()));
                    return timeSchedule;
                }).collect(Collectors.toList());

         for (int i = 0; i < schedules.size(); i++) {
            System.out.println(schedules.get(i).getTrainName() + " " + schedules.get(i).getDateDeparture());
        }

        return tmp;
    }

    /**
     * @param stationMain
     * @param schedules
     * @return
     */
    public static List<TimeSchedule> convertArrival(String stationMain, List<Schedule> schedules) { System.out.println("HERE --> ");
        List<TimeSchedule> tmp = schedules.stream()
                .filter(schedule -> schedule.getStationDepartureName().equals(stationMain))
                .map(x -> {
                    TimeSchedule timeSchedule = new TimeSchedule();
                    timeSchedule.setStation(x.getStationArrivalName());
                    timeSchedule.setTrain(x.getTrainName());
                    timeSchedule.setTime(Utils.parseToTime(x.getDateArrival()));
                    return timeSchedule;
                }).collect(Collectors.toList());


        for (int i = 0; i < tmp.size(); i++) {
            System.out.println(schedules.get(i).getTrainName());
        }

        return tmp;
    }
}
