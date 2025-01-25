package com.quarkus;

import java.time.LocalDate;

public class Car {

    private String brand;
    private String name;
    private LocalDate releaseData;


    public Car(String brand, String name, LocalDate releaseData) {
        this.brand = brand;
        this.name = name;
        this.releaseData = releaseData;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(LocalDate releaseData) {
        this.releaseData = releaseData;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", releaseData=").append(releaseData);
        sb.append('}');
        return sb.toString();
    }
}
