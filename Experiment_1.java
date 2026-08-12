package example;

public class Experiment_1 {

    public static void main(String [] args) {

	Integer a = 5;

	Inanimate_class c = new Inanimate_class();

 	System.out.println(a);
 	System.out.println(test_pass_by_ref(a));

 	System.out.println(c.x);

    }

    public static Integer test_pass_by_ref(Integer a) {

	Integer b = a;

	return b - 1;

    }

}
