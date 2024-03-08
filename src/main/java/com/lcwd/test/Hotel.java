package com.lcwd.test;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    String name;
    Map<String, Integer> regularWeekdayRate;
    Map<String, Integer> regularWeekendRate;
    Map<String, Integer> rewardedWeekdayRate;
    Map<String, Integer> rewardedWeekendRate;

    private int rating;
    public Hotel (String hotel, int rating){
        this.name = hotel;
        this.rating = rating;
        this.regularWeekdayRate = new HashMap<>();
        this.regularWeekendRate = new HashMap<>();
        this.rewardedWeekdayRate = new HashMap<>();
        this.rewardedWeekendRate = new HashMap<>();
    }
    public void setRegularWeekdayRate(String customerType, int rate){
        regularWeekdayRate.put(customerType, rate);
    }
    public int getRegularWeekdayRate(String customerType){
        Integer rate = regularWeekdayRate.get(customerType);
        return rate != null ? rate :0;
    }
    public void setRegularWeekendRate(String customerType, int rate){
        rewardedWeekendRate.put(customerType, rate);
    }
    public int getRegularWeekendRate(String customerType){
        Integer rate = regularWeekendRate.get(customerType);
        return rate != null ? rate :0;
    }
    public void setRewardedWeekdayRate(String customerType, int rate){
        rewardedWeekdayRate.put(customerType, rate);
    }
    public int getRewardedWeekdayRate(String customerType){
        Integer rate = rewardedWeekdayRate.get(customerType);
        return rate != null ? rate : 0;
    }
    public void setRewardedWeekendRate(String customerType, int rate){
        rewardedWeekendRate.put(customerType,rate);
    }
    public int getRewardedWeekendRate(String customerType){
        Integer rate = rewardedWeekendRate.get(customerType);
        return rate != null ? rate : 0;
    }
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
}
