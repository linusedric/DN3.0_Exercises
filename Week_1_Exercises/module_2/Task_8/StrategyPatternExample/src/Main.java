import java.util.*;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card. Card Number: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal. Email: " + email);
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("Payment strategy not set.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Payment Method: 1. Credit Card  2. PayPal  3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3) {
                break;
            }

            System.out.println("Enter amount to pay:");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Credit Card Number:");
                    String cardNumber = scanner.nextLine();
                    System.out.println("Enter Card Holder Name:");
                    String cardHolderName = scanner.nextLine();
                    context.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName));
                    break;

                case 2:
                    System.out.println("Enter PayPal Email:");
                    String email = scanner.nextLine();
                    context.setPaymentStrategy(new PayPalPayment(email));
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            context.executePayment(amount);
        }

        scanner.close();
    }
}

