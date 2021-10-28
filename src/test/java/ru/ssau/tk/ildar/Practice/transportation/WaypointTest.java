package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.annotations.Test;

import static ru.ssau.tk.ildar.Practice.transportation.SettlementType.*;
import static ru.ssau.tk.ildar.Practice.transportation.WaypointType.*;

public class WaypointTest {

    @Test
    public static void testToString() {
        Waypoint locationOne = new Waypoint();
        locationOne.setSettlement(VILLAGE);
        locationOne.setType(DEPOT);
        locationOne.setName("Samara");
        locationOne.setLatitude(53.12);
        locationOne.setLongitude(50.06);
        System.out.println(locationOne);
    }
}