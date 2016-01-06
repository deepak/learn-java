package main;

import org.jetbrains.annotations.Contract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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

        Programmer programmer1 = new Programmer("p1", 1234);

        // runs without any runtime errors
        Person p3  = programmer1;
        System.out.println("programmer to person: " + p3);

        // irritating that on navigating code which uses Polymorphism,
        // Intellij took me to Person.toString() not Programmer.toString
        // even when at runtime, that is called
        Person p4 = new Programmer("p4", 1);
        System.out.println("new person: " + p4.toString());

        // downcast fails at runtime with ClassCastException. but Intellij did not show any warning
        // http://stackoverflow.com/questions/4862960/explicit-casting-from-super-class-to-subclass
        // Programmer programmer2 = (Programmer) p1;
        // System.out.println("person to programmer: " + programmer2);

        // works. but implicit downcast above fails
        Programmer programmer3 = new Programmer(p1);
        System.out.println("explicit person to programmer: " + programmer3);

        System.out.println("programmer is hipster: " + (programmer1 instanceof Hipster));
        System.out.println("programmer is a programmer: " + (programmer1 instanceof Programmer));

        Person[] persons = new Person[2];
        persons[0] = p1;

        // persons[1] = new Integer(1); // type error
        // persons[1] = new Object(); // type error
        persons[1] = programmer1; // works with sub-class

        // compiler catches ArrayIndexOutOfBoundsException at compile-time
        // but Intellij does not
        // persons[2] = p2;

        System.out.println("persons: " + Arrays.toString(persons));

        List<Person> personList = new ArrayList<Person>(1);
        personList.add(p1);
        personList.add(programmer1); // works with sub-class
        personList.add(p2); // ArrayList will resize

        System.out.println("persons: " + personList);

        // does not work
        // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
        // A switch works with the byte, short, char, and int primitive data types.
        // It also works with enumerated types (discussed in Enum Types), the String class,
        // and a few special classes that wrap certain primitive types:
        // Character, Byte, Short, and Integer (discussed in Numbers and Strings).
        // why is this rule ? when adding to map works with the object's hashCode and equals ?
        // switch (p2) {
        //     case p1:
        //         System.out.println("switch to p1");
        //         break;
        //     case p2:
        //         System.out.println("switch to p1");
        //         break;
        //     default:
        //         System.out.println("nothing to switch");
        // }

        System.out.println("8'th month is: " + monthName(8));
        System.out.println("Day.TUESDAY is: " + dayName(Day.TUESDAY));

        // can give labels to loops and break out of them specifically
        // normally break will break out of only the enclosing block ie. the next closing '}'
        int count = 0;
        OUTER_LOOP: while (count < 10) {
            switch (count) {
                case 5:
                    System.out.println("midway");
                    break;
                case 8:
                    System.out.println("almost there");
                    break OUTER_LOOP;
            }

            ++count;
        }
        System.out.println("count: " + count); // => 8

        Dog dog = new Dog("poodle", true);
        Animal animal = new Animal("dog");

        System.out.println("dog: " + dog);
        System.out.println("animal: " + animal);

        String[] sarr = new String[0];
        final Set<String> collect = Arrays.stream(sarr).collect(Collectors.toSet());
        System.out.println("set from stream: " + collect);

        TodoItem todo1 = new TodoItem("java");
        System.out.println(todo1.getFormalName());

        Box<String> box = new Box<String>(null);
        box.set("inside a box");
        System.out.println(box.get());
        System.out.println(box);

        Integer[] arr1 = new Integer[] {1, 2, 3, 4};
        String[] arr2 = new String[] {"a", "b", "c", "d"};
        int[] arr3 = new int[] { 1, 2, 3, 4};

        System.out.println("integer array(before): " + Arrays.toString(arr1));
        swapItems(0, 3, arr1);
        System.out.println("integer array(after): " + Arrays.toString(arr1));

        System.out.println("string array(before): " + Arrays.toString(arr2));
        swapItems(1, 3, arr2);
        System.out.println("string array(after): " + Arrays.toString(arr2));

        System.out.println("integer array(before): " + Arrays.toString(arr1));
        swapObjects(0, 3, arr1);
        System.out.println("integer array(after): " + Arrays.toString(arr1));

        System.out.println("string array(before): " + Arrays.toString(arr2));
        swapObjects(1, 3, arr2);
        System.out.println("string array(after): " + Arrays.toString(arr2));

        Animal a1 = new Animal("dog");
        Animal a2 = new Animal("dog");

        System.out.println("dogs same:" + a1.equals(a2)); // false
        System.out.println("dogs same:" + a1.equals(a1)); // true

        AnimalBox<Animal> animalBox = new AnimalBox<>(new Cat());
        System.out.println(animalBox);

        List<Animal> al = new ArrayList<Animal>();

        NaturalNumber<C> n = new NaturalNumber<>(new C());

        List<Integer> list1 = new NewList(); // ok
        // List<String> list2 = new NewList(); // type error

        Serializable pick1 = pick("d", new ArrayList<String>());
        String pick2 = pick("a", new String());
        // intellij is still showing the type parameter as Serializable
        CharSequence pick3 = pick("a", new RandomList<Integer>());
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

    @Contract(pure = true)
    public static String monthName(int month) {
        String monthString;

        // is type-safe so `case "10"` will throw a type error
        switch (month) {
            case 1:  monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }

        return monthString;
    }

    // Intellij inferred that this is a pure function :-) Yay
    // added annotations.jar provided by Intellij for this annotation
    @Contract(pure = true)
    public static String dayName(Day day) {
        String dayString;

        // will not work with Day.TUESDAY
        switch (day) {
            case MONDAY:
                dayString = "monday";
                break;
            case TUESDAY:
                dayString = "tuesday";
                break;
            default:
                dayString = "not monday or tue.";
        }

        return dayString;
    }
}
