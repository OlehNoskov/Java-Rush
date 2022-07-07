package ua.com.javarush.generics.generator_object;

public class Generator<T> {
    private Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}