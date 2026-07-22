package src.DesignPatterns.BehaviouralPattern;

public class PriceDisplay implements Observer {

    private String name;

    public PriceDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " received stock price: " + price);
    }
    
}
