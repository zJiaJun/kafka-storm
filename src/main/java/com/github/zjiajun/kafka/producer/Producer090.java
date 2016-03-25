package com.github.zjiajun.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhujiajun
 * 16/3/25 22:04
 *
 * kafka 090 版本 生产demo
 */
public class Producer090 {

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<>(props);

        while (true) {
            ProducerRecord<String,String> record = new ProducerRecord<>("topictest","kafka090_key","kafka090_value");
            kafkaProducer.send(record);
            System.out.println("------------Producer data-------------");
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
