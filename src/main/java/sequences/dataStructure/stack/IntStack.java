package sequences.dataStructure.stack;

import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A linked list implementation of a stack
 * @param <T>  the type of elements
 */
public class IntStack<T> implements Iterable<T> {

    private Deque<T> list = new LinkedList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void push(T value) {
        list.addLast(value);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.peekLast();
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
