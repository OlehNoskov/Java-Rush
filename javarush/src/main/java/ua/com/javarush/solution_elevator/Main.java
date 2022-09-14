package ua.com.javarush.solution_elevator;

public class Main {
    public static void main(String[] args) {
        System.out.println("===========================");
        for (int i = Initialization.getInitListFloors().size()-1; i >= 0; i--) {
            System.out.println(Initialization.getInitListFloors().get(i));
        }
    }
}