package sequences.leedcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    private LongestCommonPrefix solution = new LongestCommonPrefix();

    @Test
    void success() {
        assertEquals("fl", solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }

}
