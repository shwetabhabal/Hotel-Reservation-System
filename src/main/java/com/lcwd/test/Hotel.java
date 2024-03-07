package com.lcwd.test;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    String name;
    Map<String, Integer> rates;  //map to store rate for diff customer type
    public Hotel (String name){
        this.name = name;
        this.rates = new HashMap<>();
    }
    //set rate for specific customer type
    public void  setRates(String customerType, int rate ){
        rates.put(customerType, rate);
    }

    //get rate for specific customer type
    public int getRates(String customerType){
        Integer rate = rates.get(customerType);
        return rate != null ? rate : 0;
    }

    public String getName() {
        return name;
    }
}
