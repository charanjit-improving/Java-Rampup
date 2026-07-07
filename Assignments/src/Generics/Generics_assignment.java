import java.util.*;

public class Generics_Assignment {

    // 1. Check if list is sorted
    static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    // 2. Sum of numbers
    static double sumOfList(List<? extends Number> list) {
        double sum = 0;

        for (Number n : list) {
            sum += n.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {

        // ============================================
        // 1. isSorted()
        // ============================================

        System.out.println("===== isSorted() =====");

        System.out.println(isSorted(List.of(1, 2, 3)));
        System.out.println(isSorted(List.of(3, 1, 2)));

        // ============================================
        // 2. sumOfList()
        // ============================================

        System.out.println("\n===== sumOfList() =====");

        System.out.println(sumOfList(List.of(1, 2, 3)));
        System.out.println(sumOfList(List.of(1.5, 2.5)));

        // ============================================
        // 3. Pair
        // ============================================

        System.out.println("\n===== Pair =====");

        Pair<String, Integer> pair = new Pair<>("x", 1);

        System.out.println(pair);
        System.out.println(pair.swap());
    }
}