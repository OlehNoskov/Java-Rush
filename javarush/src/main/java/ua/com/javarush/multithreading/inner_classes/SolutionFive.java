package ua.com.javarush.multithreading.inner_classes;

public class SolutionFive {

    private String name;

    SolutionFive(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void sout() {
        new SolutionFive("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new SolutionFive("Риша").sout();
    }
}