package com.lcwd.test;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    String name;
    Map<String, Integer> weekdayRate;
    Map<String, Integer> weekendRate;
    public Hotel (String name){
        this.name = name;
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
    //set rate for specific customer type
    public void  setRates(String customerType, int rate ){
        rates.put(customerType, rate);
    }
    public String getName() {
        return name;
    }
}
