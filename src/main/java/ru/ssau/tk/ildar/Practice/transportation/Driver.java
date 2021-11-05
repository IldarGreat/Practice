package ru.ssau.tk.ildar.Practice.transportation;

import ru.ssau.tk.ildar.Practice.Gender;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public final class Driver {
    private int id;
    private String name;
    private Gender gender;
    private Date licenseExpirationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(Date licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Name:" + name + " Gender:" + gender.toString() + " License Expiration:" + licenseExpirationDate.toString();
    }

    public static Comparator<Driver> driverComparator = (objectOne, objectTwo) -> {
        if (objectOne.getGender() == objectTwo.getGender()) {
            return Double.compare(objectOne.getLicenseExpirationDate().getTime(), objectTwo.getLicenseExpirationDate().getTime());
        }
        if (objectOne.gender == Gender.MALE && objectTwo.gender == Gender.FEMALE) {
            return 1;
        }
        return -1;
    };
}
