package ua.edu.ucu.apps.lab7.flowers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter @AllArgsConstructor @NoArgsConstructor
public class Flower {
    @Getter
    private FlowerType flowerType;
    private FlowerColor color;
    @Getter
    private double sepalLength;
    @Getter
    private double price;

    // copy constructor
    public Flower(Flower flower) {
        this.price = flower.price;
        this.color = flower.color;
        this.sepalLength = flower.sepalLength;
    }

    public String getColor() {
        return color.toString();
    }
}
