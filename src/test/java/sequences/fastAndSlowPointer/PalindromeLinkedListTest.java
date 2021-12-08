package sequences.fastAndSlowPointer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromeLinkedListTest {
    private PalindromeLinkedList instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new PalindromeLinkedList();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(1);
    }

    @Test
    void testPalindromeSuccess() {
        boolean result = instance.isPalindrome(head);
        assertThat(result, equalTo(true));
    }

    @Test
    void testPalindromeFalse() {
        head.next.next.next.next = new ListNode<>(11);
        boolean result = instance.isPalindrome(head);
        assertThat(result, equalTo(false));
    }

    @Test
    void testPalindromeFalse2() {
        head = new ListNode<>(1);
        head.next = new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(1);
        boolean result = instance.isPalindrome(head);
        assertThat(result, equalTo(false));
    }
}
