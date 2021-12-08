package sequences.fastAndSlowPointer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiddleOfLinkedListTest {

    private MiddleOfLinkedList<Integer> instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new MiddleOfLinkedList<>();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
    }

    @Test
    void findMiddleOdd() {
        assertThat(instance.middleNode(head), equalTo(head.next.next));
    }

    @Test
    void findMiddleEven() {
        head.next.next.next.next.next = new ListNode<>(6);
        assertThat(instance.middleNode(head), equalTo(head.next.next.next));
    }
}
