package com.pcp.method.overload.vsoverride.vshiding;

class Vehicle {
    private String type;

    public Vehicle(String type) {
        this.type=type;
    }

    public void run() {
        System.out.println("Vehicle is running");
    }

}

class Car extends Vehicle {

    public Car() {
        super("Car");
    }

    @Override
    public void run() {
        System.out.println("Car is running");
    }
}


//parent class
class Demo {
    public static void method1() {
        System.out.println("Method-1 of the Demo class is executed.");
    }

    public void method2() {
        System.out.println("Method-2 of the Demo class is executed.");
    }

    public Vehicle getVehicle(String type) {
        System.out.println("getVehicle method!");
        return new Vehicle(type);
    }
}

//child class
public class Sample extends Demo {
    public static void method1() {
        System.out.println("Method-1 of the Sample class is executed.");
    }

    //This method overrides the method in the parent class
    //@Override is not mandatory
    public void method2() {
        System.out.println("Method-2 of the Sample class is executed.");
    }

    //This method overloads the method2 in the same class
    public int method2(String s) {
        System.out.println("Do Something! " + s);
        return 10;
    }

    //This method overrides the getVehicle in the parent class
    //even though the return type (Car) is a subclass of the return type (vehicle)
    //in the parent class method
    @Override
    public Car getVehicle(String type) {
        System.out.println("Overridden getVehicle method!");
        return new Car();
    }

    //This method will clash with parent method because the return type is different
//    public Integer getVehicle(String type) {
//        return 10;
//    }

    //This method will overload the method in the same class as parameter type is different
    //@Override will not be accepted here
    public Integer getVehicle(Integer value) {
        System.out.println("Overloaded getVehicle method!");
        return 10;
    }

    public static void main(String args[]) {
        Demo d1 = new Demo();
        //d2 is reference variable of class Demo that points to object of class Sample
        Demo d2 = new Sample();
        Sample s1 = new Sample();

        //method calling with reference (method hiding)
        d1.method1();
        d1.getVehicle("truck");
        d2.method1();
        s1.method2();
        s1.method2("Hello");
        //method calling with object (method overriding)
        d1.method2();
        d2.method2();
        d2.getVehicle("bus");
        s1.getVehicle(10);
    }
}

