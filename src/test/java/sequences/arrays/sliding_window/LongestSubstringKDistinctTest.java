package sequences.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestSubstringKDistinctTest {

    private final LongestSubstringKDistinct instance = new LongestSubstringKDistinct();

    @Test
    void example1() {
        var result = instance.findLength("araaci", 2);
        assertEquals(4, result);
    }

    @Test
    void example2() {
        var result = instance.findLength("araaci", 1);
        assertEquals(2, result);
    }

    @Test
    void example3() {
        var result = instance.findLength("cbbebi", 3);
        assertEquals(5, result);
    }

    @Test
    void example4() {
        var result = instance.findLength("cbbebi", 10);
        assertEquals(6, result);
    }
}
