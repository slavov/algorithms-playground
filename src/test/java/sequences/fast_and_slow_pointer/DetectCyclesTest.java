package sequences.fast_and_slow_pointer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DetectCyclesTest {

    private DetectCycles<Integer> instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new DetectCycles();

        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
    }

    @Test
    void DetectCyclesNotFound() {
        var cycle = instance.detectCycle(head);
        assertThat(cycle, nullValue());
    }

    @Test
    void DetectCyclesExists() {
        head.next.next.next.next.next.next = head.next.next;
        var cycle = instance.detectCycle(head);
        assertThat(cycle, is(head.next.next));
    }

    @Test
    void DetectCyclesExists2() {
        head.next.next.next.next.next.next = head.next.next.next;
        var cycle = instance.detectCycle(head);
        assertThat(cycle, is(head.next.next.next));
    }
}
