package com.lcwd.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelTest {
    @Test
    public void setAndGetRateTest(){
        Hotel hotel = new Hotel("Lakewood");
        String customerType = "regular";
        int rate = 110;
        hotel.setRates(customerType, rate);
        Assertions.assertEquals(rate, hotel.getRates(customerType));
    }

}
