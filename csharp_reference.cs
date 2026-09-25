using System.Collections.Generic;

//  OK I'm somewhat of a C# convert. Very similar to Java but more simplified, modernised (e.g. more functional style). However still some legacy (both arrays and lists).
//  Presumably faster than Python, definitely stronger than Python standard library (balanced binary tree implementation, akin to Java).
//  Admittedly, it is lengthier to write than Python, but the Microsoft ownership has potentially gotten C# with Copilot very iterated - it was easy to build this basic reference.
//  Todo: compare to Rust sometime.

//  Function that returns multiple variables.
(int, string) MultipleValueReturn() {
    return (1, "Hello");
}

var (n, s) = MultipleValueReturn();
Console.WriteLine($"MultipleValueReturn: n = {n}, s = {s}");


//  Functional programming permitted.
// But this is an either-or thing, you can't call functions from a Main() within a class if you put functions at global scope.
void ListExample() {

    //  New list. Note there is no Integer type like Java.
    var l1 = new List<int>();
    //  Alternate instantiation.
    List<int> l2 = new();

    //  Append to list.
    l1.Add(10);
    l1.Add(30);
    l1.Add(20);

    l2.Add(10);

    //  Sort list.
    l1.Sort();

    //  Length of list.
    int l1_len = l1.Count;

    //  Select last element of list.
    var l1_last = l1.Last();

    //  Iterate over list; same for l2.
    foreach (int l_elem in l1) {
        Console.WriteLine(l_elem);
    }

    //  Equivalent to Python's a[0:3] slice.
    List<int> l3 = l1.GetRange(0, 3);  //  Get 3 elements starting from index 0.

    //  Equivalent to Python's enumerate.
    foreach (var (index, l_elem) in l3.Select((value, i) => (i, value))) {
        Console.WriteLine($"{index}: {l_elem}");
    }   

    //  List within list, of strings.
    List<List<string>> list_of_lists = new()
    {
        new List<string> { "One", "Two", "Three" },
        new List<string> { "Four", "Five", "Six" }
    };

    //  Iterate over list of lists.
    foreach (List<string> inner_list in list_of_lists) {
        foreach (string inner_elem in inner_list) {
            Console.WriteLine(inner_elem);
        }
    }

    //  Select element at specific position.
    int element_at_position = l1[0];

    //  Pre-sorted list, duplicates rejected.
    SortedList<string, int> l4 = new SortedList<string, int>();
    Dictionary<string, int> l4_counts = new Dictionary<string, int>();

    var l5 = new List<(string Name, int Age)>{("One", 1), ("Two", 2), ("Three", 3)};

    //  Append to list of tuples.
    l5.Add(("Four", 4));

    //  Remove from list of tuples.
    l5.Remove(("Two", 2));

    //  Remove at specific position.
    l5.RemoveAt(0);

    //  For loop over an explicit list.
    foreach (var (key, value) in l5) {
        try {
            l4.Add(key, value);
            l4_counts[key] = 1;
        } catch (ArgumentException e) {
            //  Equivalent functionality to Python's defaultdict(int).
            l4_counts[key] = l4_counts.GetValueOrDefault(key, 0) + 1;
        }
    }

    //  Output dictionary.
    foreach (var kvp in l4) {
        Console.WriteLine($"Key: {kvp.Key}, Value: {kvp.Value}");
    }

}

void ArrayExample() {

    //  1D matrix instantiation.
    int[] matrix1D = new int[3];

    //  Extract subset of array, equivalent to Python's example[0:2].
    int[] subset = matrix1D[0..2];

    Console.WriteLine("Subset of matrix1D: {0}", string.Join(", ", subset));

    //  2D matrix instantiation and iteration.
    int i, j;
    int rows = 2, cols = 3;
    int[,] matrix = new int[rows, cols];
    for (i = 0; i < rows; i++) {
        for (j = 0; j < cols; j++) {
            Console.WriteLine("Matrix[{0},{1}] = {2}", i, j, matrix[i, j]);
            matrix[i, j] = i * j;
        }
    }
    // Matrix[0,0] = 0
    // Matrix[0,1] = 0
    // Matrix[0,2] = 0
    // Matrix[1,0] = 0
    // Matrix[1,1] = 0
    // Matrix[1,2] = 0

}

