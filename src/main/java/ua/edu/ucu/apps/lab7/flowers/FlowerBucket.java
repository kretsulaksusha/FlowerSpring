package ua.edu.ucu.apps.lab7.flowers;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class FlowerBucket extends Item {
    private List<FlowerPack> flowerBucket = new ArrayList<>();


    public void add(FlowerPack flowerPack) {
        flowerBucket.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : flowerBucket) {
            price += flowerPack.getPrice();
        }
        return price;
    }
}
