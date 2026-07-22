package src.DesignPatterns.StrategyPattern;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying Using credit card:"+amount);
        //throw new UnsupportedOperationException("Unimplemented method 'pay'");
    }
    
    
}
