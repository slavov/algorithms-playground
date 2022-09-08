package leetcode.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestSubarrayWithOnesAfterReplacementTest {

    private final LongestSubarrayWithOnesAfterReplacement instance =
            new LongestSubarrayWithOnesAfterReplacement();

    @ParameterizedTest(name = "Longest subarray with ones after {1} replacement")
    @MethodSource("providedInput")
    void example(int[] input, int k) {
        assertEquals(instance.findLength(input, k), instance.longestOnes(input, k));
    }

    private static Stream<Arguments> providedInput() {
        return Stream.of(
                Arguments.of(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2),
                Arguments.of(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3),
                Arguments.of(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2),
                Arguments.of(
                        new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
