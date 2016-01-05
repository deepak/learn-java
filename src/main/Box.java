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
    private Type t1; // not the same as the main.Type class
    private AnotherType t2;
    private main.Type mainType;

    public Box(Type t1) {
        // no way for us to do, `new Type()`
        this(t1, new AnotherType());
    }

    public Box(Type t1, AnotherType t2) {
        this.t1 = t1;
        this.t2 = t2;
        this.mainType = new main.Type();
    }

    public void set(Type t) {
        this.t1 = t;
    }

    public Type get() {
        return t1;
    }

    @Override
    public String toString() {
        return "Box{" +
                "mainType=" + mainType +
                ", t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }
}