package com.lcwd.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationTest {

    HotelReservation hotelReservation = new HotelReservation();
    // Set up hotels with their rates
    @Test
    public void findCheapestHotelTest() {
        Hotel lakewood = new Hotel("Lakewood", 3);
        lakewood.setWeekdayRate("regular", 110);
        lakewood.setWeekendRate("regular", 90);
        hotelReservation.setHotels("Lakewood", lakewood);

        // Set up Bridgewood hotel
        Hotel bridgewood = new Hotel("Bridgewood",4);
        bridgewood.setWeekdayRate("regular", 160);
        bridgewood.setWeekendRate("regular", 60);
        hotelReservation.setHotels("Bridgewood", bridgewood);

        // Set up Ridgewood hotel
        Hotel ridgewood = new Hotel("Ridgewood", 5);
        ridgewood.setWeekdayRate("regular", 220);
        ridgewood.setWeekendRate("regular", 150);
        hotelReservation.setHotels("Ridgewood", ridgewood);

        // Define the date range and customer type
        LocalDate startDate = LocalDate.parse("2020-09-11");
        LocalDate endDate = LocalDate.parse("2020-09-12");
        String customerType = "regular";

        // Call the method to find the cheapest hotel
        String cheapestHotel = hotelReservation.findCheapestBestRatedHotel(startDate, endDate);

        // Assert the result
        Assertions.assertEquals("Ridgewood, Total Rates: $370", cheapestHotel);
    }
}
