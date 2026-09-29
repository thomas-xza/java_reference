//  This is an automatic port of the C# reference, via Gemini.

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Main {

    // Helper tuple class to simulate C# tuples
    static record Tuple<A, B>(A item1, B item2) {}

    // Function that returns multiple variables.
    // (int, string) MultipleValueReturn() {
    //     return (1, "Hello");
    // }
    static Tuple<Integer, String> multipleValueReturn() {
        return new Tuple<>(1, "Hello");
    }

    public static void main(String[] args) {

        // var (n, s) = MultipleValueReturn();
        // Console.WriteLine($"MultipleValueReturn: n = {n}, s = {s}");
        Tuple<Integer, String> resultTuple = multipleValueReturn();
        int n = resultTuple.item1();
        String s = resultTuple.item2();
        System.out.println("MultipleValueReturn: n = " + n + ", s = " + s);

        listExample();
        arrayExample();
        dictionaryExample();
        stringsExample();
        mathExample();
        functionalProgrammingPattern();

        classExample();
    }

    static void listExample() {

        // New list.
        var l1 = new ArrayList<Integer>();
        // Alternate instantiation.
        List<Integer> l2 = new ArrayList<>();

        // Append to list.
        l1.add(10);
        l1.add(30);
        l1.add(20);

        l2.add(10);

        // Sort list.
        Collections.sort(l1);

        // Length of list.
        int l1_len = l1.size();

        // Select last element of list.
        var l1_last = l1.get(l1.size() - 1);

        // Iterate over list; same for l2.
        for (int l_elem : l1) {
            System.out.println(l_elem);
        }

        // Equivalent to Python's a[0:3] slice.
        List<Integer> l3 = new ArrayList<>(l1.subList(0, 3)); // Get 3 elements starting from index 0.

        // Equivalent to Python's enumerate.
        for (int i = 0; i < l3.size(); i++) {
            System.out.println(i + ": " + l3.get(i));
        }

        // List within list, of strings.
        List<List<String>> list_of_lists = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("One", "Two", "Three")),
            new ArrayList<>(Arrays.asList("Four", "Five", "Six"))
        ));

        // Iterate over list of lists.
        for (List<String> inner_list : list_of_lists) {
            for (String inner_elem : inner_list) {
                System.out.println(inner_elem);
            }
        }

        // Select element at specific position.
        int element_at_position = l1.get(0);

        // Pre-sorted list, duplicates rejected.
        // SortedList<string, int> l4 = new SortedList<string, int>();
        TreeMap<String, Integer> l4 = new TreeMap<>();
        Map<String, Integer> l4_counts = new HashMap<>();

        var l5 = new ArrayList<Tuple<String, Integer>>(Arrays.asList(
            new Tuple<>("One", 1), 
            new Tuple<>("Two", 2), 
            new Tuple<>("Three", 3)
        ));

        // Append to list of tuples.
        l5.add(new Tuple<>("Four", 4));

        // Remove from list of tuples.
        l5.remove(new Tuple<>("Two", 2));

        // Remove at specific position.
        l5.remove(0);

        // For loop over an explicit list.
        for (var tuple : l5) {
            String key = tuple.item1();
            int value = tuple.item2();
            try {
                if (l4.containsKey(key)) {
                    throw new IllegalArgumentException("Key already exists");
                }
                l4.put(key, value);
                l4_counts.put(key, 1);
            } catch (IllegalArgumentException e) {
                // Equivalent functionality to Python's defaultdict(int).
                l4_counts.put(key, l4_counts.getOrDefault(key, 0) + 1);
            }
        }

        // Output dictionary.
        for (Map.Entry<String, Integer> kvp : l4.entrySet()) {
            System.out.println("Key: " + kvp.getKey() + ", Value: " + kvp.getValue());
        }

    }

    static void arrayExample() {

        // 1D matrix instantiation.
        int[] matrix1D = new int[3];

        // Extract subset of array, equivalent to Python's example[0:2].
        // int[] subset = matrix1D[0..2];
        int[] subset = Arrays.copyOfRange(matrix1D, 0, 2);

        System.out.printf("Subset of matrix1D: %s%n", Arrays.toString(subset).replaceAll("[\\[\\]]", ""));

        // 2D matrix instantiation and iteration.
        int i, j;
        int rows = 2, cols = 3;
        // int[,] matrix = new int[rows, cols];
        int[][] matrix = new int[rows][cols];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                System.out.printf("Matrix[%d,%d] = %d%n", i, j, matrix[i][j]);
                matrix[i][j] = i * j;
            }
        }
        // Matrix[0,0] = 0
        // Matrix[0,1] = 0
        // Matrix[0,2] = 0
        // Matrix[1,0] = 0
        // Matrix[1,1] = 0
        // Matrix[1,2] = 0

    }

    static void dictionaryExample() {

        // Balanced binary tree implementation; O(logn) lookups and insertions.
        TreeMap<Integer, String> balanced_binary_tree = new TreeMap<>() {{
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
        }};

        // Insert to SortedDictionary.
        balanced_binary_tree.put(4, "Four");

        // Output full SortedDictionary.
        for (Map.Entry<Integer, String> kvp : balanced_binary_tree.entrySet()) {
            System.out.printf("Key = %d, Value = %s%n", kvp.getKey(), kvp.getValue());
        }

        // Key-value, of int to lists.
        Map<Integer, List<String>> kv_store = new HashMap<>() {{
            put(1, new ArrayList<>(Arrays.asList("One", "Uno")));
            put(2, new ArrayList<>(Arrays.asList("Two", "Dos")));
            put(3, new ArrayList<>(Arrays.asList("Three", "Tres")));
        }};

        // Get value by key.
        List<String> value = kv_store.get(2);
        // Set value by key.
        kv_store.put(2, new ArrayList<>(Arrays.asList("Two", "Deux")));

        System.out.printf("Value for key 2: %s%n", String.join(", ", value));

        // HashSet data structure, for O(1) lookups (key-value store without the values).
        Set<String> hs = new HashSet<String>();
        hs.add("test");

    }

    static void stringsExample(){

        var s1 = "Hello";
        var s2 = "World";

        // Concatenate strings.
        var s3 = s1 + " " + s2;

        // String interpolation.
        // var s4 = $"{s1} {s2}";
        var s4 = String.format("%s %s", s1, s2);

        // Check if substring exists.
        boolean containsHello = s3.contains("Hello");

        // Check position of substring (first match)
        int helloPosition = s3.indexOf("Hello");

        // Remove substring (first match)
        // var s5 = s3.Remove(helloPosition, "Hello".Length);
        var s5 = s3.substring(0, helloPosition) + s3.substring(helloPosition + "Hello".length());

        // Positions of all substrings (all matches).
        List<Integer> positions = new ArrayList<>();
        int index = 0;
        int index_last_added = -1;
        var test_str = "Hello World Hello Universe Hello Multiverse";
        var target = "Hello";
        int i;
        for (i = 0; i < test_str.length() - target.length() + 1; i++) {
            index = test_str.indexOf(target, i);
            System.out.printf("%d '%s'%n", i, test_str.substring(i, i + target.length()));
            // If index not equal to last_added, add to positions, update last_added.
            if (index != -1 && index != index_last_added) {
                positions.add(index);
                index_last_added = index;
            }
        }

        // Output full positions list.
        System.out.printf("Positions of 'Hello' in '%s':%n", test_str);
        for (int pos : positions) {
            System.out.println(pos);
        }

        // Regex match all instances.
        Pattern regex = Pattern.compile("[a-z] [A-Z]");
        Matcher matches = regex.matcher(test_str);
        while (matches.find()) {
            System.out.printf("Found '%s' at position %d%n", matches.group(), matches.start());
        }

        // String to integer (failsafe).
        // if (int.TryParse(numberString, out int result))
        // {
        //     Console.WriteLine("Converted to: {result}.");
        // }
        // else
        // {
        //     Console.WriteLine("Not a valid integer.");
        // }
        String numberString = "123";
        try {
            int result = Integer.parseInt(numberString);
            System.out.println("Converted to: " + result + ".");
        } catch (NumberFormatException e) {
            System.out.println("Not a valid integer.");
        }

    }   

    static void mathExample() {
        // Sum list of numbers.
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        // Absolute value.
        int difference = Math.abs(-5);

        // Product of numbers.
        int product = numbers.stream().reduce(1, (acc, x) -> acc * x);
        
    }

    static void functionalProgrammingPattern() {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Filter.
        // List<int> evenNumbers = [.. numbers.Where(x => x % 2 == 0)];
        List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        
        // Map.
        // List<int> squaredNumbers = [.. numbers.Select(x => x * x)];
        List<Integer> squaredNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());

        // Reduce.
        int sum = numbers.stream().reduce(0, (acc, x) -> acc + x);
        
    }

    static void classExample() {

        NumberExperiment abc = new NumberExperiment();

        System.out.println(abc.getA()); // Output: 2
        
    }

    // Interface example - abstraction.
    public interface NumberExperimentTemplate {
        int getA();
    }
    public interface NumberExperimentTemplate2 {
        int getB();
    }

    // Class with getters and setters - encapsulation.
    public static class NumberExperiment implements NumberExperimentTemplate, NumberExperimentTemplate2 {
        // Property with a getter and a private setter.
        private int a;
        private int b;

        public int getA() { return a; }
        public void setA(int a) { this.a = a; }
        
        public int getB() { return b; }
        public void setB(int b) { this.b = b; }

        // Constructor.
        public NumberExperiment() {
            this.a = 2;
        }

        // Basic method.
        public int add(int b) {
            return this.a + b;
        }
    }

    // Subclass of NumberExperiment - inheritance.
    public static class SubNumberExperiment extends NumberExperiment {
        // Constructor.
        public SubNumberExperiment() {
            this.setA(2);
        }
    }

    // Example of overriding NumberExperiment - runtime polymorphism.
    // Example of overloading method - static polymorphism.
    public static class OverridingNumberExperiment extends NumberExperiment {
        // Constructor.
        public OverridingNumberExperiment() {
            // Can access A because it has a getter.
            System.out.println(this.getA()); // Output: 2
        }
        // Override Add method.
        // public new int Add(int b) {
        @Override
        public int add(int b) {
            return this.getA() + b + 1; // Add 1 to the result.
        }

        // Overload Add method with different parameters.
        public int add(int b, int c) {
            return this.getA() + b + c;
        }
    }
}
