package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Number[] numberArr = new Number[5];
        numberArr[0] = 10;
        numberArr[1] = 10.10;

        printArr(numberArr);

        Integer[] intArr = new Integer[5];
        intArr[0] = 10;

        // Integer[] is a subclass of Number[]
        // so this works. substitution principle
        printArr(intArr);

        List<Number> numberList = new ArrayList<>(10);
        numberList.add(10);
        numberList.add(10.10);

        printNumberList1(numberList);
        printNumberList2(numberList);

        List<Integer> integerList = new ArrayList<>(10);
        integerList.add(10);
        integerList.add(20);

        // type-error
        // List<Integer> is NOT a subclass of List<Number>
        // so this does not work
        // javac gets the error right
        // Error:(36, 26) java: incompatible types: java.util.List<java.lang.Integer> cannot be converted to java.util.List<java.lang.Number>
        // but Intellj gets it wrong, printNumberList1(java.util.List<java.lang.Number> in Main cannot be applied to (java.util.List<java.lang.Integer>)
        // printNumberList1(integerList);

        // this works though as it uses wildcards
        printNumberList2(integerList);
    }

    // Integer[] is a subclass of Number[]
    public static void printArr(Number[] arr) {
        System.out.println("----> printing array");
        for (Number n : arr) {
            if (n == null) { break; }

            System.out.println(n.getClass() + "{" + n + "}");
        }
        System.out.println("----> done");
    }

    // List<Integer> is NOT a subclass of List<Number>
    public static void printNumberList1(List<Number> list) {
        System.out.println("----> printing list");
        for (Number n : list) {
            System.out.println(n.getClass() + "{" + n + "}");
        }
        System.out.println("----> done");
    }

    public static void printNumberList2(List<? extends Number> list) {
        System.out.println("----> printing list with wildcard");
        for (Number n : list) {
            System.out.println(n.getClass() + "{" + n + "}");
        }
        System.out.println("----> done");
    }
}
