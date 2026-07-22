package src.DesignPatterns.StructuralPattern;

public class ItalicDecorator implements TextFormatter{
    
    private TextFormatter formatter;

    public ItalicDecorator(TextFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String format() {
        return "_" + formatter.format() + "_";
    }
}
