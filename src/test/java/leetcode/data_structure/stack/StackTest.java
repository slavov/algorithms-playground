package leetcode.data_structure.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    public void setup() {
        stack = new Stack<>();
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopOnEmpty() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testPeekOnEmpty() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    public void testPush() {
        stack.push(2);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPeek() {
        stack.push(2);
        assertTrue(stack.peek() == 2);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPop() {
        stack.push(2);
        assertTrue(stack.pop() == 2);
        assertEquals(0, stack.size());
    }

    @Test
    public void testExhaustively() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        assertEquals(2, stack.size());
        assertTrue(stack.peek() == 2);
        assertEquals(2, stack.size());
        assertTrue(stack.pop() == 2);
        assertEquals(1, stack.size());
        assertTrue(stack.peek() == 1);
        assertEquals(1, stack.size());
        assertTrue(stack.pop() == 1);
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
}
