package ru.ssau.tk.ildar.Practice.transportation;

public class Settlement extends Location {
    private int settlement;
    private SettlementType settlementType;

    public int getSettlement() {
        return settlement;
    }

    public void setSettlement(int settlement) {
        this.settlement = settlement;
    }

    public SettlementType getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(SettlementType settlementType) {
        this.settlementType = settlementType;
    }

    @Override
    public String toString() {
        return "Its SETTLEMENT[" + getName() + "]" + " Type:" + settlementType.toString() + " Geography:" + getLatitude() + " " + getLongitude();
    }

}
