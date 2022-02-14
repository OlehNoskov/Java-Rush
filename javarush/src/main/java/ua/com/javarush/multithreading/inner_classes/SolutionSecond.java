package ua.com.javarush.multithreading.inner_classes;

    public class SolutionSecond {
        public InnerClass[] innerClasses = new InnerClass[2];

        public class InnerClass {
        }

        public static SolutionSecond[] getTwoSolutions() {
            SolutionSecond[] twoSolutions = new SolutionSecond[2];

            SolutionSecond solution = new SolutionSecond();
            solution.innerClasses[0] = solution.new InnerClass();
            solution.innerClasses[1] = solution.new InnerClass();

            SolutionSecond solution2 = new SolutionSecond();
            solution.innerClasses[0] = solution2.new InnerClass();
            solution.innerClasses[1] = solution2.new InnerClass();

            twoSolutions[0] = solution;
            twoSolutions[1] = solution2;

            return twoSolutions;
        }

        public static void main(String[] args) {
            SolutionSecond.getTwoSolutions();
        }
    }