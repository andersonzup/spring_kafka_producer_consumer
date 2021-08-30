package br.com.zup.kafka.kafkaconsumer;

import br.com.zup.kafka.kafkaconsumer.dto.CarDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CarConsumer {

    private static final Logger LOGGER_CONSUMER = LoggerFactory.getLogger(CarConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "carKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, CarDTO> record){
        LOGGER_CONSUMER.info("Received message in partition " + record.partition());
        LOGGER_CONSUMER.info("Received message with value " + record.value());

    }

}
