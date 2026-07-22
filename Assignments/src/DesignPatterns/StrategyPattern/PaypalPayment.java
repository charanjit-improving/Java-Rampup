package src.DesignPatterns.StrategyPattern;

public class PaypalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying Using paypal:"+amount);

        //throw new UnsupportedOperationException("Unimplemented method 'pay'");
    }
    
    
}
