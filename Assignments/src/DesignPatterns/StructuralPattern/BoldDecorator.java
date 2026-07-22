package src.DesignPatterns.StructuralPattern;

public class BoldDecorator implements TextFormatter {

    private TextFormatter formatter;

    public BoldDecorator(TextFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String format() {
        return "**" + formatter.format() + "**";
    }
    
}
