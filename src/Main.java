import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("p1");
        System.out.println(p1);

        Person p2 = new Person("p2");

        // Object.equals will check for null
        System.out.println("person equal null: " + Objects.equals(p1, null));
        System.out.println("both person equal: " + Objects.equals(p1, p2));

        // this will error out. will have to compare will null as below
        // have mixed feelings about this.
        // if (null) System.out.println("null is true");
        // and neither does these
        // if (1) System.out.println("1 is true");
        // System.out.println("boolean value of 1: " + (!!1));

        // this works
        if (null == null) System.out.println("null is true");

        Person[] persons = new Person[2];
        persons[0] = p1;

        // persons[1] = new Integer(1); // type error
        // persons[1] = new Object(); // type error
        persons[1] = new Programmer("p1", 1234); // works with sub-class

        // compiler catches ArrayIndexOutOfBoundsException at compile-time
        // but Intellij does not
        // persons[2] = p2;

        System.out.println("persons: " + Arrays.toString(persons));
    }
}
