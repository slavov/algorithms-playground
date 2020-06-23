package sequences.fastAndSlowPointer;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
       return String.valueOf(val);
    }

}
