package com.infobrain.meroticket.Activities;

import android.app.Application;

/**
 * Created by bikas on 12/27/2017.
 */

public class Singleton extends Application {
    private String c_code;
    private String date;
    private String bus_id;
    private String route_id;
    private String seat_price;
    private String bus_layout;
    private String bus_name;
    private String boarding_point;
    private String selected_no;
    private String total_price;

    public String getSelected_no() {
        return selected_no;
    }

    public void setSelected_no(String selected_no) {
        this.selected_no = selected_no;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getBoarding_point() {
        return boarding_point;
    }

    public void setBoarding_point(String boarding_point) {
        this.boarding_point = boarding_point;
    }

    public String getBus_layout() {
        return bus_layout;
    }

    public void setBus_layout(String bus_layout) {
        this.bus_layout = bus_layout;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getSeat_price() {
        return seat_price;
    }

    public void setSeat_price(String seat_price) {
        this.seat_price = seat_price;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }
}
