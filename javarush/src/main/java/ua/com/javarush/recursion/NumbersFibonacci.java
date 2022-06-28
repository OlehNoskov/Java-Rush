package ua.com.javarush.recursion;

// Числа Фибоначчи с помощью рекурсии - бесконечная числовая последовательность
// в которой каждое число равно сумме двух предыдущих
public class NumbersFibonacci {
    public static void main(String[] args) {
        NumbersFibonacci solution = new NumbersFibonacci();

        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
         if (n == 1 || n == 2) {
            return 1;
        } else
            // каждое число равно сумме двух предыдущих
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}