import java.util.*;

public class Collections_Assignment {

    // 1. Remove duplicates using HashSet
    static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (seen.add(num)) {
                result.add(num);
            }
        }

        return result;
    }

    // 2. Remove duplicates while preserving insertion order
    static List<Integer> removeDuplicatesKeepOrder(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (seen.add(num)) {
                result.add(num);
            }
        }

        return result;
    }

    // 3. Count frequency of each word using HashMap
    static Map<String, Integer> wordCount(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

    // 4. Sort employees by age using Comparator
    static void sortByAge(List<Employee> employees) {
        employees.sort(Comparator.comparingInt(Employee::getAge));
    }

    // 5. Remove even numbers using Iterator
    static void removeEvens(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

        // =====================================================
        // 1. Remove Duplicates
        // =====================================================
        System.out.println("========== removeDuplicates() ==========");

        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 4, 5, 1);

        System.out.println("Original List : " + numbers);

        List<Integer> unique = removeDuplicates(numbers);

        System.out.println("Result        : " + unique);


        // =====================================================
        // 2. Remove Duplicates While Preserving Order
        // =====================================================
        System.out.println("\n========== removeDuplicatesKeepOrder() ==========");

        List<Integer> input = List.of(3, 1, 2, 1, 3);

        System.out.println("Original List : " + input);

        List<Integer> orderedUnique = removeDuplicatesKeepOrder(input);

        System.out.println("Result        : " + orderedUnique);


        // =====================================================
        // 3. Word Count
        // =====================================================
        System.out.println("\n========== wordCount() ==========");

        String[] words = {"a", "b", "a", "c", "b", "a"};

        System.out.println("Input         : " + Arrays.toString(words));

        Map<String, Integer> wordCountMap = wordCount(words);

        System.out.println("Word Count    : " + wordCountMap);


        // =====================================================
        // 4. Sort Employees by Age
        // =====================================================
        System.out.println("\n========== sortByAge() ==========");

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Ann", 25),
                new Employee("Bob", 30),
                new Employee("Neha", 15)
        ));

        System.out.println("Before Sort   : " + employees);

        sortByAge(employees);

        System.out.println("After Sort    : " + employees);


        // =====================================================
        // 5. Remove Even Numbers Using Iterator
        // =====================================================
        System.out.println("\n========== removeEvens() ==========");

        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        System.out.println("Before Remove : " + nums);

        removeEvens(nums);

        System.out.println("After Remove  : " + nums);
    }
}