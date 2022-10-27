package ua.com.javarush.learning_geek_for_less.builder;

public class BuildMain {
    private int id;
    private String type;

    public BuildMain(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BuildMain{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}