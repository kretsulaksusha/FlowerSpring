package ua.edu.ucu.apps.lab7.flowers;

import java.util.LinkedList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.edu.ucu.apps.lab7.delivery.DeliveryStrategy;
import ua.edu.ucu.apps.lab7.payment.PaymentStrategy;

@NoArgsConstructor @Getter
public class Order {
    private LinkedList<Item> items = new LinkedList<>();
    @Setter
    private PaymentStrategy payment;
    @Setter
    private DeliveryStrategy delivery;

    public Order(PaymentStrategy payment, DeliveryStrategy delivery) {
        this.payment = payment;
        this.delivery = delivery;
    }

    public void add(Item item) {
        items.addLast(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public double getPrice() {
        double price = 0;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }

    public void processOrder() {
        delivery.deliver(this);
        System.out.println("Order was successfully processed!");
    }
}
