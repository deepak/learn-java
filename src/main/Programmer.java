package main;

public class Programmer
        extends Person
        implements Hipster {
    private Integer githubID;

    public Programmer(String name, Integer githubID) {
        super(name);
        this.githubID = githubID;
    }

    public Programmer(Person person) {
        super(person.getName());
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + getName() + "'" +
                ", githubID=" + githubID +
                '}';
    }

    @Override
    public Integer hipsterHandshake() {
        return 42;
    }
}
