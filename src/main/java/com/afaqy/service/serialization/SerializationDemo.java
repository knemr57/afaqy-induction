package com.afaqy.service.serialization;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {
        serialize();

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();

        deserialize();
    }

    private static void serialize() {
        Person person = new Person();
        person.setName("Omar");
        person.setAge(25);
        person.setHeight(170);
        person.setAddress(new Address("Street 1", 12345));

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {

            System.out.println("Serialized person: " + person);
            System.out.println("Country: " + Person.country);

            out.writeObject(person);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserialize() {
        Person person;

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {

            person = (Person) in.readObject();

            System.out.println("Deserialized person: " + person);
            System.out.println("Country: " + Person.country);

        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            System.out.println("Person class not found");
            e.printStackTrace();
        }
    }

}
