package com.afaqy.service.generics;

public class GenericNumberContainer<T extends Number> {

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T t) {
        obj = t;
    }

    public static void main(String[] args) {

        GenericNumberContainer<Integer> gn = new GenericNumberContainer<>();
        gn.setObj(3);

        // Type argument String is not within the upper bounds of type-variable T
        // GenericNumberContainer<String> gn2 = new GenericNumberContainer<>();

    }

}
