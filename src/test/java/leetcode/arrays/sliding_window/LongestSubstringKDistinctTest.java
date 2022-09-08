package leetcode.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestSubstringKDistinctTest {

    private final LongestSubstringKDistinct instance = new LongestSubstringKDistinct();

    @ParameterizedTest(name = "Longest Substring with maximum {1} Distinct Characters")
    @MethodSource
    void example(String str, int k, int output) {
        var result = instance.findLength(str, k);
        assertEquals(output, result);
    }

    private static Stream<Arguments> example() {
        return Stream.of(
                Arguments.of("araaci", 2, 4),
                Arguments.of("araaci", 1, 2),
                Arguments.of("cbbebi", 3, 5),
                Arguments.of("cbbebi", 10, 6));
    }
}
