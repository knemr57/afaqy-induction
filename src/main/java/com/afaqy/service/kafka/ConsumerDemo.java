package com.afaqy.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConsumerDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:29092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "test-group");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

        List<String> topics = new ArrayList<>();
        topics.add("quickstart-events");

        kafkaConsumer.subscribe(topics);

        try {
            while(true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(10));
                for(ConsumerRecord<String, String> record : records) {
                    System.out.println("Topic - " + record.topic() + ", Partition - " + record.partition() + ", Key - "
                            + record.key() + ", Value: " + record.value());
                }
            }
        } catch(Exception e) {
            System.err.println("Exception occurred while consuming records");
            e.printStackTrace();
        } finally {
            kafkaConsumer.close();
        }
    }

}
