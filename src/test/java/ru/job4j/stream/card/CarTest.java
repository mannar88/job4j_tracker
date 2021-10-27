package ru.job4j.stream.card;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


public class CarTest {
@Test
    public  void  thenCar(){
    Car car = new Car.Builder()
            .buildModel("Lada")
            .buildcolor("white")
            .buildSpeed(160)
            .buildNumberOfSeats((byte) 5)
            .buildLeatherInterior(false)
            .buildEnginePower(150)
                    .build();
    assertThat(car.toString(), is ("Car{model='Lada', color='white', "
            + "speed=160, numberOfSeats=5, leatherInterior=false, enginePower=150}"));

}

}