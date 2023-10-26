package ua.edu.ucu.apps.lab7.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Setter
    private CreditCard card;

    @Override
    public boolean pay(double price) {
        if (card.getBalance() >= price) {
            System.out.println("Paying " + price + " by credit card.");
            return true;
        }
        return false;
    }

}
