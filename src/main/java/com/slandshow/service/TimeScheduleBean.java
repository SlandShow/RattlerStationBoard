package com.slandshow.service;

import com.slandshow.helpers.DataManager;
import com.slandshow.helpers.Listener;
import com.slandshow.helpers.Loader;
import com.slandshow.models.Station;
import com.slandshow.models.TimeSchedule;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Singleton
public class TimeScheduleBean {

    private static final Logger log = Logger.getLogger(TimeScheduleBean.class);

    private DataManager dataManager = DataManager.getInstance();
    private Listener listener = new Listener();
    private Loader loader = Loader.getInstance();

    private List<TimeSchedule> schedulesDeparture;

    private List<TimeSchedule> schedulesArrival;

    private List<Station> stations = loader.getStations();

    private String selectedItem = "Oselki";

    private String lastChangesInfo = "No changes ... ";

    public void update() {
        if (dataManager.getStatusChanges()) {
            lastChangesInfo = dataManager.getLastInfoChanges();
            log.info("update @schedule ... ");


            /*
            Update schedules for current station if it was updated in real time
             */

            if (dataManager.checkSelectedItem(selectedItem)) {
                updateSchedules(selectedItem);
            }

            dataManager.resetStatusChanges();
        }
    }

    @PostConstruct
    private void init() throws IOException, TimeoutException {
        listener.start();
        updateSchedules(selectedItem);
    }

    @PreDestroy
    private void destroy() throws IOException, TimeoutException {
        listener.stop();
    }

    private void updateSchedules(String selectedItem) {
        schedulesDeparture = dataManager.loadScheduleDeparture(selectedItem);
        schedulesArrival = dataManager.loadScheduleArrival(selectedItem);
    }

    // Getters & setters

    public List<String> getStations() {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < stations.size(); i++) {
            tokens.add(stations.get(i).getName());
        }
        return tokens;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public String getLastChangesInfo() {
        return lastChangesInfo;
    }

    public List<TimeSchedule> getSchedulesDeparture() {
        return schedulesDeparture;
    }

    public void setSchedulesDeparture(List<TimeSchedule> schedulesDeparture) {
        this.schedulesDeparture = schedulesDeparture;
    }

    public List<TimeSchedule> getSchedulesArrival() {
        return schedulesArrival;
    }

    public void setSchedulesArrival(List<TimeSchedule> schedulesArrival) {
        this.schedulesArrival = schedulesArrival;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;

        updateSchedules(selectedItem);
    }


}