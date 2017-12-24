package com.infobrain.meroticket.DataModels;

/**
 * Created by rp on 11/16/17.
 */

public class BusLayout_DataModel {
    String bus_name, bus_features, bus_time, bus_seat_no, bus_seat_price,bus_type;

    public BusLayout_DataModel(String bus_name, String bus_features, String bus_time, String bus_seat_no, String bus_seat_price,String bus_type) {
        this.bus_name = bus_name;
        this.bus_features = bus_features;
        this.bus_time = bus_time;
        this.bus_seat_no = bus_seat_no;
        this.bus_seat_price = bus_seat_price;
        this.bus_type=bus_type;
    }

    public String getBus_type() {
        return bus_type;
    }

    public String getBus_name() {
        return bus_name;
    }

    public String getBus_features() {
        return bus_features;
    }

    public String getBus_time() {
        return bus_time;
    }

    public String getBus_seat_no() {
        return bus_seat_no;
    }

    public String getBus_seat_price() {
        return bus_seat_price;
    }
}
