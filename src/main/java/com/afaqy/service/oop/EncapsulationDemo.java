package com.afaqy.service.oop;

class Person {

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

}

public class EncapsulationDemo {

    public static void main(String[] args) {
        Person person = new Person();

        person.setName("Ahmed");
        person.setAge(25);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Direct access of name is not possible
        // System.out.println("Name: " + person.name);
    }

}
