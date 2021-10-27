package ru.job4j.stream.card;

public class Car {

    private String model;
    private String color;
    private int speed;
    private byte numberOfSeats;
    private boolean leatherInterior;
    private int enginePower;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                ", numberOfSeats=" + numberOfSeats +
                ", leatherInterior=" + leatherInterior +
                ", enginePower=" + enginePower +
                '}';
    }

    static class Builder {
        private String model;
        private String color;
        private int speed;
        private byte numberOfSeats;
        private boolean leatherInterior;
        private int enginePower;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildcolor(String color) {
            this.color = color;
            return this;
        }

        Builder buildSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        Builder buildNumberOfSeats(byte numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }

        Builder buildLeatherInterior(boolean leatherInterior) {
            this.leatherInterior = leatherInterior;
            return this;
        }

        Builder buildEnginePower(int enginePower) {
            this.enginePower = enginePower;
            return this;
        }
Car build () {
Car car = new Car();
car.model = model;
car.color = color;
car.speed = speed;
car.numberOfSeats = numberOfSeats;
    car.leatherInterior = leatherInterior;
    car.enginePower = enginePower;
return car;
        }
    }
}
