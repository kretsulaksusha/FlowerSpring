package ua.edu.ucu.apps.lab7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ua.edu.ucu.apps.lab7.delivery.DHLDeliveryStrategy;
import ua.edu.ucu.apps.lab7.delivery.PostDeliveryStrategy;
import ua.edu.ucu.apps.lab7.flowers.Order;
import ua.edu.ucu.apps.lab7.payment.CreditCard;
import ua.edu.ucu.apps.lab7.payment.CreditCardPaymentStrategy;
import ua.edu.ucu.apps.lab7.payment.PayPalPaymentStrategy;

@SpringBootTest
class Lab7ApplicationTests {

	@Test
	void testPayment() {
		CreditCard card = new CreditCard("1234123412341234", "12/29", "123", 30000);
        CreditCardPaymentStrategy creditCardPayment = new CreditCardPaymentStrategy(card);

        DHLDeliveryStrategy delivery = new DHLDeliveryStrategy();

        Order order = new Order(creditCardPayment, delivery);
		assertEquals(order.getPayment(), creditCardPayment);

		PayPalPaymentStrategy payPalPayment = new PayPalPaymentStrategy(
            "deadinside@gmail.com", "1000-7(-_-)");
		order.setPayment(payPalPayment);
		assertEquals(order.getPayment(), payPalPayment);
	}

	@Test
	void testDelivery() {
		CreditCard card = new CreditCard("1234123412341234", "12/29", "123", 30000);
        CreditCardPaymentStrategy creditCardPayment = new CreditCardPaymentStrategy(card);

        DHLDeliveryStrategy DHLDelivery = new DHLDeliveryStrategy();

        Order order = new Order(creditCardPayment, DHLDelivery);
		assertEquals(order.getDelivery(), DHLDelivery);

		PostDeliveryStrategy postDelivery = new PostDeliveryStrategy();
		order.setDelivery(postDelivery);
		assertEquals(order.getDelivery(), postDelivery);
	}

}
