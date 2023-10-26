package ua.edu.ucu.apps.lab7.flowers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.ucu.apps.lab7.delivery.DHLDeliveryStrategy;
import ua.edu.ucu.apps.lab7.delivery.DeliveryStrategy;
import ua.edu.ucu.apps.lab7.payment.CreditCard;
import ua.edu.ucu.apps.lab7.payment.CreditCardPaymentStrategy;
import ua.edu.ucu.apps.lab7.payment.PayPalPaymentStrategy;
import ua.edu.ucu.apps.lab7.payment.PaymentStrategy;


@RestController
@RequestMapping("/flowers")
public class FlowerController {
    
    // @GetMapping("/flower")
    // public Flower hello() {
    //     return new Flower(5, FlowerColor.RED, 45);
    // }

    @GetMapping("/flower")
    public Flower hello() {
        return new Flower(FlowerType.CHAMOMILE, FlowerColor.WHITE, 0.5, 35);
    }

    @GetMapping("/order")
    public Order order() {
        FlowerPack flowerPack1 = new FlowerPack(
            new Flower(FlowerType.CHAMOMILE, FlowerColor.WHITE, 0.5, 35),
            15
        );
        FlowerPack flowerPack2 = new FlowerPack(
            new Flower(FlowerType.DAHLIA, FlowerColor.PINK, 0.6, 55),
            6
        );
        FlowerPack flowerPack3 = new FlowerPack(
            new Flower(FlowerType.LILAC, FlowerColor.PURPLE, 0.6, 55),
            7
        );

        FlowerBucket bucket1 = new FlowerBucket();
        bucket1.add(flowerPack1);
        bucket1.add(flowerPack2);

        FlowerBucket bucket2 = new FlowerBucket();
        bucket2.add(flowerPack3);

        PayPalPaymentStrategy payment = new PayPalPaymentStrategy(
            "deadinside@gmail.com", "1000-7(-_-)");

        DHLDeliveryStrategy delivery = new DHLDeliveryStrategy();

        Order order = new Order(payment, delivery);
        order.add(bucket1);
        order.add(bucket2);

        return order;
    }

    @GetMapping("order/payment")
    public PaymentStrategy payment() {
        CreditCard card = new CreditCard("1234123412341234", "12/29", "123", 30000);
        CreditCardPaymentStrategy payment = new CreditCardPaymentStrategy(card);

        DHLDeliveryStrategy delivery = new DHLDeliveryStrategy();

        Order order = new Order(payment, delivery);
        return order.getPayment();
    }

    @GetMapping("order/delivery")
    public DeliveryStrategy delivery() {
        CreditCard card = new CreditCard("1234123412341234", "12/29", "123", 30000);
        CreditCardPaymentStrategy payment = new CreditCardPaymentStrategy(card);

        DHLDeliveryStrategy delivery = new DHLDeliveryStrategy();

        Order order = new Order(payment, delivery);
        return order.getDelivery();
    }
}
