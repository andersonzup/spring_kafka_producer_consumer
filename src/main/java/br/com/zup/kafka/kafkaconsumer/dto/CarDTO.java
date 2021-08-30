package br.com.zup.kafka.kafkaconsumer.dto;

public class CarDTO {

    private  String id;
    private String model;
    private String color;

    public CarDTO() {
    }

    public CarDTO(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public CarDTO(String id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id='" + id + '\'' +
                "\n, model='" + model + '\'' +
                "\n, color='" + color + '\'' +
                '}';
    }
}
