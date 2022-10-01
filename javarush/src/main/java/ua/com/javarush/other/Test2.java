package ua.com.javarush.other;

public class Test2 {
    final StringBuilder str1 = new StringBuilder();
    final StringBuilder str2 = new StringBuilder();

    public static void main(String[] args) {
  Test2 test2 = new Test2();
  test2.run();

    }

    public void run(){
        for (int i=1; i<2; ++i){
            System.out.println(i + "...");
        }
    }
}