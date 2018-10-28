package com.slandshow.models;

import java.io.Serializable;

public class Schedule implements Serializable {

    private Long id;

    private String dateDeparture;

    private String dateArrival;

    private String trainName;

    private String stationDepartureName;

    private String stationArrivalName;

    private Integer price;

    /* Getters & setters */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDateDeparture() { return dateDeparture; }
    public void setDateDeparture(String dateDeparture) { this.dateDeparture = dateDeparture; }

    public String getDateArrival() { return dateArrival; }
    public void setDateArrival(String dateArrival) { this.dateArrival = dateArrival; }

    public String getTrainName() { return trainName; }
    public void setTrainName(String train) { this.trainName = train; }

    public String getStationDepartureName() { return stationDepartureName; }
    public void setStationDepartureName(String stationDeparture) { this.stationDepartureName = stationDeparture; }

    public String getStationArrivalName() { return stationArrivalName; }
    public void setStationArrival(String stationArrival) { this.stationArrivalName = stationArrival; }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
