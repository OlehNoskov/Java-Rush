package ua.com.javarush.autoboxing.caching;

public interface Computable <Argument, Value>{
    Value compute(Argument argument) throws InterruptedException;
}