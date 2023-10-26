package ua.edu.ucu.apps.lab7.delivery;

import ua.edu.ucu.apps.lab7.flowers.Order;

public interface DeliveryStrategy {
    String deliver(Order items);
}
