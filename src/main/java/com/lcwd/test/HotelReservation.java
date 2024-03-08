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
            if (isWeekend(date)) {
                totalRate += hotel.getWeekendRate(customerType);
            } else {
                totalRate += hotel.getWeekdayRate(customerType);
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
//public String findBestRatedHotel(LocalDate startDate, LocalDate endDate, String customerType) {
//    Optional<Hotel> bestRatedHotel = hotels.values().stream()
//            .max(Comparator.comparingInt(hotel ->
//                    getTotalRateForDates(hotel, startDate, endDate, customerType)));
//
//    return bestRatedHotel.map(Hotel::getName).orElse("No hotels available");
//}
    public static void main(String[] args) {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel lakewood = new Hotel("Lakewood", 3);
        lakewood.setWeekdayRate("regular", 110);
        lakewood.setWeekendRate("regular", 90);
        hotelReservation.setHotels("Lakewood", lakewood);

        // Set up Ridgewood hotel
        Hotel ridgewood = new Hotel("Ridgewood", 5);
        ridgewood.setWeekdayRate("regular", 220);
        ridgewood.setWeekendRate("regular", 150);
        hotelReservation.setHotels("Ridgewood", ridgewood);

        // Set up Bridgewood hotel
        Hotel bridgewood = new Hotel("Bridgewood",4);
        bridgewood.setWeekdayRate("regular", 160);
        bridgewood.setWeekendRate("regular", 60);
        hotelReservation.setHotels("Bridgewood", bridgewood);


        // Define the date range and customer type
        LocalDate startDate = LocalDate.parse("2020-10-11");
        LocalDate endDate = LocalDate.parse("2020-10-12");
        String customerType = "regular";

        // Call the method to find the cheapest hotel
//        String cheapestHotel = hotelReservation.findCheapestBestRatedHotel(startDate, endDate);
//        System.out.println(cheapestHotel);
    }
}
