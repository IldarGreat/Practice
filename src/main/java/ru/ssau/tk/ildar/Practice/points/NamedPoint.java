package ru.ssau.tk.ildar.Practice.points;
import ru.ssau.tk.ildar.Practice.functions.*;

public class NamedPoint extends Point implements Resettable {
    String name;

    public NamedPoint(double x, double y, double z) {
        super(x, y, z);
    }

    public NamedPoint(double x, double y, double z, String name) {
        super(x, y, z);
        this.name = name;
    }

    public NamedPoint() {
        super(0, 0, 0);
        this.name = "Origin";
    }

    @Override
    public void reset() {
        this.name = "Absent";
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return super.getX();
    }

    public double getY() {
        return super.getY();
    }

    public double getZ() {
        return super.getZ();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        if(name==null){
           return super.toString();
        }
        return name + ":" + super.toString();
    }

}
