package main;

//https://docs.oracle.com/javase/tutorial/java/generics/types.html
//The most commonly used type parameter names are:
//E - Element (used extensively by the Java Collections Framework)
//K - Key
//N - Number
//T - Type
//V - Value
//S,U,V etc. - 2nd, 3rd, 4th types
public class Box<Type> {
    private Type t; // not the same as the main.Type class
    private AnotherType t2;
    private main.Type mainType;

    public Box() {
        this.t2 = new AnotherType();
        this.mainType = new main.Type();
    }

    public void set(Type t) {
        this.t = t;
    }

    public Type get() {
        return t;
    }

    @Override
    public String toString() {
        return "Box{" +
                "mainType=" + mainType +
                ", t=" + t +
                ", t2=" + t2 +
                '}';
    }
}
