package car;


import vehicle.*;

public class Car extends Vehicle {
    protected int numDoors;

    public Car(String make, String model, int year, String color, int numDoors){
        super(make, model, year, color);
        this.numDoors = numDoors;
    }

    public void setNumDoors(int numDoors){
        this.numDoors = numDoors;
    }
    public int getNumDoors(){
        return this.numDoors;
    }
}