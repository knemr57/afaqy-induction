package com.afaqy.service.serialization;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private static final long serialVersionUID = -8678872604671361959L;

    private String street;
    private int code;

    public Address() {
    }

    public Address(String street, int code) {
        this.street = street;
        this.code = code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return code == address.code && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, code);
    }

    @Override
    public String toString() {
        return "Address{" + "street='" + street + '\'' + ", code=" + code + '}';
    }

}
