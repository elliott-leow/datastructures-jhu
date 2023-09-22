package starter;

public class Main {
  public static void main(String[] args) {
    IndexedList<Integer> numbers = new ArrayIndexedList<>(10, -1);
    //= new ArrayIndexedList(10, -1);
    numbers.put(0, 1);
    numbers.put(1, 2);

    for (int i = 0; i < numbers.length(); i++) {
      System.out.println(numbers.get(i));
    }

    IndexedList<String> names = new ArrayIndexedList<>(5, "---");
    names.put(0, "Alice");
    names.put(1, "Bob");
    for (int i = 0; i < names.length(); i++) {
      System.out.println(names.get(i));
    }

  }
}
