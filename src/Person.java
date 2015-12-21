import java.util.Objects;

public class Person {
    private String name;
    private int age; // defaults to 0 - if not initialized
    private Integer githubID; // defaults to null - if not initialized

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGithubID(Integer githubID) {
        this.githubID = githubID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, githubID=%d}",
                name, age, githubID);
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", githubID=" + githubID +
//                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return !(githubID != null ? !githubID.equals(person.githubID) : person.githubID != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (githubID != null ? githubID.hashCode() : 0);
        return result;
    }
}
