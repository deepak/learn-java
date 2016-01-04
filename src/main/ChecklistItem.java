package main;

public abstract class ChecklistItem {

    public String name;

    public ChecklistItem(String name) {
        this.name = name;
    }

    // not allowed
    //public abstract ChecklistItem(int one, int two);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getFormalName();
}
