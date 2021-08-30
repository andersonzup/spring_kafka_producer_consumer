package br.com.zup.kafka.kafkaproducer.controller;

import br.com.zup.kafka.kafkaproducer.producer.CarProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private CarProducer carProducer;

    public CarController(CarProducer carProducer) {
        this.carProducer = carProducer;
    }

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO){
        CarDTO car = new CarDTO(UUID.randomUUID().toString(), carDTO.getModel(), carDTO.getColor());
        carProducer.send(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }
}



