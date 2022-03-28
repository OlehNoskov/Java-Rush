package ua.com.javarush.html_editor;

public class ExceptionHandler extends Throwable {

    public static void log(Exception e){
        System.out.println(e.toString());
    }
}