package main;

public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    public static <T> boolean compare(Box<T> b1, Box<T> b2) {
        // will not allow me to call person specific code
        // or even call instanceof

        // type-error: cannot cast
        // if (b1 instanceof Person) {
        //     // type-error: cannot resolve getName
        //     return b1.get().getName().equals(b2.get().getName());
        // }
        return b1.get().equals(b2.get());
    }

    // clashes with `public static <T> boolean compare(Box<T> b1, Box<T> b2)` above
    // due to type erasure
    // public static <T extends Person> boolean compare(Box<T> b1, Box<T> b2) {
    //    return b1.get().getName().equals(b2.get().getName());
    // }

    public static boolean compare(Person p1, Person p2) {
        return p1.getName().equals(p2.getName());
    }
}
