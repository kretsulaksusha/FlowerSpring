package ua.edu.ucu.apps.lab7.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter
public class PayPalPaymentStrategy implements PaymentStrategy {
    @Setter
    private String email;
    @Setter
    private String password;
    private boolean signedIn = false;

    public PayPalPaymentStrategy(String email, String password) {
        this.email = email;
        this.password = password;
        this.signedIn = true;
    }

    @Override
    public boolean pay(double price) {
        if (signedIn) {
            System.out.println("Paying " + price + " by PayPal.");
            return true;
        }
        return false;
    }
    
}
