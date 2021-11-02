package ru.ssau.tk.ildar.Practice.transportation;

import java.util.Comparator;

public class EquatorComparator implements Comparator<Location> {

    @Override
    public int compare(Location objectOne, Location objectTwo) {
        return Double.compare(objectOne.getLatitude(), objectTwo.getLatitude());
    }
}
