package com.lcwd.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
            if(isWeekend(date)) {
                if (customerType.equals("rewarded")) {
                    totalRate += hotel.getRewardedWeekendRate(customerType);
                } else {
                    totalRate += hotel.getRegularWeekendRate(customerType);
                }
            }
            else {
                    if(customerType.equals("rewarded")){
                        totalRate += hotel.getRewardedWeekdayRate(customerType);
                    }
                    else {
                        totalRate += hotel.getRegularWeekdayRate(customerType);
                    }
                }

            date = date.plusDays(1);
        }

        return totalRate;
    }
    public String findCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        Optional<Hotel> cheapestBestRatedHotel = hotels.values().stream()
                .filter(hotel -> hotel.getRating() == hotels.values().stream()
                        .mapToInt(Hotel::getRating).max().orElse(0))
                .min(Comparator.comparingInt(hotel -> getTotalRateForDates(hotel, startDate, endDate, "regular")));

        return cheapestBestRatedHotel.map(hotel -> hotel.getName() + ", Rating: "+hotel.getRating()+ ", Total Rates: $" + getTotalRateForDates(hotel, startDate, endDate, "regular"))
                .orElse("No hotels available");
    }
    public String findCheapestBestRatedHotelForRewardedCustomer(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate) || startDate.isEqual(endDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }

        Optional<Hotel> cheapestBestRatedHotel = hotels.values().stream()
                .filter(hotel -> hotel.getRating() == hotels.values().stream()
                        .mapToInt(Hotel::getRating).max().orElse(0))
                .min(Comparator.comparingInt(hotel -> getTotalRateForDates(hotel, startDate, endDate, "rewarded")));

        return cheapestBestRatedHotel.map(hotel -> hotel.getName() + ", Rating: " + hotel.getRating() + ", Total Rates: $" + getTotalRateForDates(hotel, startDate, endDate, "rewarded"))
                .orElse("No hotels available");
    }
    public static void main(String[] args) {

    }
}
