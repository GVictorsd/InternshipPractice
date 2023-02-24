// Polymorphism Challenge:
// Create an interface called “Shape” with methods
// like “calculateArea” and “calculatePerimeter”. Implement the interface in
// classes like “Circle”, “Rectangle”, and “Triangle”. Create an array of “Shape”
// objects containing instances of each class and loop through the array, calling
// the “calculateArea” and “calculatePerimeter” methods for each shape.

package classChlngs;

public class Prob2 {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];

        shape[0] = new Circle(2);
        shape[1] = new Rectangle(5, 10);
        shape[2] = new Triangle(8, 9);

        for (Shape s: shape){
            System.out.println(s.calculateArea());
            System.out.println(s.calculatePerimeter());
        }
        
    }
}

interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

class Circle implements Shape{
    public int radius;
    public Circle(int radius){
        this.radius = radius;
    }

    public double calculateArea(){
        double res = 3.14*this.radius;
        return res;
    }
    public double calculatePerimeter(){
        double res = 2*3.14*this.radius;
        return res;
    }
}

class Rectangle implements Shape {
    public int length;
    public int width;
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    public double calculateArea(){
        double res = this.length*this.width;
        return res;
    }
    public double calculatePerimeter(){
        double res = 2*(this.length+this.width);
        return res;
    }
}

class Triangle implements Shape {
    public int base;
    public int height;
    public Triangle(int base, int height){
        this.base = base;
        this.height = height;
    }

    public double calculateArea(){
        double res = 0.5*this.base*this.height;
        return res;
    }
    public double calculatePerimeter(){
        double res = 3*this.base;
        return res;
    }
}