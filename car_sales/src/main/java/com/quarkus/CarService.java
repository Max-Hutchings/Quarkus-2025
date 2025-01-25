package com.quarkus;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class CarService {


    public List<Car> getCars(){
        Car[] cars = {
                new Car("Volvo", "C70", LocalDate.of(2007, 2, 17)),
                new Car("Toyota", "Corolla", LocalDate.of(2015, 6, 10)),
                new Car("Honda", "Civic", LocalDate.of(2018, 3, 25)),
                new Car("Ford", "Mustang", LocalDate.of(2020, 7, 4)),
                new Car("Chevrolet", "Camaro", LocalDate.of(2019, 11, 9)),
                new Car("BMW", "M3", LocalDate.of(2017, 5, 14)),
                new Car("Audi", "A4", LocalDate.of(2021, 9, 30)),
                new Car("Mercedes-Benz", "C-Class", LocalDate.of(2016, 1, 20)),
                new Car("Nissan", "Altima", LocalDate.of(2014, 8, 13)),
                new Car("Hyundai", "Elantra", LocalDate.of(2022, 4, 7)),
                new Car("Kia", "Sorento", LocalDate.of(2013, 12, 18)),
                new Car("Mazda", "CX-5", LocalDate.of(2018, 10, 5)),
                new Car("Subaru", "Outback", LocalDate.of(2019, 2, 27)),
                new Car("Volkswagen", "Jetta", LocalDate.of(2015, 6, 3)),
                new Car("Tesla", "Model 3", LocalDate.of(2021, 7, 15)),
                new Car("Porsche", "911", LocalDate.of(2012, 5, 23)),
                new Car("Jaguar", "XE", LocalDate.of(2016, 9, 8)),
                new Car("Lexus", "RX", LocalDate.of(2017, 11, 1)),
                new Car("Ferrari", "488", LocalDate.of(2020, 3, 19)),
                new Car("Lamborghini", "Huracan", LocalDate.of(2021, 12, 5))
        };

        return List.of(cars);
    }
}
