package src.ModernJavaFeatures;

import java.util.Optional;

public class ModernJavaFeatures {
      Optional<Integer> parseIntSafely(String input) { 
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    public static String describe(PaymentMethod m) {

        return switch (m) {

            case CreditCard card ->
                    "Paying with credit card ending in "
                            + card.number();

            case Cash cash ->
                    "Paying with cash";
        };
    }
    public static void main(String[] args) {
        ModernJavaFeatures features=new ModernJavaFeatures();
      features.parseIntSafely("42").ifPresent(System.out::println)   ;
        features.parseIntSafely("abc").ifPresent(System.out::println)  ;
         PaymentMethod payment1 =
                new CreditCard("1234567890123456");

        PaymentMethod payment2 =
                new Cash();

        System.out.println(describe(payment1));

        System.out.println(describe(payment2));
    }
}
