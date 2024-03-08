package com.lcwd.test;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    String name;
    Map<String, Integer> weekdayRate;
    Map<String, Integer> weekendRate;
    private int rating;
    public Hotel (String hotel, int rating){
        this.name = hotel;
        this.rating = rating;
        this.weekdayRate = new HashMap<>();
        this.weekendRate = new HashMap<>();
    }
    public void setWeekdayRate(String customerType, int rate ){
        weekdayRate.put(customerType, rate);
    }
    public int getWeekdayRate(String customerType){
        Integer rate = weekdayRate.get(customerType);
        return rate != null ? rate :0;
    }
    public void setWeekendRate(String customerType, int rate){
        weekendRate.put(customerType, rate);
    }
    public int getWeekendRate(String customerType){
        Integer rate = weekendRate.get(customerType);
        return rate != null ? rate :0;
    }
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
}
