package ua.com.javarush.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getStudents());
        System.out.println(getStudents().size());
    }

    private static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Oleg", "Noskov", 29));
        students.add(new Student("Oleg", "Soskov", 30));
        students.add(new Student("Iryna", "Rastvorceva", 27));
        students.add(new Student("Maksim", "Nuznenko", 28));
        students.add(new Student("Sergey", "Noskov", 25));
        students.add(new Student("Alina", "Shevchenko", 20));
        students.add(new Student("Iryna", "Noskova", 22));
        students.add(new Student("Igor", "Babakin", 45));
        students.add(new Student("Yurii", "Noskov", 50));
        students.add(new Student("Oksana", "Barteneva", 47));
        students.add(new Student("Vlad", "Kysil", 35));

        return students.stream().filter(student -> student.age > 40).collect(Collectors.toList());
//        return students.stream().filter(student -> student.getName().equals("Igor")).collect(Collectors.toList());
//        return students.stream().min(Comparator.comparing(Student::getAge)).orElse(null);
//        return students.stream().max(Comparator.comparing(Student::getAge)).orElse(null);
//        return students.stream().filter(student -> student.getAge() > 25 && student.getAge() < 40).collect(Collectors.toList());
//        return students.stream().anyMatch(student -> student.getName().equals("Oleg"));
//        return students.stream().anyMatch(student -> student.getName().equals("Oleg"));
//        return students.stream().allMatch(student -> student.getAge() < 60);
//        return students.stream().allMatch(student -> student.getAge() < 18);
    }

    private static class Student {
        private String name;
        private String surname;
        private int age;

        public Student(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, age);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}