package example;

public class Experiment_1 {

    public static void main(String [] args) {

	Integer a = 5;

	Inanimate_class c = new Inanimate_class();

	//  Despite being an Integer type, the original object passed in is not modified.

 	System.out.println(a);
 	System.out.println(test_pass_by_ref(a));
	System.out.println(a);

 	System.out.println(c.x);

	int i;

	int[] int_array = new int[100];
	String[] string_array = new String[100];

	for (i = 0; i < 100 ; i++) {

	    int_array[i] = i;

	    // System.out.println(int_array[i]);

	    string_array[i] = "Hello";

	    // System.out.println(string_array[i]);

	}

	//  The whole string is inside on element, unlike a char array.

	// System.out.println(string_array[50]);

    }

    public static Integer test_pass_by_ref(Integer a) {

	a -= 1;

	Integer b = a;

	return b - 1;

    }

}
