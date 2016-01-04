package main;

public class Animal {
    private String family;

    public Animal(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "family='" + family + '\'' +
                '}';
    }
}
