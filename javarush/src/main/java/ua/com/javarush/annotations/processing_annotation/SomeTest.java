package ua.com.javarush.annotations.processing_annotation;

@PrepareMyTest(value = {Solution.class, SomeTest.class}, fullyQualifiedNames = "ua.com.javarush.annotations.processing_annotation.Fox")
public class SomeTest {
}