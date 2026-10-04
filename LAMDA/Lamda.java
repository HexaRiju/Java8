// 1. remove modifier 
// 2. remove return type, remove function name, add arrow (x, y) -> {x + y};
// it is an anonymous function .

// functional interface is the interface having only one abstract methoid but any number of 
// static or default methode.
// we can invoke lamda expression using this functional interface
package LAMDA;

interface Node {
    public void calculation(int a, int b);
}

class Lamda {
    public static void run(Node value) {
        value.calculation(10, 20);
    }

    public static void main(String[] args) {
        Node n = (a, b) -> System.out.println(a + b);
        run(n);
        Calculation cal = new Calculation();
        Calculation cal1 = new Calculation((a, b) -> {
            return a - b;
        });
        System.out.println(cal.ans(10, 20));
        System.out.println(cal1.ans(20, 10));
    }
}