package com.lcwd.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HotelReservationTest {
    @Test
    public void addHotelTest(){
        HotelReservation hotelReservation = new HotelReservation();
        String hotelName = "Lakewood";
        String customerType = "regular";
        int rate = 101;
        hotelReservation.setHotels(hotelName);

        Map<String, Integer> rates = new HashMap<>();
        rates.put(customerType, rate);
        hotelReservation.setRates(hotelName, rates);
//        Assertions.assertEquals(rate, hotelReservation.getTotalRateForDates(hotelName, customerType));
    }
    @Test
    public void findCheapestHotelTest(){
        HotelReservation hotelReservation = new HotelReservation();

        hotelReservation.setHotels("Lakewood");
        hotelReservation.setRates("Lakewood", Map.of("regular", 110));
        hotelReservation.setHotels("Bridgewood");
        hotelReservation.setRates("Bridgewood", Map.of("regular", 160));
        hotelReservation.setHotels("Ridgewood");
        hotelReservation.setRates("Ridgewood", Map.of("regular", 220));
        LocalDate startDate =LocalDate.parse("2020-09-10");
        LocalDate endDate = LocalDate.parse("2020-09-12");
        String customerType = "regular";
        String cheapestHotel = hotelReservation.findCheapestHotel(startDate,endDate, customerType);
        Assertions.assertEquals("Lakewood", cheapestHotel);
    }
}
