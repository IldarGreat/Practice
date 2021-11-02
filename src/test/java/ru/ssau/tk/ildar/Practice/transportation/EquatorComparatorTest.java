package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.annotations.Test;

import java.util.*;

public class EquatorComparatorTest {

    @Test
    public static void testComparator() {
        CompanyModelTest test = new CompanyModelTest();
        List<Location> list = new ArrayList<>();
        list.add(test.settlementNine);
        list.add(test.settlementTwo);
        list.add(test.settlementFour);
        list.add(test.settlementTen);
        list.add(test.settlementOne);
        list.add(test.settlementThree);
        list.add(test.settlementFive);
        list.add(test.settlementEight);
        list.add(test.settlementSix);
        list.add(test.settlementSeven);
        list.add(test.waypointFive);
        list.add(test.waypointNine);
        list.add(test.waypointEight);
        list.add(test.waypointSix);
        list.add(test.waypointOne);
        list.add(test.waypointFour);
        list.add(test.waypointTen);
        list.add(test.waypointTwo);
        list.add(test.waypointThree);
        list.add(test.waypointSeven);
        EquatorComparator comparator = new EquatorComparator();
        System.out.println("Max: " + Collections.max(list, comparator).getLatitude());
        System.out.println("Min: " + Collections.min(list, comparator).getLatitude());
        System.out.println();
        list.sort(comparator);
        for (Location location : list) {
            System.out.println(location.getLatitude());
        }
    }

}