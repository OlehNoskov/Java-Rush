package ua.com.javarush.exception.factory_exception;

public class FactoryExceptions {

    public static Throwable getException(Enum enumm) {
        if (enumm == null) return new IllegalArgumentException();
        String message = enumm.toString().charAt(0) + enumm.toString().toLowerCase().replace("_", " ");

        switch (enumm.getClass().getSimpleName()) {
            case "ApplicationExceptionMessage":
                return new Exception(message);
            case "DatabaseExceptionMessage":
                return new RuntimeException(message);
            case "UserExceptionMessage":
                return new Error(message);
            default:
                return new IllegalArgumentException();
        }
    }
}