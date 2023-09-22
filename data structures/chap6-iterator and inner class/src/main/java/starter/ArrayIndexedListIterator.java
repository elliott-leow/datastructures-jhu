package starter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIndexedListIterator<T> implements Iterator<T> {

  private T[] data;
  int cursor;

  public ArrayIndexedListIterator(T[] data) {
    this.data = data;
    cursor = 0;
  }

  @Override
  public boolean hasNext() {
    //return true if my internal cursor is a valid index
    return cursor < data.length;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    } else {
      return data[cursor++];
    }
  }
}
