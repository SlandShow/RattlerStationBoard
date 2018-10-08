package com.slandshow.models;

import java.io.Serializable;

public class Schedule implements Serializable {

    private Long id;

    private String dateDeparture;

    private String dateArrival;

    private String train;

    private String stationDeparture;

    private String stationArrival;

    private Integer price;

    /* Getters & setters */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDateDeparture() { return dateDeparture; }
    public void setDateDeparture(String dateDeparture) { this.dateDeparture = dateDeparture; }

    public String getDateArrival() { return dateArrival; }
    public void setDateArrival(String dateArrival) { this.dateArrival = dateArrival; }

    public String getTrain() { return train; }
    public void setTrain(String train) { this.train = train; }

    public String getStationDeparture() { return stationDeparture; }
    public void setStationDeparture(String stationDeparture) { this.stationDeparture = stationDeparture; }

    public String getStationArrival() { return stationArrival; }
    public void setStationArrival(String stationArrival) { this.stationArrival = stationArrival; }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
