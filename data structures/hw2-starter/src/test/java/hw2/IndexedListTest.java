package hw2;

import exceptions.IndexException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit Tests for any class implementing the IndexedList interface.
 */
public abstract class IndexedListTest {
  protected static final int LENGTH = 10;
  protected static final int INITIAL = 7;
  private IndexedList<Integer> indexedList;

  public abstract IndexedList<Integer> createArray();

  @BeforeEach
  public void setup() {
    indexedList = createArray();
  }

  @Test
  @DisplayName("get() returns the default value after IndexedList is instantiated.")
  void testGetAfterConstruction() {
    for (int index = 0; index < indexedList.length(); index++) {
      assertEquals(INITIAL, indexedList.get(index));
    }
  }

  @Test
  @DisplayName("get() throws exception if index is below the valid range.")
  void testGetWithIndexBelowRangeThrowsException() {
    try {
      indexedList.get(-1);
      fail("IndexException was not thrown for index < 0");
    } catch (IndexException ex) {
      return;
    }
  }

  @Test
  @DisplayName("length() does not change after values are modified")
  void testLengthAfterModification() {
    IndexedList<Integer> test = new SparseIndexedList<>(4, 1);
    assertEquals(test.length(), 4);
    test.put(2, 10);
    assertEquals(test.length(), 4);
    test.put(0, 10);
    assertEquals(test.length(), 4);
  }

  @Test
  @DisplayName("put() can insert a node at the beginning and end of a nonempty list")
  void testPutAtBeginningOfNonEmptyList() {
    IndexedList<Integer> test = new SparseIndexedList<>(4, 1);
    test.put(3, 10);
    test.put(0, 10);

    for (int i : test) {
      System.out.println(i);
    }
  }

  @Test
  @DisplayName("get() can retrieve all values of a list of no nodes")
  public void getAllValuesOfEmptySparseIndexedList() {
    IndexedList<Integer> test = createArray();
    for (int i = 0; i < test.length(); i++) {
      assertEquals(7, test.get(i));
    }
  }

  @Test
  @DisplayName("iterator can iterate through all values of an empty list")
  public void getValuesOfEmptyListUsingIterator() {
    IndexedList<Integer> test = createArray();
    for (int i : test) {
      assertEquals(7, test.get(i));
    }
  }

  @Test
  @DisplayName("get() can get all of the values of a list with filled with nodes.")
  public void getAllValuesOfSparseIndexedListWithAllAssignedValues() {
    IndexedList<Integer> test = new SparseIndexedList<Integer>(4, 2);
    test.put(0,5);
    test.put(1,6);
    test.put(2,7);
    test.put(3,8);
    assertEquals(5, test.get(0));
    assertEquals(6, test.get(1));
    assertEquals(7, test.get(2));
    assertEquals(8, test.get(3));
    test.put(2 ,6);
    assertEquals(6, test.get(2));
  }

  @Test
  @DisplayName("iterator can iterate through default values and one node at the end")
  public void getAllValuesUsingIterator() {
    IndexedList<Integer> test = new SparseIndexedList<Integer>(10, 2);
    test.put(9, 10);
    for (int i : test) {
      System.out.println(i);
    }
  }

  @Test
  @DisplayName("put() can replace a value at the front of a list in a list of all filled nodes")
  public void putAtFront() {
    IndexedList<Integer> test = new SparseIndexedList<Integer>(4, 2);
    test.put(0,5);
    test.put(1,6);
    test.put(2,7);
    test.put(3,8);
    test.put(0, 10);
    assertEquals(10, test.get(0));
  }

  @Test
  @DisplayName("get() returns correct value for a default value with the index less than head.index")
  public void getUnchangedFirst() {
    IndexedList<Integer> test = new SparseIndexedList<Integer>(2, 2);
    test.put(1, 4);
    test.get(0);
  }

  @Test
  @DisplayName("test list with other data types other than int")
  public void stringSparseList() {
    IndexedList<String> test = new SparseIndexedList<>(3, "aa");
    test.put(2, "bb");
    assertEquals("bb", test.get(2));
  }

  @Test
  @DisplayName("put() puts a default value for both a node in the middle of the list and at the beginning")
  public void testPutDefaultValue() {
    IndexedList<Integer> list = new SparseIndexedList<>(10, 0);
    list.put(5, 10);
    list.put(5, 0);
    list.put(0, 10);
    list.put(0, 0);
    assertEquals(0, list.get(5));
  }

  @Test
  @DisplayName("put can put a value at the start of list.")
  public void testPutAtTheStart() {
    IndexedList<Integer> list = new SparseIndexedList<>(10, 0);
    list.put(0, 10);
    assertEquals(10, list.get(0));
  }

  @Test
  @DisplayName("put() can replace a value at the end of a list")
  public void testPutAtTheEnd() {
    IndexedList<Integer> list = new SparseIndexedList<>(10, 0);
    list.put(9, 4);
    list.put(1, 10);
    list.put(9, 10);
    assertEquals(10, list.get(9));
  }

  @Test
  @DisplayName("iterator next() returns the correct value of a list for the entire list.")
  public void testIteratorOverModifiedList() {
    IndexedList<Integer> list = new SparseIndexedList<>(5, 0);
    list.put(3, 10);
    Iterator<Integer> iterator = list.iterator();
    list.put(4, 20);
    assertEquals(0, iterator.next());  // default value
    assertEquals(0, iterator.next());  // default value
    assertEquals(0, iterator.next());  // default value
    assertEquals(10, iterator.next()); // value at index 3
    assertEquals(20, iterator.next()); // updated value at index 4
  }

  @Test
  @DisplayName("iterator hasNext() returns true if its not the last node.")
  public void testIteratorEndOfList() {
    IndexedList<Integer> list = new SparseIndexedList<>(5, 0);
    Iterator<Integer> iterator = list.iterator();
    for (int i = 0; i < 5; i++) {
      assertEquals(true, iterator.hasNext());
      iterator.next();
    }
    assertEquals(false, iterator.hasNext()); // No more elements after the 5th
  }

  @Test
  @DisplayName("test iterator next() returns correct values for a node and a default value")
  public void testIteratorNext() {
    IndexedList<Integer> list = new SparseIndexedList<>(5, 0);
    list.put(1, 10);
    Iterator<Integer> iterator = list.iterator();
    assertEquals(0, iterator.next());  // default value
    assertEquals(10, iterator.next()); // non-default value at index 1
  }


}
