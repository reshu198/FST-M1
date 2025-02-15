package activities;

@FunctionalInterface
interface Addable {
	int add(int a, int b);
}

public class Activity12 {
	public static void main(String[] args) {

		// Lambda expression .
		Addable addObj1 = (int a, int b) -> {
			return (a + b);
		};

		System.out.println(addObj1.add(100, 200));
	}
}
