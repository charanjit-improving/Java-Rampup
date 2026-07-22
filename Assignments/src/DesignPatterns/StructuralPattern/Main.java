package src.DesignPatterns.StructuralPattern;

public class Main {
    public static void main(String[] args) {
                    TextFormatter formatter =
                new BoldDecorator(
                        new ItalicDecorator(
                                new PlainText("hi")));

        System.out.println(formatter.format());
    }

}
