public class Programmer extends Person {
    private Integer githubID;

    public Programmer(String name, Integer githubID) {
        super(name);
        this.githubID = githubID;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + getName() + "'" +
                ", githubID=" + githubID +
                '}';
    }
}