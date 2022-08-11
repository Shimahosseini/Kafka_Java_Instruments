package com.devices;

import com.devices.objects.ContainerBuilder;
import com.devices.kafka.KafkaProperties;

import com.devices.objects.Instrument;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.List;

public class App {
    private static final String TOPIC = "Industry";
    private static final String KEY = "key";

    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("-p")) {
            produceMessage();
        } else if (args.length > 0 && args[0].equals("-c")) {
            receiveMessages();
        } else {
            System.out.println("\n*** Welcome to Kafka-project ***" +
                    "\nNo parameters: \n-p producer mode\n-c client mode");
        }
    }

    private static void receiveMessages() {
        try (Consumer<String, Instrument> consumer = new KafkaConsumer<>(KafkaProperties.get())) {
            consumer.subscribe(Arrays.asList("Industry"));
            final int giveUp = 100;
            int noRecordsCount = 0;

            while (true) {
                final ConsumerRecords<String, Instrument> consumerRecords =
                        consumer.poll(1000);

                if (consumerRecords.count() == 0) {
                    noRecordsCount++;
                    if (noRecordsCount > giveUp) break;
                    else continue;
                }
                consumerRecords.forEach(record -> {
                    System.out.printf("Consumer Record:(%s, %s, %s, %s, %d, %d)\n",
                            record.key(),
                            record.value().getName(),
                            record.value().getValue(),
                            record.value().getMachines().toString(),
                            record.partition(), record.offset());
                });
                consumer.commitAsync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void produceMessage() {
        try (Producer<String, Instrument> producer = new KafkaProducer<>(KafkaProperties.get())) {

            List<Instrument> instruments = new ContainerBuilder()
                    .build()
                    .getInstrumentList();

            int i = 0;
            for (Instrument instrument : instruments) {
                String key = KEY + i++;

                ProducerRecord<String, Instrument> record = new ProducerRecord<>(TOPIC, key, instruments);
                producer.send(record);
                System.out.println("record send: " + instruments.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

