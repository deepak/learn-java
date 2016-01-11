package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("hop");
        System.out.println("stringBox: " + stringBox);
        // stringBox.set(10); // is a type-error

        Box rawBox = new Box<String>();
        rawBox.set("rat");
        System.out.println("rawBox: " + rawBox);

        // not a type-error even though variable is initialized as `Box<String>()`
        // this is because we are using a raw type
        rawBox.set(10);
        System.out.println("rawBox: " + rawBox);

        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        // boolean same = Util.<Integer, String>compare(p1, p2);
        boolean same = Util.compare(p1, p2);
        System.out.println("pairs are the same" + same);

        Person person1 = new Person("foo");
        Person person2 = new Person("bar");
        System.out.println("person same: " + Util.compare(person1, person2));

        Box<String> box1 = new Box<>();
        box1.set("foo");
        Box<String> box2 = new Box<>();
        box2.set("bar");
        System.out.println("boxes the same: " + Util.compare(box1, box2));

        Box<Integer> box3 = new Box<>();
        box3.set(1);
        Box<Integer> box4 = new Box<>();
        box4.set(10);
        System.out.println("boxes the same: " + Util.compare(box3, box4));
        // System.out.println("boxes the same: " + Util.compare(box1, box4)); // type-error

        // is the magic of raw types ? no type error
        // TODO: is which case is this a bad idea ? make it crash
        Box rawBox1 = new Box<>();
        rawBox1.set(1);
        Box rawBox2 = new Box<>();
        rawBox2.set("10");
        System.out.println("raw boxes the same: " + Util.compare(rawBox1, rawBox2));

        PersonBox rawPersonBox = new PersonBox();
        rawPersonBox.set(person1);
        System.out.println("rawPersonBox: " + rawPersonBox);

        // rawPersonBox.set("foo"); // is a type-error. why now ?

        Integer[] ints = new Integer[] { 1, 2, 3, 4, 5};
        System.out.println("greater than 3: " + countGreaterThan(ints, 3));

        Person[] persons = new Person[] { person1, person2 };
        System.out.println(Arrays.toString(persons));
        // type-error. should implement Comparable<Person>
        System.out.println("persons >: " + countGreaterThan(persons, person1));
        // works after implementing it

        NumberList<Number> numberList = new NumberList<>();
        // NumberList<String> numberList2 = new NumberList<>(); // type-error
        numberList.add(10);
        numberList.add(10.10);
        System.out.println("number list: " + numberList);
        // numberList.add("foo"); // type-error

        NumberList rawNumberList = new NumberList<>();
        rawNumberList.add(15);
        rawNumberList.add(15.10);
        System.out.println("number list: " + rawNumberList);
        rawNumberList.add("foo"); // not a type-error. how to get a runtime error
        System.out.println("number list: " + rawNumberList);
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T x) {
        int count = 0;

        for (T elem : anArray) {
            if (x.compareTo(elem) > 0) {
                ++count;
            }
        }

        return count;
    }

    static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static <T> void swapItems(int i, int j, T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swapObjects(int i, int j, Object[] arr) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
