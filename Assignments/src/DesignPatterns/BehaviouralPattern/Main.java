package src.DesignPatterns.BehaviouralPattern;

public class Main {
    public static void main(String[] args) {
                StockTicker ticker = new StockTicker();

        Observer observer1 = new PriceDisplay("Mobile App");

        Observer observer2 = new PriceDisplay("Web Dashboard");

        ticker.subscribe(observer1);
        ticker.subscribe(observer2);

        ticker.setPrice(105.5);
    }
}
