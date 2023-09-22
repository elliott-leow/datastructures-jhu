package starter;

public class Main {
  public static void main(String[] args) {
    LinkedList<Integer> numbers = new LinkedList<>();
    numbers.addFirst(1);
    numbers.addFirst(2);
    numbers.addFirst(3);

    numbers.traverse();

    System.out.println();
    System.out.println(numbers.length());
    System.out.println("numbers.get(0) = " + numbers.get(0));
    System.out.println("numbers.get(1) = " + numbers.get(1));
    System.out.println("numbers.get(2) = " + numbers.get(2));
    System.out.println();
    numbers.addLast(11);
    numbers.addLast(12);
    numbers.addLast(13);
    numbers.traverse();
    System.out.println();

    // 3 2 1 (100) 11 12 13
    numbers.insert(3, 100);
    numbers.traverse();
    System.out.println();
    numbers.delete(0);
    numbers.traverse();
    System.out.println();
    numbers.delete(4);
    numbers.traverse();
    System.out.println();
    System.out.println("Enhanced for loop");
    for (int elem : numbers) {
      System.out.println(elem);
    }
  }
}
