package main;

public class Box<T> {
    private T t;

    public Box() {
        // noop
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    @Override
    public String toString() {
        return "Box{" +
                "t=" + get() +
                '}';
    }
}