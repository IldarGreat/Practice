package ru.ssau.tk.ildar.Practice.transportation;

public class Waypoint extends Location {
    private WaypointType type;
    private Settlement settlement;

    public Settlement getSettlement() {
        return settlement;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    public WaypointType getType() {
        return type;
    }

    public void setType(WaypointType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Its WAYPOINT[" + getName() + "]" + " Type:" + type.toString() + " Geography:" + getLatitude() + " " + getLongitude() + " IN SETTLEMENT:" + settlement;
    }
}
