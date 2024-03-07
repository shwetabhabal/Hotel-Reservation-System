package com.lcwd.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(rate, hotelReservation.getRates(hotelName, customerType));
    }
}
