package com.afaqy.service.generics;

public class GenericContainer<T> {

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T t) {
        obj = t;
    }

    public static void main(String[] args) {

        GenericContainer<String> stringContainer = new GenericContainer<>();
        stringContainer.setObj("Test");
        //stringContainer.setObj(3); // will not compile...type error
        String stringObj = stringContainer.getObj();
        System.out.println("Value of stringContainer :" + stringObj);

        GenericContainer<Integer> intContainer = new GenericContainer<>();
        intContainer.setObj(3);
        intContainer.setObj(5);
        //intContainer.setObj("Int");  // will not compile
        Integer intObj = intContainer.getObj();
        System.out.println("Value of intContainer: " + intObj);

    }

}
