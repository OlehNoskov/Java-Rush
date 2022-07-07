package ua.com.javarush.generics.first;

/*
Несколько суперклассов для дженерика
*/

// Параметризированный класс Т extends ClassForGenerics и реализация интрефейса InterfaceForGenerics
public class Solution <T extends ClassForGenerics & InterfaceForGenerics> {
    public static void main(String[] args) {
        Solution<TestClassGood> testClassSolution = new Solution<>();
        testClassSolution.check();

        /*
        !!! Следующие оба варианта не должны работать, закомментируй их:
        Solution<TestClassWrong1> wrong1Solution = new Solution<>();
        wrong1Solution.check();

        Solution<TestClassWrong2> wrong2Solution = new Solution<>();
        wrong2Solution.check();
         */
    }

    public void check() {
        System.out.println("Works!");
    }

    // Этот класс будет рабоать потому что extends ClassForGenerics implements InterfaceForGenerics
    public static class TestClassGood extends ClassForGenerics implements InterfaceForGenerics {

    }

    // Этот класс не будет работать
    public static class TestClassWrong1 extends ClassForGenerics {

    }

    // Этот класс не будет работать
    public static class TestClassWrong2 implements InterfaceForGenerics {

    }
}