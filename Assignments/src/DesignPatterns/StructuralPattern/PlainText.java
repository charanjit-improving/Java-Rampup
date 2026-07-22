package src.DesignPatterns.StructuralPattern;

public class PlainText implements TextFormatter {

    private String text;

    public PlainText(String text) {
        this.text=text;
    }

    @Override
    public String format() {
        return text;
        //throw new UnsupportedOperationException("Unimplemented method 'format'");
    }
    
    
}
