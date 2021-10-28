package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.annotations.Test;

import static ru.ssau.tk.ildar.Practice.transportation.SettlementType.*;

public class SettlementTest {

    @Test
    public static void testToString() {
        Settlement locationOne = new Settlement();
        locationOne.setSettlementType(VILLAGE);
        locationOne.setName("Samara");
        locationOne.setLatitude(53.12);
        locationOne.setLongitude(50.06);
        System.out.println(locationOne);
    }

}