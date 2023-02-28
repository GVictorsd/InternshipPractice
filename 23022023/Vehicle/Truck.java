package truck;

import vehicle.*;

public class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String make, String model, int year, String color, double cargoCapacity){
        super(make, model, year, color);
        this.cargoCapacity = cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity){
        this.cargoCapacity = cargoCapacity;
    }
    public double getCargoCapacity(){
        return this.cargoCapacity;
    }
}