package com.afaqy.service.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:29092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        String topic = "quickstart-events";

        try {
            for(int i = 0; i < 100; i++) {

                String key = Integer.toString(i);
                String value = "test message - " + i;
                System.out.println("Producing record with key: " + key + ", and value: " + value);

                kafkaProducer.send(new ProducerRecord<>(topic, key, value));

            }
        } catch(Exception e) {
            System.err.println("Exception occurred while producing record");
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }
    }

}
