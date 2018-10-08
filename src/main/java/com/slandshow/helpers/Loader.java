package com.slandshow.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slandshow.models.Schedule;
import com.slandshow.utils.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

public class Loader {

    private static final Logger log = Logger.getLogger(Loader.class);
    private static Loader loader;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Client client = new Client();

    public synchronized static Loader getInstance() {
        if (loader == null)
            loader = new Loader();
        return loader;
    }

    public List<Schedule> getSchedules() {
        String response = getResultResponse(Utils.URL_SCHEDULES);
        List<Schedule> schedules = null;
        try {
            schedules = objectMapper.readValue(response, new TypeReference<List<Schedule>>() {
            });
        } catch (IOException e) {
            log.error("ERROR, CAN'T LOAD SCHEDULES " + e.getMessage());
        }
        return schedules;
    }

    public Schedule getById(Long id) {
        String response = getResultResponse(Utils.URL_SCHEDULE_BY_ID + id);
        Schedule schedule = null;
        try {
            log.info(response);
            schedule = objectMapper.readValue(response, new TypeReference<Schedule>() {
            });
        } catch (IOException e) {
            log.error("ERROR, CAN'T LOAD SCHEDULE BY ID " + e.getMessage());
        }
        return schedule;
    }

    public List<String> getStations() {
        String response = getResultResponse(Utils.URL_STATIONS);
        List<String> stations = null;
        try {
            stations = objectMapper.readValue(response, new TypeReference<List<String>>() {
            });
        } catch (IOException e) {
            log.error("ERROR, CAN'T LOAD STATIONS " + e.getMessage());
        }
        return stations;
    }

    private String getResultResponse(String URL) {
        WebResource webResource = client.resource(URL);
        return webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class).getEntity(String.class);
    }
}
