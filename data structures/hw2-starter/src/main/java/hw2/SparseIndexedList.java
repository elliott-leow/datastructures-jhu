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

  private int length;

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
      Node<T> current = head;
      //continue the loop until we reach the end or break if its found
      while (current != null) {
        //found an existing node
        if (current.index == index) {
          return current.data;
        }
        //skipped over the index user wants
        if (current.index > index) {
          break;
        }
        current = current.next;
      }
      return defaultValue;
    }
  }

  @Override
  public void put(int index, T value) throws IndexException {
    checkIndexRange(index);
    Node<T> newNode = new Node<>(value, index);
    Node<T> current = head;
    //check whether the node needs to be prepended
    if (!prepend(index, newNode)) {
      while (current != null && current.index <= index) {
        //current is the last existing node, so the next node must be the new node
        if (current.next == null) {
          current.next = newNode;
          return;
        }
        Node<T> nextNode = modifyNextNode(index, value, current, newNode);
        if (nextNode != null) {
          current.next = nextNode;
        } else if (current.next.index == index) {
          //change next current node data, since the next node's index is the index
          current.next.data = value;
        }
        current = current.next;
      }
    }
  }

  private void checkIndexRange(int index) throws IndexException {
    if (index < 0 || index >= size) {
      throw new IndexException();
    }
  }

  private Node<T> modifyNextNode(int index, T value, Node<T> current, Node<T> newNode) {
    if (current.index < index && current.next.index > index) {
      return insert(newNode, current);
      //skip the next node, since the user wants to set it to the default value (deleting it)
    } else if (defaultValue.equals(value) && current.next.index == index) {
      return current.next.next;
    }
    return null;
  }

  private boolean prepend(int index, Node<T> newNode) {
    //if the list has no nodes currently
    if (head == null) {
      head = newNode;
      return true;
    //if the first node should be modified
    } else if (head.index == index) {
      if (newNode.data.equals(defaultValue)) {
        //delete the node if its equal to the default value
        head = head.next;
      } else {
        head.data = newNode.data;
      }
      return true;
    //if the node needs to be placed before head
    } else if (head.index > index) {
      newNode.next = head;
      head = newNode;
    }
    return false;
  }

  private Node<T> insert(Node<T> newNode, Node<T> current) {
    newNode.next = current.next;
    return newNode;
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
        T returnValue;
        //if the current node index matches the cursor
        if (currentNode != null && currentNode.index == cursor) {
          returnValue = currentNode.data;
          currentNode = currentNode.next;
        //if the current node index is greater than cursor or if it's null
        } else {
          returnValue = defaultValue;
        }
        //no case that current node index be less than cursor
        cursor++;
        return returnValue;
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
