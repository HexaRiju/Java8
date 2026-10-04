package FunctionalInterfaces;

import java.util.function.Supplier;

public class Supplie {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> {
            return 1;
        };
        System.out.println(supplier.get());
    }
}
