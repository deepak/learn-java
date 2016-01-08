package main;

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
