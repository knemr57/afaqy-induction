package com.afaqy.service.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {

    private static final long serialVersionUID = 99173822942857163L;

    private int age;
    private String name;
    private transient int height;
    private Address address; // must be serializable too
    static String country = "EGYPT";

    @JsonProperty("addressesList")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Address> addresses = new ArrayList<>();

    public Person() {
        System.out.println("Person constructor");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && height == person.height && Objects.equals(name, person.name) && Objects.equals(
                address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, height, address);
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + ", height=" + height + ", address=" + address
                + ", addresses=" + addresses + '}';
    }

}


