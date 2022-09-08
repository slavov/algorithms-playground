package leetcode.leedcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {

    private LongestCommonPrefix solution = new LongestCommonPrefix();

    @Test
    void success() {
        assertEquals("fl", solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }
}
