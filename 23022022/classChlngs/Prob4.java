// Abstraction Challenge: 
// Create an abstract class called “Vehicle” with properties like “make”, 
// “model”, “year” and an abstract method called “start”. Implement the 
// “Vehicle” class in derived classes like “Car”, “Truck”, and “Motorcycle”
//  by providing their own “start” method. Create an array of “Vehicle” objects 
// containing instances of each class and loop through the array, calling the 
// “start” method for each vehicle.

package classChlngs;

public class Prob4 {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Truck();
        vehicles[2] = new Motorcycle();

        for (Vehicle v: vehicles){
            v.start();
        }
        
    }
}

abstract class Vehicle {
    String make;
    String model;
    int year;

    abstract void start();
}

class Car extends Vehicle {
    public void start(){
        System.out.println("Car is started");
    }
}

class Truck extends Vehicle {
    public void start(){
        System.out.println("Truck is started");
    }
}

class Motorcycle extends Vehicle {
    public void start(){
        System.out.println("Motorcycle is started");
    }
}
