package com.afaqy.service.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONSerializationDemo {

    private static final String FILE_NAME = "person.json";

    public static void main(String[] args) throws IOException {
        serialize();

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println();

        deserialize();
    }

    private static void serialize() throws IOException {
        Person person = new Person();
        person.setName("Omar");
        person.setAge(40);
        person.setHeight(175);
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("Street 1", 12345));
        addresses.add(new Address("Street 2", 54321));
        person.setAddresses(addresses);

        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize to the JSON String
        String personJson = objectMapper.writeValueAsString(person);
        System.out.println(personJson);

        // Serialize to the JSON File
        List<Person> personsList = new ArrayList<>();
        personsList.add(person);
        objectMapper.writeValue(new File(FILE_NAME), personsList);
        File file = new File(FILE_NAME);
        personJson = inputStreamToString(new FileInputStream(file));
        System.out.println(personJson);
    }

    private static void deserialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialize From the JSON String
        String personJson =
                "{\"age\":40,\"name\":\"Omar\",\"height\":175,\"addressesList\":[{\"street\":\"Street 1\",\"code\":12345},{\"street\":\"Street 2\",\"code\":54321}]}";
        Person person = objectMapper.readValue(personJson, Person.class);
        System.out.println(person);

        // Deserialize From the JSON File
        File file = new File(FILE_NAME);
        String fileContent = inputStreamToString(new FileInputStream(file));
        List<Person> personsList = objectMapper.readValue(fileContent, new TypeReference<List<Person>>() {

        });
        System.out.println(personsList);
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
