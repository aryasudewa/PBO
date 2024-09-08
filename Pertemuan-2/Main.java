// Class Vehicle dengan Abstraction
abstract class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Abstraction (method drive() akan di-override oleh subclass)
    public abstract void drive();

    // Encapsulation (menggunakan method getter untuk mengakses variabel private)
    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    // Polymorphism (method description() akan di-override oleh subclass)
    public void description() {
        System.out.println("This is a vehicle of brand " + brand + " with speed " + speed + " km/h.");
    }
}

// Class Car dengan Inheritance (Car adalah subclass dari Vehicle)
class Car extends Vehicle {
    public Car(String brand, int speed) {
        super(brand, speed);
    }

    // Abstraction (method drive() di-override dari superclass)
    @Override
    public void drive() {
        System.out.println("The car is driving at " + getSpeed() + " km/h.");
    }

    // Polymorphism (method description() di-override dari superclass)
    @Override
    public void description() {
        System.out.println("This is a car of brand " + getBrand() + " with speed " + getSpeed() + " km/h.");
    }
}

// Class Bike dengan Inheritance (Bike adalah subclass dari Vehicle)
class Bike extends Vehicle {
    public Bike(String brand, int speed) {
        super(brand, speed);
    }

    // Abstraction (method drive() di-override dari superclass)
    @Override
    public void drive() {
        System.out.println("The bike is being ridden at " + getSpeed() + " km/h.");
    }

    // Polymorphism (method description() di-override dari superclass)
    @Override
    public void description() {
        System.out.println("This is a bike of brand " + getBrand() + " with speed " + getSpeed() + " km/h.");
    }
}

// Class Calculator
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    // Method overloading (method add() dengan parameter double)
    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat object dari Car dan Bike
        Vehicle car = new Car("Toyota", 120);
        Vehicle bike = new Bike("Yamaha", 80);

        car.drive();  // Output: The car is driving at 120 km/h.
        car.description();  // Output: This is a car of brand Toyota with speed 120 km/h.
        
        bike.drive();  // Output: The bike is being ridden at 80 km/h.
        bike.description();  // Output: This is a bike of brand Yamaha with speed 80 km/h.

        // Membuat object dari Calculator
        Calculator calc = new Calculator();
        System.out.println("Sum of integers: " + calc.add(2, 3));  // Output: 5
        System.out.println("Sum of doubles: " + calc.add(2.5, 3.5));  // Output: 6.0
    }
}
