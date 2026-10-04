package FunctionalInterfaces;

import java.util.function.Consumer;

public class consume {
    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Debo");
        Consumer<String> consumer2 = (x) -> System.out.println(x);
        consumer.andThen(consumer2).accept("Bhattacharyya");
    }
}
