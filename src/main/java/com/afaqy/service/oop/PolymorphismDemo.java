package com.afaqy.service.oop;

class Parent {

    void show() {
        System.out.println("Parent's show()");
    }

}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child's show()");
    }

}

class Sum {

    public int sum(int x, int y) {
        return (x + y);
    }

    public int sum(int x, int y, int z) {
        return (x + y + z);
    }

    public double sum(double x, double y) {
        return (x + y);
    }

}

public class PolymorphismDemo {

    public static void main(String[] args) {
        // If a Parent type reference refers to a Parent object, then Parent's show is called
        Parent obj1 = new Parent();
        obj1.show();

        // If a Parent type reference refers to a Child object Child's show() is called.
        // This is called RUN TIME POLYMORPHISM.
        Parent obj2 = new Child();
        obj2.show();

        // ---------------------------------------------

        Sum sum = new Sum();
        System.out.println(sum.sum(10, 20));
        System.out.println(sum.sum(10, 20, 30));
        System.out.println(sum.sum(10.5, 20.5));
    }

}
