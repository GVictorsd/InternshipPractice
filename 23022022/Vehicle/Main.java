import vehicle.*;
import car.*;
import truck.*;

public class Main {
    public static void main(String... args){

        Car c = new Car("Ford", "Camry", 2012, "white", 4);
        print("Car c color: " , c.getColor());
        print("Car c numDoors" , c.getNumDoors());

        Truck t = new Truck("Ford", "Camry", 2011, "Black", 1000);
        print("Truck t year: ", t.getYear());
        print("Truck t cargoCapacity", t.getCargoCapacity());
    }

    public static void print(Object... obj){
        System.out.println();
        for(Object i: obj){
            System.out.print(i + " ");
        }
    }

}
