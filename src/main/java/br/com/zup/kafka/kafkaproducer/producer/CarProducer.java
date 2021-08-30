package br.com.zup.kafka.kafkaproducer.producer;


import br.com.zup.kafka.kafkaproducer.controller.CarDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarProducer {

    private static final Logger LOGGER_PRODUCER = LoggerFactory.getLogger(CarProducer.class);

    private final String topico;

    private final KafkaTemplate<String, CarDTO> kafkaTemplate;

    public CarProducer(@Value("${topic.name}") String topico, KafkaTemplate<String, CarDTO> kafkaTemplate) {
        this.topico = topico;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(CarDTO carDTO){
        kafkaTemplate.send(topico, carDTO).addCallback(success -> LOGGER_PRODUCER.info("Message send "+success.getProducerRecord().value())
                , failure -> LOGGER_PRODUCER.info("Message failure "+failure.getMessage()));
    }

}
