package FunctionalInterfaces;

import java.util.*;
import java.util.function.Function;

class Student {
    int roll;
    String name;

    Student(int roll, String name) {
        this.name = name;
        this.roll = roll;
    }
}

public class Func {
    public static void main(String[] args) {
        Function<String, Integer> findLength = x -> x.length();
        System.out.println(findLength.apply("Debojyoti"));

        List<Student> studentList = new ArrayList<>(List.of(new Student(1, "Debojyoti"), new Student(2, "Dev")));
        Function<List<Student>, List<String>> findName = (x) -> {
            List<String> s = new ArrayList<>();
            for (Student S : x) {
                s.add(S.name);
            }
            return s;
        };
        System.out.println(findName.apply(studentList));
        Function<Integer, Integer> dobol = x -> x * 2;
        Function<Integer, Integer> cube = x -> x * x * x;
        System.out.println(dobol.andThen(cube).apply(3));
        System.out.println(Function.identity().apply("Debojyoti"));

    }

}
