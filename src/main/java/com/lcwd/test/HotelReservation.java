package com.lcwd.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
    private Map<String, Hotel> hotels;
    public HotelReservation(){
        this.hotels = new HashMap<>();
    }
    public  void setHotels(String name, Hotel hotel){
        hotels.put(name, hotel);
    }
    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
    public int getTotalRateForDates(Hotel hotel, LocalDate startDate, LocalDate endDate, String customerType){
        int totalRate = 0;

        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            if (isWeekend(date)) {
                totalRate += hotel.getWeekendRate(customerType);
            } else {
                totalRate += hotel.getWeekdayRate(customerType);
            }
            date = date.plusDays(1);
        }

        return totalRate;
    }
    public String findCheapestHotel(LocalDate startDate, LocalDate endDate, String customerType) {
        int minTotalRate = Integer.MAX_VALUE;
        Hotel cheapestHotel = null;

        for (Hotel hotel : hotels.values()) {
            int totalRate = getTotalRateForDates(hotel, startDate, endDate, customerType);
            if (totalRate < minTotalRate) {
                minTotalRate = totalRate;
                cheapestHotel = hotel;
            }
        }

        return cheapestHotel != null ? cheapestHotel.getName() + ", Total Rates: $" + minTotalRate : "No hotels available";
    }
    public static void main(String[] args) {
    }
}
