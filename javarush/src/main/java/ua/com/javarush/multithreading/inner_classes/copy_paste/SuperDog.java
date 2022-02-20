package ua.com.javarush.multithreading.inner_classes.copy_paste;

import java.text.SimpleDateFormat;

public abstract class SuperDog {

    protected String getSuperQuotes() {
        //some logic here
        return " *** ";
    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");
}