package starter;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class IndexedListTest {


  IndexedList<Integer> numbers;
  private final static int size = 5;
  private final static int  defaultValue = -1;

  @BeforeEach
  void setup() {
    numbers = new ArrayIndexedList<>(size, defaultValue);
  }

  @Test
  @DisplayName("length() returns the size of the IndLxlist after it's instantiated")
  void testLengthAfterConstruction(){

    assertEquals(5, numbers.length());
  }

  @Test
  @DisplayName("get() returns the default value after IndexedList is instantiated.")
  void testGetAfterConstruction() {

    for (int i = 0; i < numbers.length(); i++) {

      assertEquals(-1, numbers.get(i));
    }
  }

  @Test
  @DisplayName("put() changes the default value after IndexedList is instantiated.")
  void testPutChangesValueAfterConstruction() {
    

    numbers.put(3, 100);
    assertEquals(100, numbers.get(3));
  }

  @Test
  @DisplayName("put() overwrites the existing value at given index to provided value.")
  void testPutUpdatesValueAtGivenIndex() {


    numbers.put(4, 100);
    numbers.put(4, 200);
    assertEquals(200, numbers.get(4));
  }
}