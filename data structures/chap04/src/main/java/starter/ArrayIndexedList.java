package starter;

/**
 * An implementation of IndexedList that takes a default value
 * to plaster over the entire data structure.
 */
public class ArrayIndexedList<T> implements IndexedList<T> {
  private T[] data;

  /**
   * Construct an ArrayIndexedList with given size and default value.
   *
   * @param size         the capacity of this list.
   * @param defaultValue an integer to plaster over the entire list.
   */
  public ArrayIndexedList(int size, T defaultValue) {

    data = (T[]) new Object[size]; //warning is ok
    for (int i = 0; i < data.length; i++) {
      data[i] = defaultValue;
    }
  }

  @Override
  public void put(int index, T value) {
    data[index] = value;
  }

  @Override
  public T get(int index) {
    return data[index];
  }

  @Override
  public int length() {
    return data.length;
  }
}