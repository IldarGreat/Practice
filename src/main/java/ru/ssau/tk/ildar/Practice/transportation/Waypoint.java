package ru.ssau.tk.ildar.Practice.transportation;

public class Waypoint extends Location {
    private WaypointType type;
    private SettlementType settlement;

    public SettlementType getSettlement() {
        return settlement;
    }

    public void setSettlement(SettlementType settlement) {
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
        return settlement.toString() + " " + type.toString() + " " + getName() + " " + getLatitude() + " " + getLongitude();
    }
}
