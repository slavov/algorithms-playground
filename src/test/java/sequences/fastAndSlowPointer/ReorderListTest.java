package sequences.fastAndSlowPointer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReorderListTest {

    private ReorderList<Integer> instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new ReorderList<>();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
    }

    @Test
    void reorderEven() {
        instance.reorderList(head);
        assertThat(head.toString(), equalTo("1,6,2,5,3,4"));
    }

    @Test
    void reorderOdd() {
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        instance.reorderList(head);
        assertThat(head.toString(), equalTo("1,5,2,4,3"));
    }
}
