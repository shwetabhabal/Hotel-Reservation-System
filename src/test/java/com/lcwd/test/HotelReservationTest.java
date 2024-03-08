package com.lcwd.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationTest {

    @Test
    public void findCheapestBestRatedHotelForRewardedCustomerTest() {
        HotelReservation hotelReservation = new HotelReservation();

        // Set up hotels and rates
        Hotel lakewood = new Hotel("Lakewood", 3);
        lakewood.setRewardedWeekdayRate("rewarded", 80);
        lakewood.setRewardedWeekendRate("rewarded", 80);
        hotelReservation.setHotels("Lakewood", lakewood);

        Hotel bridgewood = new Hotel("Bridgewood", 4);
        bridgewood.setRewardedWeekdayRate("rewarded", 110);
        bridgewood.setRewardedWeekendRate("rewarded", 50);
        hotelReservation.setHotels("Bridgewood", bridgewood);

        Hotel ridgewood = new Hotel("Ridgewood", 5);
        ridgewood.setRewardedWeekdayRate("rewarded", 100);
        ridgewood.setRewardedWeekendRate("rewarded", 40);
        hotelReservation.setHotels("Ridgewood", ridgewood);

        // Define the date range
        LocalDate startDate = LocalDate.of(2020, 9, 11);
        LocalDate endDate = LocalDate.of(2020, 9, 12);

        // Call the method to find the cheapest best-rated hotel for rewarded customers
        String result = hotelReservation.findCheapestBestRatedHotelForRewardedCustomer(startDate, endDate);

        // Assert the result
        Assertions.assertEquals("Ridgewood, Rating: 5, Total Rates: $140", result);
    }
}