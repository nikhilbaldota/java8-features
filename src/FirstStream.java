import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstStream {

	public static void main(String[] args) {

		//Example 1 - filter

		Stream<String> stream = Stream.of("one", "two", "three");

		Predicate<String> predicate = s -> s.length() > 3;

		//stream.filter(predicate).forEach(s -> System.out.println(s));

		List<String> list = new ArrayList<>();

		// Below statement will demonstrate lazy evaluation
		//		stream.peek(System.out::println).filter(predicate).peek(list::add);

		// Here intermediate operation is filter & terminal operation is forEach
		System.out.println("Example 1 - ");
		stream.peek(System.out::println).filter(predicate).forEach(list::add);
		System.out.println("Filtered list : " + list);
		System.out.println();

		// Example 2 - reduction

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		Integer output = intList.stream().reduce(0, (i1, i2) -> i1 + i2);
		//		intList.stream().reduce(0, Integer::sum);
		System.out.println("Example 2 - ");
		System.out.println("Total of numbers : " + output);
		System.out.println();

		//Example 3 - map

		String[] myArray = new String[] { "bob", "alice", "paul", "ellie" };
		Stream<String> myStream = Arrays.stream(myArray);
		Stream<String> myNewStream = myStream.map(s -> s.toUpperCase());
		String[] myNewArray = myNewStream.toArray(String[]::new);
		System.out.println("Example 3 - ");
		Arrays.stream(myNewArray).forEach(System.out::println);

	}
}
