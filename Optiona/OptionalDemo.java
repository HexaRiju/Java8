package Optiona;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        // ============================================================
        // 1. THE PROBLEM WITH NULL
        // ============================================================

        /*
         * Suppose we have a method that searches for a user.
         *
         * If the user exists:
         *
         *      return "Rahul";
         *
         * If the user doesn't exist:
         *
         *      return null;
         */

        String name = getName(1);

        /*
         * If name is null, this will throw:
         *
         *      NullPointerException
         *
         * because we are trying to call toUpperCase()
         * on a null reference.
         */

        // System.out.println(name.toUpperCase());


        // ------------------------------------------------------------
        // Traditional null checking
        // ------------------------------------------------------------

        if (name != null) {

            System.out.println(
                    "Name: " + name.toUpperCase()
            );

        } else {

            System.out.println("Name not found");
        }


        // ============================================================
        // 2. CREATING OPTIONAL
        // ============================================================

        /*
         * Optional<T> is a container.
         *
         * It can contain:
         *
         *      1. A value
         *
         * OR
         *
         *      2. Nothing (empty)
         */


        // ------------------------------------------------------------
        // Optional.of()
        // ------------------------------------------------------------

        /*
         * Use Optional.of() when you KNOW that the value
         * is NOT null.
         */

        Optional<String> name1 =
                Optional.of("Rahul");

        System.out.println(name1);


        /*
         * IMPORTANT:
         *
         * Optional.of(null)
         *
         * will itself throw NullPointerException.
         */

        // Optional<String> name2 = Optional.of(null); // ❌


        // ------------------------------------------------------------
        // Optional.ofNullable()
        // ------------------------------------------------------------

        /*
         * Use ofNullable() when the value MAY be null.
         *
         * If value is:
         *
         *      "Rahul"
         *
         * Optional contains Rahul.
         *
         * If value is:
         *
         *      null
         *
         * Optional becomes empty.
         */

        String nameFromDatabase = getName(2);

        Optional<String> optionalName =
                Optional.ofNullable(nameFromDatabase);

        System.out.println(
                "Optional name: " + optionalName
        );


        // ------------------------------------------------------------
        // Optional.empty()
        // ------------------------------------------------------------

        /*
         * Creates an empty Optional.
         */

        Optional<String> emptyName =
                Optional.empty();

        System.out.println(
                "Empty Optional: " + emptyName
        );


        // ============================================================
        // 3. isPresent()
        // ============================================================

        /*
         * isPresent() tells us whether the Optional
         * currently contains a value.
         */

        Optional<String> userName =
                Optional.ofNullable(getName(1));

        if (userName.isPresent()) {

            System.out.println(
                    "User exists: " + userName.get()
            );

        } else {

            System.out.println("User doesn't exist");
        }


        // ============================================================
        // 4. get()
        // ============================================================

        /*
         * get() extracts the value from Optional.
         */

        Optional<String> name3 =
                Optional.of("Ram");

        String actualName =
                name3.get();

        System.out.println(
                "Actual value: " + actualName
        );


        /*
         * WARNING:
         *
         * Calling get() on an empty Optional
         * throws NoSuchElementException.
         */

        Optional<String> empty =
                Optional.empty();

        // String value = empty.get(); // ❌ Exception


        /*
         * Therefore:
         *
         * Don't blindly do:
         *
         *      optional.get()
         *
         * without knowing whether the value exists.
         */


        // ============================================================
        // 5. ifPresent()
        // ============================================================

        /*
         * ifPresent() takes a Consumer.
         *
         * If value exists:
         *
         *      execute the Consumer.
         *
         * If value doesn't exist:
         *
         *      do nothing.
         */

        Optional<String> student =
                Optional.of("Rahul");

        student.ifPresent(
                value -> System.out.println(
                        "Student: " + value
                )
        );


        /*
         * Method reference version:
         */

        student.ifPresent(System.out::println);


        // ============================================================
        // 6. orElse()
        // ============================================================

        /*
         * orElse() provides a default value.
         *
         * If Optional contains a value:
         *
         *      return that value.
         *
         * Otherwise:
         *
         *      return the default value.
         */

        Optional<String> username =
                Optional.empty();

        String result =
                username.orElse("Guest");

        System.out.println(
                "Result: " + result
        );


        // If value exists:

        Optional<String> username2 =
                Optional.of("Debojyoti");

        String result2 =
                username2.orElse("Guest");

        System.out.println(
                "Result: " + result2
        );

        /*
         * Output:
         *
         * Guest
         * Debojyoti
         */


        // ============================================================
        // 7. orElseGet()
        // ============================================================

        /*
         * orElseGet() takes a Supplier.
         *
         * The Supplier is executed only when
         * the Optional is empty.
         */

        Optional<String> user =
                Optional.empty();

        String result3 =
                user.orElseGet(
                        () -> "Default User"
                );

        System.out.println(
                "Result: " + result3
        );


        // ============================================================
        // orElse() vs orElseGet()
        // ============================================================

        /*
         * This difference is important for interviews.
         *
         * orElse():
         *
         *      default expression is evaluated
         *      even if Optional contains a value.
         *
         *
         * orElseGet():
         *
         *      Supplier is executed only when
         *      Optional is empty.
         */

        Optional<String> value =
                Optional.of("Java");


        String value1 =
                value.orElse(
                        getDefaultValue()
                );

        /*
         * getDefaultValue() is called even though
         * "Java" already exists.
         */


        String value2 =
                value.orElseGet(
                        () -> getDefaultValue()
                );

        /*
         * Here getDefaultValue() is NOT called
         * because the Optional already contains "Java".
         */


        // ============================================================
        // 8. orElseThrow()
        // ============================================================

        /*
         * Sometimes we don't want a default value.
         *
         * We want to say:
         *
         *      "If the value doesn't exist,
         *       throw an exception."
         */

        Optional<String> customer =
                Optional.of("Rahul");

        String customerName =
                customer.orElseThrow(
                        NoSuchElementException::new
                );

        System.out.println(
                "Customer: " + customerName
        );


        /*
         * If customer were empty:
         *
         *      Optional.empty()
         *
         * then orElseThrow() would throw
         * NoSuchElementException.
         */


        // ============================================================
        // 9. map()
        // ============================================================

        /*
         * This is one of the MOST IMPORTANT Optional methods.
         *
         * Suppose:
         *
         *      Optional<String>
         *
         * contains:
         *
         *      "java"
         *
         * We want:
         *
         *      "JAVA"
         *
         * We can use map().
         */

        Optional<String> language =
                Optional.of("java");

        Optional<String> upperCase =
                language.map(
                        String::toUpperCase
                );

        System.out.println(
                "Uppercase: " + upperCase
        );


        // ============================================================
        // map() CHANGES THE TYPE
        // ============================================================

        /*
         * map() doesn't have to return the same type.
         *
         * Optional<String>
         *
         * can become:
         *
         * Optional<Integer>
         */

        Optional<String> word =
                Optional.of("Hello");

        Optional<Integer> length =
                word.map(String::length);

        System.out.println(
                "Length: " + length
        );


        /*
         * Notice:
         *
         * String::length returns int.
         *
         * But map() wraps the result again:
         *
         * Optional<Integer>
         */


        // ============================================================
        // 10. map() WITH EMPTY OPTIONAL
        // ============================================================

        /*
         * Suppose Optional is empty.
         */

        Optional<String> emptyString =
                Optional.empty();

        Optional<String> upper =
                emptyString.map(
                        String::toUpperCase
                );

        System.out.println(
                "Result: " + upper
        );

        /*
         * Output:
         *
         * Optional.empty
         *
         * The function isn't executed.
         *
         * This is one of the benefits of Optional.
         */


        // ============================================================
        // 11. filter()
        // ============================================================

        /*
         * Optional also has filter().
         *
         * It checks a condition.
         *
         * If condition is true:
         *
         *      Optional remains present.
         *
         * If condition is false:
         *
         *      Optional becomes empty.
         */

        Optional<Integer> age =
                Optional.of(25);

        Optional<Integer> adultAge =
                age.filter(
                        x -> x >= 18
                );

        System.out.println(
                "Adult age: " + adultAge
        );


        Optional<Integer> childAge =
                Optional.of(15);

        Optional<Integer> adultAge2 =
                childAge.filter(
                        x -> x >= 18
                );

        System.out.println(
                "Adult age: " + adultAge2
        );


        // ============================================================
        // 12. REALISTIC EXAMPLE
        // ============================================================

        /*
         * Imagine a UserService.
         *
         * Database search may or may not find a user.
         *
         * Instead of:
         *
         *      User findUser()
         *
         * returning null,
         *
         * we can return:
         *
         *      Optional<User>
         *
         * This makes the possibility of "not found"
         * explicit.
         */

        Optional<User> optionalUser =
                findUser(101);


        /*
         * We can safely transform the user.
         *
         * Suppose User has:
         *
         *      getName()
         *
         */

        Optional<String> userNameFromObject =
                optionalUser.map(
                        User::getName
                );

        System.out.println(
                "User name: "
                        + userNameFromObject
        );


        // Provide default if user doesn't exist

        String finalName =
                userNameFromObject.orElse(
                        "Unknown User"
                );

        System.out.println(
                "Final name: " + finalName
        );


        // ============================================================
        // 13. CHAINING OPTIONAL OPERATIONS
        // ============================================================

        /*
         * This is where Optional becomes really useful.
         *
         * Instead of:
         *
         *      if (user != null) {
         *          if (user.getName() != null) {
         *              ...
         *          }
         *      }
         *
         * We can create a chain.
         */

        String nameFromUser =
                findUser(101)
                        .map(User::getName)
                        .map(String::toUpperCase)
                        .orElse("UNKNOWN");

        System.out.println(
                "Processed name: "
                        + nameFromUser
        );
    }


    // ================================================================
    // HELPER METHODS
    // ================================================================

    static String getName(int id) {

        if (id == 1) {
            return "Rahul";
        }

        // Simulating "not found"
        return null;
    }


    static String getDefaultValue() {

        System.out.println(
                "getDefaultValue() was executed"
        );

        return "Default";
    }


    static Optional<User> findUser(int id) {

        if (id == 101) {

            return Optional.of(
                    new User("Rahul")
            );
        }

        return Optional.empty();
    }
}


// ====================================================================
// SIMPLE USER CLASS
// ====================================================================

class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
