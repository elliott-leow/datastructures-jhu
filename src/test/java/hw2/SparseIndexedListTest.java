package hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SparseIndexedListTest extends IndexedListTest {

  @Override
  public IndexedList<Integer> createArray() {
    return new SparseIndexedList<>(LENGTH, INITIAL);
  }


  @Test
  public void getAllValuesOfEmptySparseIndexedList() {
    IndexedList<Integer> test = createArray();
    for (int i = 0; i < test.length(); i++) {
      assertEquals(7, test.get(i));
    }
  }

  @Test
  public void getValuesOfEmptyListUsingIterator() {
      IndexedList<Integer> test = createArray();
      for (int i : test) {
        assertEquals(7, test.get(i));
      }
  }

  @Test
  public void getAllValuesOfSparseIndexedListWithAllAssignedValues() {
    SparseIndexedList<Integer> test = new SparseIndexedList<Integer>(4, 2);
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
  public void putAtFront() {
    SparseIndexedList<Integer> test = new SparseIndexedList<Integer>(4, 2);
    test.put(0,5);
    test.put(1,6);
    test.put(2,7);
    test.put(3,8);
    test.put(0, 10);
    assertEquals(10, test.get(0));
  }

  @Test
  public void getValuesOfUnchangedLengthOneSparseIndexedList() {
    SparseIndexedList<Integer> test = new SparseIndexedList<Integer>(1, 2);
    assertEquals(2, test.get(0));
  }

  @Test
  public void getValuesOfChangedLengthOneSparseIndexedList() {
    SparseIndexedList<Integer> test = new SparseIndexedList<Integer>(1, 2);
    test.put(0,5);
    assertEquals(5, test.get(0));
  }

  @Test
  public void getUnchangedFirst() {
    SparseIndexedList<Integer> test = new SparseIndexedList<Integer>(2, 2);
    test.put(1, 4);
    test.get(0);
  }

  @Test
  public void stringSparseList() {
    SparseIndexedList<String> test = new SparseIndexedList<>(3, "aa");
    test.put(2, "bb");
    assertEquals("bb", test.get(2));
  }

  @Test
  public void testPutDefaultValue() {
    SparseIndexedList<Integer> list = new SparseIndexedList<>(10, 0);
    list.put(5, 10);
    list.put(5, 0);
    assertEquals(0, list.get(5));
  }

  @Test
  public void testPutAtTheStart() {
    SparseIndexedList<Integer> list = new SparseIndexedList<>(10, 0);
    list.put(0, 10);
    assertEquals(10, list.get(0));
  }

  @Test
  public void testPutAtTheEnd() {
    SparseIndexedList<Integer> list = new SparseIndexedList<>(10, 0);
    list.put(9, 4);
    list.put(1, 10);
    list.put(9, 10);
    assertEquals(10, list.get(9));
  }

  @Test
  public void testIteratorOrder() {
    SparseIndexedList<Integer> list = new SparseIndexedList<>(5, 0);
    list.put(1, 10);
    list.put(3, 20);
    Integer[] expected = {0, 10, 0, 20, 0};
    int index = 0;
    for (int value : list) {
      assertEquals(expected[index], value);
      index++;
    }
  }

  @Test
  public void testIteratorOverModifiedList() {
    SparseIndexedList<Integer> list = new SparseIndexedList<>(5, 0);
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
  public void testIteratorEndOfList() {
    SparseIndexedList<Integer> list = new SparseIndexedList<>(5, 0);
    Iterator<Integer> iterator = list.iterator();
    for (int i = 0; i < 5; i++) {
      assertEquals(true, iterator.hasNext());
      iterator.next();
    }
    assertEquals(false, iterator.hasNext()); // No more elements after the 5th
  }

  @Test
  public void testIteratorNext() {
    SparseIndexedList<Integer> list = new SparseIndexedList<>(5, 0);
    list.put(1, 10);
    Iterator<Integer> iterator = list.iterator();
    assertEquals(0, iterator.next());  // default value
    assertEquals(10, iterator.next()); // non-default value at index 1
  }

}