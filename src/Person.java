public class Person {
    private String name;
    private int age; // defaults to 0 - if not initialized
    private Integer githubID; // defaults to null - if not initialized

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
}
