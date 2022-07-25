package ua.com.javarush.annotations;

public class FirstSolution {
    @Deprecated
    private String[] arguments;

    @Deprecated
    @SafeVarargs
    public FirstSolution(String... arguments) {
        this.arguments = arguments;
    }

    @Deprecated
    public void voidMethod() throws Exception {
    }

    @Deprecated
    public static void main(String[] args) throws Exception {
        new FirstSolution().new SubSolution().voidMethod();
    }

    @Deprecated
    class SubSolution extends FirstSolution {

        @Deprecated
        @Override
        public void voidMethod() throws Exception {
            super.voidMethod();
        }
    }
}