// Inheritance Challenge: 
// Create a base class called “Animal” with properties like “name”, “age”, “color” 
// and methods like “eat”, “sleep”. Create a derived class called “Dog” that inherits 
// from the “Animal” class and adds properties like “breed”, “isTrained” and methods 
// like “bark”, “fetch”. Create an instance of the “Dog” class and call its methods.


package classChlngs;
public class Prob1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Tommy";
        dog.age = 1;
        dog.color = "Brown";
        dog.breed = "German Shepherd";
        dog.isTrained = true;

        dog.eat();
        dog.sleep();
        dog.bark();
        dog.fetch();
    }
}

class Animal {
    public String name;
    public int age;
    public String color;

    public void eat(){
        System.out.println("Eat Method");
    }
    public void sleep(){
        System.out.println("Sleep Method");
    }
}

class Dog extends Animal {
    public String breed;
    public Boolean isTrained;

    public void bark(){
        System.out.println("Bark Method");
    }
    public void fetch(){
        System.out.println("Fetch Method");
    }
}