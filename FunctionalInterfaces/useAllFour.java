package FunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class useAllFour {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> multiplication = x -> x * x * x;
        Supplier<Integer> supplier = () -> 100;
        Consumer<Integer> consumer = x -> System.out.println(x);
        if (predicate.test(supplier.get())) {
            consumer.accept(multiplication.apply(supplier.get()));
        }
    }
}
