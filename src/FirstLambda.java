import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FirstLambda {

	public static void main(String[] args) {

		// Example 1
		// Before Java 8
		FileFilter fileFilter = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};

		// How you can use lamba from Java 8 onwards.
		FileFilter fileFilterLambda = (File pathname) -> pathname.getName().endsWith(".java");

		File dir = new File("/home/techbulls/Workspace/Java8/src");
		File[] files = dir.listFiles(fileFilterLambda);
		for (File file : files) {
			System.out.println(file);
		}

		// Example 2
		// Before Java 8
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Thread : " + Thread.currentThread().getName());
				}
			}
		};

		// How you can use lamba from Java 8 onwards.
		Runnable runnableLambda = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("Thread : " + Thread.currentThread().getName());
			}
		};

		Thread thread = new Thread(runnableLambda);
		thread.start();

		// Example 3
		List<String> strings = Arrays.asList("One", "Two", "Three");
		//Consumer<String> consumer = s -> System.out.println(s);
		Consumer<String> consumer = System.out::println;
		strings.forEach(consumer);

	}
}