void DictionaryExample() {

    //  C#'s balanced binary tree implementation; O(logn) lookups and insertions.
    SortedDictionary<int, string> balanced_binary_tree = new()
    {
        { 1, "One" },
        { 2, "Two" },
        { 3, "Three" }
    };

    //  Insert to SortedDictionary.
    balanced_binary_tree.Add(4, "Four");

    //  Output full SortedDictionary.
    foreach (KeyValuePair<int, string> kvp in balanced_binary_tree) {
        Console.WriteLine("Key = {0}, Value = {1}", kvp.Key, kvp.Value);
    }

    //  Key-value, of int to lists.
    Dictionary<int, List<string>> kv_store = new()
    {
        { 1, new List<string> { "One", "Uno" } },
        { 2, new List<string> { "Two", "Dos" } },
        { 3, new List<string> { "Three", "Tres" } }
    };

    //  Get value by key.
    List<string> value = kv_store[2];
    //  Set value by key.
    kv_store[2] = new List<string> { "Two", "Deux" };

    Console.WriteLine("Value for key 2: {0}", string.Join(", ", value));

    //  HashSet data structure, for O(1) lookups.
    HashSet<string> hs = new HashSet<string>();
    hs.Add("test");

}


void StringsExample(){

    var s1 = "Hello";
    var s2 = "World";

    //  Concatenate strings.
    var s3 = s1 + " " + s2;

    //  String interpolation.
    var s4 = $"{s1} {s2}";

    // Check if substring exists.
    bool containsHello = s3.Contains("Hello");

    // Check position of substring (first match)
    int helloPosition = s3.IndexOf("Hello");

    //  Remove substring (first match)
    var s5 = s3.Remove(helloPosition, "Hello".Length);

    //  Positions of all substrings (all matches).
    List<int> positions = new();
    int index = 0;
    int index_last_added = -1;
    var test_str = "Hello World Hello Universe Hello Multiverse";
    var target = "Hello";
    int i;
    for (i = 0; i < test_str.Length - target.Length + 1; i++) {
        index = test_str.IndexOf(target, i);
        Console.WriteLine("{0} '{1}'", i, test_str.Substring(i, target.Length));
        //  If index not equal to last_added, add to positions, update last_added.
        if (index != -1 && index != index_last_added) {
            positions.Add(index);
            index_last_added = index;
        }
    }

    //  Output full positions list.
    Console.WriteLine("Positions of 'Hello' in '{0}':", test_str);
    foreach (int pos in positions) {
        Console.WriteLine(pos);
    }

    //  Regex match all instances.
    var regex = new System.Text.RegularExpressions.Regex("[a-z] [A-Z]");
    var matches = regex.Matches(test_str);
    foreach (System.Text.RegularExpressions.Match match in matches) {
        Console.WriteLine("Found '{0}' at position {1}", match.Value, match.Index);
    }

    //  String to integer (failsafe).
    if (int.TryParse(numberString, out int result))
    {
        Console.WriteLine("Converted to: {result}.");
    }
    else
    {
        Console.WriteLine("Not a valid integer.");
    }

}   

void MathExample() {
    //  Sum list of numbers.
    List<int> numbers = new() { 1, 2, 3 };
    int sum = numbers.Sum();

    //  Absolute value.
    int difference = Math.Abs(-5);

    //  Product of numbers.
    int product = numbers.Aggregate(1, (acc, x) => acc * x);
    
}

void FunctionalProgrammingPattern() {

    List<int> numbers = new() { 1, 2, 3, 4, 5 };

    //  Filter.
    List<int> evenNumbers = [.. numbers.Where(x => x % 2 == 0)];
    
    //  Map.
    List<int> squaredNumbers = [.. numbers.Select(x => x * x)];

    // Reduce.
    int sum = numbers.Aggregate(0, (acc, x) => acc + x);
    
}


ListExample();
ArrayExample();
DictionaryExample();
StringsExample();
MathExample();
FunctionalProgrammingPattern();


ClassExample();


void ClassExample() {

    NumberExperiment abc = new();

    Console.WriteLine(abc.A);  //  Output: 2
    
}


//  Interface example - abstraction.
public interface NumberExperimentTemplate {
    int A { get; }
}
public interface NumberExperimentTemplate2 {
    int B { get; }
}

//  Class with getters and setters - encapsulation.
public class NumberExperiment : NumberExperimentTemplate, NumberExperimentTemplate2 {
    //  Property with a getter and a private setter.
    public int A { get; set; }
    public int B { get; set; }
    //  Constructor.
    public NumberExperiment() {
        this.A = 2;
    }

    //  Basic method.
    public int Add(int b) {
        return this.A + b;
    }
}

//  Subclass of NumberExperiment - inheritance.
public class SubNumberExperiment : NumberExperiment {
    //  Constructor.
    public SubNumberExperiment() {
        this.A = 2;
    }
}

//  Example of overriding NumberExperiment - runtime polymorphism.
//  Example of overloading method - static polymorphism.
public class OverridingNumberExperiment : NumberExperiment {
    //  Constructor.
    public OverridingNumberExperiment() {
        //  Can access A because it has a getter.
        Console.WriteLine(this.A);  //  Output: 2
    }
    // Override Add method.
    public new int Add(int b) {
        return this.A + b + 1;  //  Add 1 to the result.
    }

    // Overload Add method with different parameters.
    public int Add(int b, int c) {
        return this.A + b + c;
    }
}
