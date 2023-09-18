package hw2;

import exceptions.IndexException;
import exceptions.LengthException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * An implementation of an IndexedList designed for cases where
 * only a few positions have distinct values from the initial value.
 *
 * @param <T> Element type.
 */
public class SparseIndexedList<T> implements IndexedList<T> {

  private T defaultValue;
  private int size;

  private Node<T> head;

  /**
   * Constructs a new SparseIndexedList of length size
   * with default value of defaultValue.
   *
   * @param size Length of list, expected: size > 0.
   * @param defaultValue Default value to store in each slot.
   * @throws LengthException if size <= 0.
   */
  public SparseIndexedList(int size, T defaultValue) throws LengthException {
    if (size <= 0) {
      throw new LengthException();
    }
    this.defaultValue = defaultValue;
    this.size = size;
  }

  @Override
  public int length() {
    return size;
  }

  @Override
  public T get(int index) throws IndexException {
    if (index >= size || index < 0) {
      throw new IndexException();
    } else {
      Node<T> currentHead = head;
      while (true) {
        if (currentHead == null) {
          return defaultValue;
        } else if (currentHead.index == index) {
          return currentHead.data;
        } else if (currentHead.index > index) {
          return defaultValue;
        } else if (currentHead.next != null) {
          currentHead = currentHead.next;
        } else {
          return defaultValue;
        }
      }
    }
  }

  @Override
  public void put(int index, T value) throws IndexException {
    if (index < 0 || index >= size) {
      throw new IndexException();
    } else {
      Node<T> newNode = new Node<>(value, index);
      Node<T> previous = null;
      Node<T> current = head;
      if (head == null) {
        head = newNode;
      } else if (head.index == index) {
        if (value.equals(defaultValue)) {
          head = head.next;
        } else {
          head.data = value;
        }
      } else {
        boolean found = false;
        while (!found) {
          if (current.index > index) { //prepend
            newNode.next = current;
            head = newNode;
            found = true;
          } else if (current.next == null) { //append
            current.next = newNode;
            found = true;
          } else if (current.index < index && current.next.index > index) { //insert
            newNode.next = current.next;
            current.next = newNode;
            found = true;
          } else {
            if (current.next.index == index) { //change current node
              if (defaultValue.equals(value)) {
                current.next = current.next.next;
              } else {
                current.next.data = value;
                found = true;
              }
            }
            current = current.next;
          }
        }
      }
    }
  }

  private Node<T> prepend(Node<T> node) {
    return null;
  }

  @Override
  public Iterator<T> iterator() {
    return new SparseIndexedListIterator();
  }

  private class SparseIndexedListIterator implements Iterator<T> {
    Node<T> currentNode;
    private int cursor;

    SparseIndexedListIterator() {
      cursor = 0;
      currentNode = head;
    }

    @Override
    public boolean hasNext() {
      return cursor < size;
    }

    @Override
    public T next() throws NoSuchElementException {
      if (!hasNext()) {
        throw new NoSuchElementException();
      } else {
        if (currentNode == null || currentNode.index > cursor) {
          cursor++;
          return defaultValue;
        } else {
          cursor++;
          T returnData = currentNode.data;
          currentNode = currentNode.next;
          return returnData;

        }

      }
    }
  }

  private static class Node<E> {
    private Node<E> next;
    private int index;
    private E data;

    Node(E data, int index) {
      this.data = data;
      this.index = index;
    }
  }
}
