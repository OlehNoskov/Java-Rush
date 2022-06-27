package ua.com.javarush.solution_tasks_implemika.second_task;

public class Town {
    private String name;
    private int index;
    private boolean isInTree;

    public Town(String name, int index) {
        this.name = name;
        this.isInTree = false;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public boolean isInTree() {
        return isInTree;
    }

    public void setInTree(boolean inTree) {
        isInTree = inTree;
    }
}