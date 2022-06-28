package ua.com.javarush.recursion;

/*
Разложение на множители с помощью рекурсии
*/
public class Recursion {
    public static void main(String[] args) {
        recurse(132);
    }

    public static void recurse(int n) {
        if (n <= 1) return;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }
    }
}