
class experiment_1 {

    public static void main(String [] args) {

	Integer a = 5;

	inanimate_class c = new inanimate_class();

 	System.out.println(test_pass_by_ref(a));
 	System.out.println(a);
 	System.out.println(c.x);

    }

    public static Integer test_pass_by_ref(Integer a) {

	Integer b = a;

	return b - 1;

    }

}


class inanimate_class {

    public Integer x;

    public void inanimate_class() {

	this.x = 2;

    }

}
