package src.ModernJavaFeatures;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

    public static void reverseList(List<Integer> l) {
        
        List<Integer> reversed=IntStream.range(0, l.size()).mapToObj(i->l.get(l.size()-1-i)).toList();
        reversed.stream().forEach(System.out::println);

    }
    public static void secondHighestSalary(List<Integer> salary) {
        Optional<Integer> secondSalary=salary.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        secondSalary.ifPresent(System.out::println);
    }
    public static void removeDuplicates(List<Integer> duplicates) {
        List<Integer> noDuplicates=duplicates.stream().distinct().toList();
        System.out.println("no duplicates : "+noDuplicates);
    }
    public static void countFrequency(List<Integer> frequency) {

        Map<Integer, Long> frequency2 =frequency.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(frequency2);
    }
    public static void main(String[] args) {
        List<Integer> l= Arrays.asList(1,2,3,4,5);
        reverseList(l);
        List<Integer> salaryList =Arrays.asList(50,70,25,100,35);
        secondHighestSalary(salaryList);
        List<Integer> duplicates =Arrays.asList(50,70,25,100,35,100,35,35,0);
        removeDuplicates(duplicates);
        List<Integer> countFrequency =Arrays.asList(50,70,25,100,35,100,35,35,0);
        countFrequency(countFrequency);
    }

}
