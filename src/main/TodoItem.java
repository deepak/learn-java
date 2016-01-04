package main;

public class TodoItem extends ChecklistItem {
    public TodoItem(String name) {
        super(name);
    }

    @Override
    public String getFormalName() {
        return "[TODO] " + name;
    }
}
