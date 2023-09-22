package starter;

import exceptions.IndexException;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO some of the sanity checks are convoluted and need to be refactored!
public class LinkedList<T> implements Iterable<T> {
  private Node<T> head;
  private int numElements;

  public LinkedList() {
    head = null;
    numElements = 0;
  }

  public void addFirst(T t) {
    Node<T> tmp = new Node<>(t);
    tmp.next = head;
    head = tmp;
    numElements++;
    // TODO Implement me!
  }

  public void addLast(T t) {
    //if list is empty
    if (head == null) {
      addFirst(t);
    } else {
      //find the last node in the list
      Node<T> last = head;
      while (last.next != null) {
        last = last.next;
      }


      //create a new node and attach it to end of list
      last.next = new Node<>(t);
      numElements++;
    }

  }

  public void traverse() {
    Node<T> current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }

    for (Node<T> tmp = head; tmp != null; tmp = tmp.next) {
      System.out.println(tmp.data);
    }
  }

  public T get(int index) throws IndexException {
    if (index < 0 || index >= numElements) {
      throw new IndexException();
    } else {
      Node<T> target = head; //begin at front of list
      for (int i = 0; i < index; i++) {
        target = target.next; //advance reference index number of times
      }
      return target.data; // return data stored at reference
    }

  }


  public void insert(int index, T t) throws IndexException {
    if (index < 0 || index >= numElements) {
      throw new IndexException();
    } else if (index == 0) {
      addFirst(t);
    } else {
      Node<T> target = head;
      for (int i = 0; i < index - 1; i++) {
        target = target.next;
      }
      Node<T> newNode = new Node<>(t);
      newNode.next = target.next;
      target.next = newNode;
      numElements++;
    }

  }

  public void delete(int index) throws IndexException {
    if (index < 0 || index >= numElements) {
      throw new IndexException();
    } else if (index == 0) {
      head = head.next; //bypass first element (element at index 0)
      numElements--;
    } else {
      Node<T> target = head;

      //find node before index
      for (int i = 0; i < index - 1; i++) {
        target = target.next;
      }

      //bypass node at given index
      target.next = target.next.next;
      numElements--;
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  public int length() {
    return numElements;
  }

  private static class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
      this.data = data;
    }
  }

  private class LinkedListIterator implements Iterator<T> {

    private Node<T> current;

    public LinkedListIterator() {
      current = head;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Node<T> tmp = current; // hold on to current position to be able to return value
      current = current.next; //advance current to next node
      return tmp.data; //return the held data
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }
  }

}
