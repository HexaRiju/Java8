package Streams;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream();
        String[] array = {"one", "two", "three", "four", "five"};
        Stream<String> stream1 = Stream.of(array);// or we can do Arrays.stream(array);

        // generate a loop using the iterate method
        Stream<Integer> stream2 = Stream.iterate(1, x -> x + 1).limit(50);
        // if we want to generate a stream of random numbers we can use the generate method
        Stream<Integer> stream3 = Stream.generate(() -> (int)Math.random() * 100).limit(10);
        Stream<Integer> stream4 = Stream.iterate(1, x -> x + 1).limit(50);
        stream3.toList().forEach(System.out::println);

        List<Integer> list1 = stream2.filter((x) -> x % 2 == 0).collect(Collectors.toList());// as the name filer it work as same , 
        // it filter the stream and return a new stream with only the elements that match the given predicate. 
        // In this case we are filtering the stream to only include even numbers.
        System.out.println(list1);
        List<Integer> list2 = list1.stream().map(x -> x / 2).toList();// as the name the map method is used to transform 
        // the elements of a stream.
        System.out.println(list2);
        // but we can do the filter and map in one line like this
        List<Integer> list3 = stream4.filter((x) -> x % 2 == 0).
        map(x -> x / 2).
        collect(Collectors.toList());
        // one important thing here we can not use stream 2 as we use collect() method which is a terminal operation and 
        // it will close the stream and we can not use it again.
        // if we want to use the same stream we have to use toList() method which will return a new list and we can use it again.
        System.out.println(list3);
        list3 = list3.stream().
        map(x -> x % 2).
        distinct().
        collect(Collectors.toList());// the distinct method is used to 
        // remove the duplicate elements from the stream.
        System.out.println(list3);
        list2 = list2.stream().sorted().collect(Collectors.toList());// the sorted method is used to sort the elements of a stream.
        System.out.println(list2);

        int max = list.stream().distinct().max((x, y) -> x - y).get();// the max method is used to find the maximum element of a stream.first it sort the element in assanding order and then return the last element 
        System.out.println(max);
        int min = list.stream().distinct().max((x, y) -> y - x).get();// here one thing is happning (x, y) -> y - x so first it is sorting (dessending order)and then returning the last value.
        System.out.println(min);
        int min2  = list.stream().distinct().min((x, y) -> x - y).get();// here one thing is happning (x, y) -> x - y so first it is sorting (assending order)and then returning the first value.
        System.out.println(min2);
        int max2  = list.stream().distinct().min((x, y) -> y - x).get();// here one thing is happning (x, y) -> y - x so first it is sorting (dessending order)and then returning the first value.
        System.out.println(max2);
        long count = list.stream().distinct().count();// the count method is used to count the number of elements in a stream.
        System.out.println(count);
        // important :
        // count(), max(), min(), collect() are terminal operations and they will close the stream and we can not use it again.
        // use of skip and limit method
        List<Integer> list4 = list.stream().skip(2).limit(5).collect(Collectors.toList());// the skip method is used to skip the first n elements of a stream and the limit method is used to limit the number of elements in a stream.
        System.out.println(list4);
        List<Integer> list5 = List.of(1,2,2,2,2,2,2,2,2);
        list5.parallelStream().forEach(System.out::println);// the parallelStream() method is used to create a parallel stream which will use multiple threads to process the elements of a stream. 
        // use parallelStream() method when we have a large number of elements in a stream and we want to process them in parallel to improve the performance.
        int sum = list.stream().filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y);// the reduce method is used to reduce the elements of a stream to a single value.
        System.out.println(sum);
    }
}

