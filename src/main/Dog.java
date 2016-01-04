package main;

public class Dog extends Animal {
    private boolean isVaccinated;

    public Dog(String family, boolean isVaccinated) {
        // compile will throw an error unless super is called first
        // an exception to this rule is, if Animal has a default constructor
        // and even it is good-form to use the super-class constructor
        // rather than the setter `super.setSomthing()` in the constructor
        super(family);
        this.isVaccinated = isVaccinated;
    }

    @Override
    public String toString() {
        // need to call `super.toString()` not just super
        return "Dog{" +
                super.toString() +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
