package src.StreamsAndFunctionalInterface;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class StreamsAndFI {

    // 1. Return top N longest unique words
    public static List<String> topNLongest(List<String> words, int n) {
        return words.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    // 2. Count even and odd numbers
    public static Map<Boolean, Long> countByEvenOdd(List<Integer> nums) {
        return nums.stream()
                .collect(Collectors.partitioningBy(
                        num -> num % 2 == 0,
                        Collectors.counting()
                ));
    }

    // 3. Return an IntBinaryOperator that finds the maximum
    public static IntBinaryOperator maxCalculator() {
        return (a, b) -> a > b ? a : b;
    }

    // Testing
    public static void main(String[] args) {

        List<String> words = List.of(
                "cat",
                "elephant",
                "dog",
                "elephant",
                "fox"
        );

        System.out.println("Top 2 longest words:");
        System.out.println(topNLongest(words, 2));

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        System.out.println("\nEven/Odd Count:");
        System.out.println(countByEvenOdd(nums));

        IntBinaryOperator maxOp = maxCalculator();

        System.out.println("\nMaximum:");
        System.out.println(maxOp.applyAsInt(3, 9));
        System.out.println(maxOp.applyAsInt(15, 7));
    }
}