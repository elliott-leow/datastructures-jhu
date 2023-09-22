package starter;

import starter.ArrayIndexedList;
import starter.IndexedList;

import java.sql.Array;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    int[] myArray = new int[5];

    System.out.println("classic for loop over array");
    for (int i = 0; i < myArray.length; i++) {
      System.out.println(myArray[i]);
    }
    System.out.println();

    IndexedList<Integer> myIndexedList = new ArrayIndexedList<>(5, 0);

    System.out.println("classic for loop over IndexedList");
    for (int i = 0; i < myIndexedList.length(); i++) {
      System.out.println(myIndexedList.get(i));
    }
    System.out.println();

    System.out.println("enhanced for loop over array");
    for (int elem : myArray) {
      System.out.println(elem);
    }

    System.out.println("enhanced for loop over IndexedList");
    for (int elem : myIndexedList) {
      System.out.println(elem);
    }
    System.out.println();

    System.out.println("classic loop using IndexedList iterator directly");
    Iterator<Integer> it = myIndexedList.iterator();
    while(it.hasNext()) {
      int elem = it.next();
      System.out.println(elem);
    }


  }
}
