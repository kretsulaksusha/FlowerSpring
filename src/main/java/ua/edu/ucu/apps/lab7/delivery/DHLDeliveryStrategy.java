package ua.edu.ucu.apps.lab7.delivery;

import lombok.Getter;
import ua.edu.ucu.apps.lab7.flowers.Item;
import ua.edu.ucu.apps.lab7.flowers.Order;

@Getter
public class DHLDeliveryStrategy implements DeliveryStrategy {
    private String description = "DHL";

    @Override
    public String deliver(Order items) {
        for (Item item : items.getItems()) {
            items.remove(item);
        }
        return "Order was successfully delivered by DHL!";
    }

}
