package leetcode.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SmallestSubarrayWithGivenSumTest {

    private final SmallestSubarrayWithGivenSum instance = new SmallestSubarrayWithGivenSum();

    @ParameterizedTest(name = "The smallest subarray with a sum greater than or equal to {1}")
    @MethodSource
    void example(int[] arr, int k, int output) {
        var result = instance.findMinSubArray(arr, k);
        assertEquals(output, result);
    }

    private static Stream<Arguments> example() {
        return Stream.of(
                Arguments.of(new int[] {2, 1, 5, 2, 3, 2}, 7, 2),
                Arguments.of(new int[] {2, 1, 5, 2, 8}, 7, 1),
                Arguments.of(new int[] {3, 4, 1, 1, 6}, 8, 3));
    }
}
