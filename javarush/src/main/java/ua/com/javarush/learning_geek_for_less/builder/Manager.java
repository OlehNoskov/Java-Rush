package ua.com.javarush.learning_geek_for_less.builder;

public class Manager {

    public void constructorAutoBuild(Builder builder){
        builder.setId(1);
        builder.setType("Constructor Auto Build");
    }

    public void constructorManualBuild(Builder builder){
        builder.setId(2);
        builder.setType("Constructor Manual Build");
    }

    public void constructorOtherBuild(Builder builder){
        builder.setId(3);
        builder.setType("Constructor Other Build");
    }
}