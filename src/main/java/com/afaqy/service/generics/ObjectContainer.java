package com.afaqy.service.generics;

public class ObjectContainer {

    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {

        ObjectContainer objectContainer = new ObjectContainer();

        // store a string
        objectContainer.setObj("Test");
        String stringObj = (String) objectContainer.getObj();
        System.out.println("Value of myObj:" + stringObj);

        // store an int (which is autoboxed to an Integer object)
        objectContainer.setObj(3);
        Integer intObj = (Integer) objectContainer.getObj();
        System.out.println("Value of myObj:" + intObj);

    }

}
