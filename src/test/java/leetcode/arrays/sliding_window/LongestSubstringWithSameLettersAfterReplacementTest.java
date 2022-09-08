package leetcode.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestSubstringWithSameLettersAfterReplacementTest {

    private final LongestSubstringWithSameLettersAfterReplacement instance =
            new LongestSubstringWithSameLettersAfterReplacement();

    @Test
    void example1() {
        assertEquals(
            instance.characterReplacement("aabccbb", 2),
            instance.findLength("aabccbb", 2)
        );
    }

    @Test
    void example2() {
        assertEquals(
            instance.characterReplacement("abbcb", 1),
            instance.findLength("abbcb", 1)
        );
    }

    @Test
    void example3() {
        assertEquals(
            instance.characterReplacement("abccde", 1),
            instance.findLength("abccde", 1)
        );
    }
}
