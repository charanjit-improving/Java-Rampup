import java.util.*;

public class Collections_Assignment {

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
    static List<Integer> removeDuplicatesKeepOrder(List<Integer> list)  {
        TreeSet<Integer> seen = new TreeSet<>();
        List<Integer> result = new ArrayList<>();

        for(Integer num : list) {
            if(seen.add(num)) {
                result.add(num);
            }
        }
        return result;
    }
    static Map<String, Integer> wordCount(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    static void sortByAge(List<Employee> employees) {
        employees.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println(employees);
    }
    static void removeEvens(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            if(iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 4, 5, 1);
        List<Integer> unique = removeDuplicates(numbers);
        System.out.println(unique); // [1, 2, 3, 4, 5]
        List<Integer> removeDuplicateKeepOrderList = removeDuplicatesKeepOrder(List.of(3, 1, 2, 1, 3));
        System.out.println(removeDuplicateKeepOrderList); // [3, 1, 2]
        Map<String,Integer> wordCountHashMap=wordCount(new String[]{"a", "b", "a", "c", "b", "a"});
        System.out.println(wordCountHashMap); // {a=3, b=2, c=1}
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Ann", 25),
                new Employee("Bob", 30),
                new Employee("Neha",15)
        ));
        sortByAge(employees);
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        removeEvens(nums);
    }

}
