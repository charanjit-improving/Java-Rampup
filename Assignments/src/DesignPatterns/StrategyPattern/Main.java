package src.DesignPatterns.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor=new PaymentProcessor(new CreditCardPayment());
        processor.processPayment(150);
    }
    
}
