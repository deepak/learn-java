package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>(10);
        list1.add(10.10);
        list1.add("foo");

        printList(list1);

        List<?> list2 = new ArrayList<>(10);
        // what an error message from javac
        // Error:(18, 14) java: no suitable method found for add(int)
        // method java.util.Collection.add(capture#1 of ?) is not applicable
        //         (argument mismatch; int cannot be converted to capture#1 of ?)
        // method java.util.List.add(capture#1 of ?) is not applicable
        //        (argument mismatch; int cannot be converted to capture#1 of ?)
        // thankfully Intellij has a better error message
        // add(capture<?>) in List cannot be applied to (int)
        // type-error
        // list2.add(10);
        printList(list2);

        int value = 20;
        List<Object> list3 = new ArrayList<>(10);
        list3.add(10);
        list3.add(value);
        list3.add(10.10);
        list3.add("foo");
        list3.add(new Integer[] { 4, 5, 6});
        list3.add(new int[] { 1, 2, 3}); // works as well
        printList(list3);
    }

    public static void printList(List<?> list) {
        for (Object elem: list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static <T extends Object> void printValue(T element) {

    }
}
