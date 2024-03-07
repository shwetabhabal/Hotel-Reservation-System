package com.lcwd.test;

import java.time.LocalDate;
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
    public int getTotalRateForDates(String hotelName, LocalDate startDate, LocalDate endDate, String customerType){
        Hotel hotel = hotels.get(hotelName);
        if (hotel != null) {
            int totalRate = 0;
            LocalDate date = startDate;
            while (!date.isAfter(endDate)) {
                totalRate += hotel.getRates(customerType);
                date = date.plusDays(1);
            }
            return totalRate;
        }
        return 0;
    }
    public String findCheapestHotel(LocalDate startDate, LocalDate endDate, String customerType) {
        int minTotalRate = Integer.MAX_VALUE;
        String cheapestHotel = null;

        for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            int totalRate = getTotalRateForDates(entry.getKey(), startDate, endDate, customerType);
            if (totalRate < minTotalRate) {
                minTotalRate = totalRate;
                cheapestHotel = entry.getKey();
            } else if (totalRate == minTotalRate && entry.getKey().compareTo(cheapestHotel) < 0) {
                // If rates are the same, select the hotel with the lexicographically smaller name
                cheapestHotel = entry.getKey();
            }
        }

        return cheapestHotel;
    }
//    public static void main(String[] args) {
//        HotelReservation hotelReservation = new HotelReservation();
//        hotelReservation.setHotels("Lakewood");
//        hotelReservation.setRates("Lakewood", Map.of("regular", 110));
//        hotelReservation.setHotels("Bridgewood");
//        hotelReservation.setRates("Bridgewood", Map.of("regular", 160));
//        hotelReservation.setHotels("Ridgewood");
//        hotelReservation.setRates("Ridgewood", Map.of("regular", 220));
//        LocalDate startDate = LocalDate.parse("2020-09-10");
//        LocalDate endDate = LocalDate.parse("2020-09-12");
//        String customerType = "regular";
//        String cheapHotel = hotelReservation.findCheapestHotel(startDate,endDate, customerType);
//        int totalRate = hotelReservation.getTotalRateForDates(cheapHotel, startDate, endDate, customerType);
//        System.out.println("Cheapest Hotel: "+cheapHotel+" Total Rates: "+totalRate);
//    }
}
