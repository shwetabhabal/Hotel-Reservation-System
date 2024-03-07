package com.lcwd.test;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
    private Map<String, Hotel> hotels;
    public HotelReservation(){
        this.hotels = new HashMap<>();
    }
    public  void setHotels(String name){
        hotels.put(name, new Hotel(name));
    }
    public void setRates(String hotelName, Map<String, Integer> rates){
        Hotel hotel = hotels.get(hotelName);
        if(hotel != null){
            for(String customerType : rates.keySet()){
                hotel.setRates(customerType, rates.get(customerType));
            }
        }
    }
    public int getRates(String hotelName, String customerType){
        Hotel hotel = hotels.get(hotelName);
        if(hotel != null){
            return hotel.getRates(customerType);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
    }
}
