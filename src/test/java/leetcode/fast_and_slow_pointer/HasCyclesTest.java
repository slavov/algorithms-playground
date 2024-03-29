package leetcode.fast_and_slow_pointer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HasCyclesTest {

    private HasCycles<Integer> instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new HasCycles<>();

        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
    }

    @Test
    void hasCycleNotFound() {
        assertThat(instance.hasCycle(head), equalTo(false));
    }

    @Test
    void hasCycleExists() {
        head.next.next.next.next.next.next = head.next.next;
        assertThat(instance.hasCycle(head), equalTo(true));
    }

    @Test
    void hasCycleExists2() {
        head.next.next.next.next.next.next = head.next.next.next;
        assertThat(instance.hasCycle(head), equalTo(true));
    }
}
