package com.afaqy.service.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLSerializationDemo {

    private static final String FILE_NAME = "person.xml";

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
        person.setAge(30);
        person.setHeight(180);
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("Street 1", 12345));
        addresses.add(new Address("Street 2", 54321));
        person.setAddresses(addresses);

        XmlMapper xmlMapper = new XmlMapper();

        // Serialize to the XML String
        String personXml = xmlMapper.writeValueAsString(person);
        System.out.println(personXml);

        // Serialize to the XML File
        List<Person> personsList = new ArrayList<>();
        personsList.add(person);
        xmlMapper.writeValue(new File(FILE_NAME), personsList);
        File file = new File(FILE_NAME);
        personXml = inputStreamToString(new FileInputStream(file));
        System.out.println(personXml);
    }

    private static void deserialize() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        // Deserialize From the XML String
        String personXml =
                "<Person><age>30</age><name>Omar</name><height>180</height><addressesList><street>Street 1</street><code>12345</code></addressesList><addressesList><street>Street 2</street><code>54321</code></addressesList></Person>";
        Person person = xmlMapper.readValue(personXml, Person.class);
        System.out.println(person);

        // Deserialize From the XML File
        File file = new File(FILE_NAME);
        List<Person> personsList = xmlMapper.readValue(inputStreamToString(new FileInputStream(file)),
                new TypeReference<List<Person>>() {

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
