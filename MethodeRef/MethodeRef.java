package MethodeRef;

import java.util.List;

class Student{
    String name;

    Student(String name){
        this.name = name;
    }
}

public class MethodeRef {
    public static void print(int x){
        System.out.println(x);
    }
    public void print1(int x){
        System.out.println(x);
    }
    public static void main(String[] args) {
        // we can use method reference to refer to a method of a class or an object.
        // there are four types of method references:
        // 1. Static method reference
        // 2. Instance method reference
        // 3. Constructor reference
        // 4. Array constructor reference
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        arr.forEach(x -> System.out.println(x)); // using lambda expression
        arr.forEach(MethodeRef::print); // using method reference
        // for a non static method we have to create an object of the class and then we can do the method reference like this.
        MethodeRef obj = new MethodeRef();
        arr.forEach(obj::print1); // using method reference for a non static method

        
        List<String> names = List.of("Debojyoti", "Dev", "Debasish");
        List<Student> students = names.stream().map(x -> new Student(x)).toList(); // using lambda expression
        List<Student> students1 = names.stream().map(Student::new).toList(); // using constructor reference
    }
}
