package FunctionalInterfaces;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionalInterface{

    public static void main(String[] args) {

        // ============================================================
        // 1. BiPredicate
        // ============================================================

        /*
         * BiPredicate<T, U>
         *
         * Takes TWO inputs
         * Returns boolean
         *
         * Method:
         *
         *      test(T, U)
         *
         * Think:
         *
         *      "Ask a question about two values."
         */


        // Example 1:
        // Check whether both numbers are even.

        BiPredicate<Integer, Integer> bothEven =
                (x, y) -> x % 2 == 0 && y % 2 == 0;

        System.out.println(
                bothEven.test(2, 4)
        );
        // true


        System.out.println(
                bothEven.test(2, 5)
        );
        // false


        // ------------------------------------------------------------
        // Example 2:
        // Check whether a String's length equals a given number.
        // ------------------------------------------------------------

        BiPredicate<String, Integer> lengthEquals =
                (str, length) -> str.length() == length;

        System.out.println(
                lengthEquals.test("Hello", 5)
        );
        // true

        System.out.println(
                lengthEquals.test("Hello", 10)
        );
        // false


        // ============================================================
        // 2. BiFunction
        // ============================================================

        /*
         * BiFunction<T, U, R>
         *
         * Takes TWO inputs
         * Returns ONE result
         *
         * Method:
         *
         *      apply(T, U)
         *
         * Think:
         *
         *      "Give me two values and I will calculate something."
         *
         * T = first input type
         * U = second input type
         * R = return type
         */


        // Example 1:
        // Add two integers.

        BiFunction<Integer, Integer, Integer> add =
                (x, y) -> x + y;

        System.out.println(
                add.apply(10, 20)
        );
        // 30


        // ------------------------------------------------------------
        // Example 2:
        // Combine two Strings.
        // ------------------------------------------------------------

        BiFunction<String, String, String> combine =
                (first, second) -> first + " " + second;

        System.out.println(
                combine.apply("Hello", "World")
        );
        // Hello World


        // ------------------------------------------------------------
        // Example 3:
        // Return the sum of lengths of two Strings.
        // ------------------------------------------------------------

        BiFunction<String, String, Integer> totalLength =
                (x, y) -> x.length() + y.length();

        System.out.println(
                totalLength.apply("Hello", "World")
        );
        // 10


        // ============================================================
        // 3. BiConsumer
        // ============================================================

        /*
         * BiConsumer<T, U>
         *
         * Takes TWO inputs
         * Returns NOTHING
         *
         * Method:
         *
         *      accept(T, U)
         *
         * Think:
         *
         *      "Give me two values and I will DO something."
         */


        // Example 1:
        // Print the sum.

        BiConsumer<Integer, Integer> printSum =
                (x, y) -> System.out.println(x + y);

        printSum.accept(10, 20);
        // 30


        // ------------------------------------------------------------
        // Example 2:
        // Print two values.
        // ------------------------------------------------------------

        BiConsumer<String, Integer> printStudent =
                (name, age) ->
                        System.out.println(
                                "Name: " + name +
                                ", Age: " + age
                        );

        printStudent.accept("Rahul", 22);


        // ============================================================
        // 4. Combining them
        // ============================================================

        /*
         * These interfaces can be used together.
         *
         * Example:
         *
         * 1. BiPredicate checks a condition.
         * 2. BiFunction calculates a value.
         * 3. BiConsumer performs an action.
         */

        int a = 10;
        int b = 20;


        // Step 1: Check condition

        BiPredicate<Integer, Integer> positiveNumbers =
                (x, y) -> x > 0 && y > 0;


        if (positiveNumbers.test(a, b)) {

            // Step 2: Calculate result

            BiFunction<Integer, Integer, Integer> multiply =
                    (x, y) -> x * y;

            int result = multiply.apply(a, b);


            // Step 3: Perform an action

            BiConsumer<String, Integer> printResult =
                    (operation, value) ->
                            System.out.println(
                                    operation + ": " + value
                            );

            printResult.accept("Multiplication", result);
        }
    }
}