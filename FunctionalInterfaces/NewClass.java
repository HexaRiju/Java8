package FunctionalInterfaces;

import java.util.function.Predicate;

public class NewClass {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(2));
        Predicate<Integer> isOdd = (x) -> x % 2 != 0;
        System.out.println(isEven.and(isOdd).test(4));
        System.out.println(isEven.negate().test(2));
    }
}
