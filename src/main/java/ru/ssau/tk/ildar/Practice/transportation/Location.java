package ru.ssau.tk.ildar.Practice.transportation;

import java.util.Comparator;
import java.util.Objects;

import static ru.ssau.tk.ildar.Practice.transportation.SettlementType.*;
import static ru.ssau.tk.ildar.Practice.transportation.WaypointType.*;

public class Location {
    private int id;
    private String name;
    private double latitude;
    private double longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Comparator<Location> comparator = (objectOne, objectTwo) -> {
        if (objectOne instanceof Settlement && objectTwo instanceof Waypoint) {
            return -1;
        }
        if (objectOne instanceof Waypoint && objectTwo instanceof Settlement) {
            return 1;
        }
        if (objectOne instanceof Settlement && objectTwo instanceof Settlement) {
            if (((Settlement) objectOne).getSettlementType() == CITY && ((Settlement) objectTwo).getSettlementType() == VILLAGE) {
                return -1;
            } else if (((Settlement) objectOne).getSettlementType() == VILLAGE && ((Settlement) objectTwo).getSettlementType() == CITY) {
                return 1;
            } else if (((Settlement) objectOne).getSettlementType() == ((Settlement) objectTwo).getSettlementType()) {
                return objectOne.getName().compareTo(objectTwo.getName());
            }
            return 0;
        }
        if (objectOne instanceof Waypoint && objectTwo instanceof Waypoint) {
            if (((Waypoint) objectOne).getType() == DEPOT && ((Waypoint) objectTwo).getType() != DEPOT) {
                return -1;
            } else if (((Waypoint) objectOne).getType() == WAREHOUSE && ((Waypoint) objectTwo).getType() == EMPTY) {
                return -1;
            } else if (((Waypoint) objectOne).getType() == EMPTY && ((Waypoint) objectTwo).getType() != EMPTY) {
                return 1;
            } else if (((Waypoint) objectOne).getType() == ((Waypoint) objectTwo).getType()) {
                return objectOne.getName().compareTo(objectTwo.getName());
            }
            return 0;
        }
        throw new NullPointerException();
    };
}
