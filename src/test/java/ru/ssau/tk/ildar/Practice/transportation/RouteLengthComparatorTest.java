package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.annotations.Test;

import java.util.*;

public class RouteLengthComparatorTest {

    @Test
    public static void testComparator() {
        CompanyModelTest model = new CompanyModelTest();
        RouteLengthComparator comparator = new RouteLengthComparator();
        List<Route> list = new ArrayList<>();
        list.add(model.routeThree);
        list.add(model.routeTwo);
        list.add(model.routeOne);
        list.add(model.routeFour);
        list.add(model.routeFive);
        System.out.println(list.stream().max(comparator));
        list.sort(comparator);
        for (Route route : list) {
            System.out.println(route.length());
        }
    }
}
