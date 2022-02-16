package ua.com.javarush.multithreading.inner_classes;

public class SolutionFour {
    public final String name;
    public final String food;
    public final String sound;

    public SolutionFour(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                SolutionFour.this.sleep(1000);
                //Вызов метода класса Solution а не Thread!
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new SolutionFour("Amigo", "beef", "knock").live();
    }
}