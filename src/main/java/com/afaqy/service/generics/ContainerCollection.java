package com.afaqy.service.generics;

import java.util.ArrayList;
import java.util.List;

public class ContainerCollection {

    public static void main(String[] args) {

        List myObjList = new ArrayList();

        for(int x = 0; x <= 10; x++) {
            ObjectContainer myObj = new ObjectContainer();
            myObj.setObj("Test" + x);
            myObjList.add(myObj);
        }
        // Get the objects, we need to cast
        for(int x = 0; x <= myObjList.size() - 1; x++) {
            ObjectContainer obj = (ObjectContainer) myObjList.get(x);
            String objString = (String) obj.getObj();
            System.out.println("Object Value: " + objString);
        }

        // -----------------------------------------------------------------

        List<GenericContainer<String>> genericList = new ArrayList<>();

        for(int x = 0; x <= 10; x++) {
            GenericContainer<String> myGeneric = new GenericContainer<>();
            myGeneric.setObj(" Generic Test" + x);
            genericList.add(myGeneric);
        }
        // Get the objects, no need to cast
        for(int x = 0; x <= genericList.size() - 1; x++) {
            GenericContainer<String> obj = genericList.get(x);
            String objectString = obj.getObj();
            // Do something with the string...here we will print it
            System.out.println(objectString);
        }

    }

}
