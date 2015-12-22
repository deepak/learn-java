import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("p1");
        System.out.println(p1);

        Person p2 = new Person("p1");

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
    }
}
