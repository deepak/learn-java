package main;

public class AnimalBox<T extends Animal> {
    private T t1;

    public AnimalBox(T t1) {
        this.t1 = t1;
    }

    public T getT() {
        return t1;
    }

    public void setT(T t) {
        this.t1 = t;
    }

    @Override
    public String toString() {
        return "AnimalBox{" +
                "t1=" + t1 +
                '}';
    }
}
