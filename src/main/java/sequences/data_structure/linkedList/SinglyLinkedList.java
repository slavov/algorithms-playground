package sequences.data_structure.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements Iterable<E> {

    private ListNode<E> head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(E item) {
        head = new ListNode<>(item, head);
        size++;
    }

    public E getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.item;
    }

    public void addLast(E item) {
        if (head == null) addFirst(item);
        else {
            var curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode<>(item, null);
            size++;
        }
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        var curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.item;
    }

    public E get(final int index) {
        checkPositionIndex(index);
        if (head == null) throw new IndexOutOfBoundsException();
        var curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        if (curr == null) throw new IndexOutOfBoundsException();
        return curr.item;
    }

    public void add(int index, E item) {
        checkPositionIndex(index);

        if (index == size) {
            addLast(item);
        } else {
            link(item, node(index));
        }
    }

    public void insertAfter(E item, E newItem) {
        if (isEmpty()) {
            addFirst(newItem);
            return;
        }
        var curr = head;
        while (curr != null && !item.equals(curr.item)) {
            curr = curr.next;
        }
        if (curr != null) {
            curr.next = new ListNode<>(newItem, curr.next);
            size++;
        }
    }

    public void insertBefore(E item, E newItem) {
        if (isEmpty()) {
            addFirst(newItem);
            return;
        }
        ListNode<E> prev = null;
        var curr = head;
        while (curr != null && !item.equals(curr.item)) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            prev.next = new ListNode<>(newItem, curr);
            size++;
        }
    }

    public void delete(E item) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (item.equals(head.item)) {
            head = head.next;
            size--;
            return;
        }
        ListNode<E> prev = null;
        var curr = head;
        while (curr != null && !item.equals(curr.item)) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null && curr != null) {
            prev.next = curr.next;
            size--;
        }
    }

    private ListNode<E> node(int index) {
        var curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private void link(E item, ListNode<E> succ) {
        var newNode = new ListNode<>(item, succ);
        var curr = head;
        while (curr.next != null && curr.next != succ) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public Iterator<E> iterator() {
        return new SinglyListIterator();
    }

    private static class ListNode<T> {

        private T item;
        private ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.item = value;
            this.next = next;
        }
    }

    private class SinglyListIterator implements Iterator<E> {

        private ListNode<E> nextNode;

        public SinglyListIterator() {
            this.nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.nextNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            var item = nextNode.item;
            nextNode = nextNode.next;
            return item;
        }
    }
}
