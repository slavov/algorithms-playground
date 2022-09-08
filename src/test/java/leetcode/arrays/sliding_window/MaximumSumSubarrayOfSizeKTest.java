package leetcode.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaximumSumSubarrayOfSizeKTest {

    private final MaximumSumSubarrayOfSizeK instance = new MaximumSumSubarrayOfSizeK();

    @ParameterizedTest(name = "Maximum sum subarray of size {1}")
    @MethodSource
    void example(int[] nums, int k, int output) {
        var maxSumSubArray = instance.findMaxSumSubArray(k, nums);
        assertEquals(output, maxSumSubArray);
    }

    private static Stream<Arguments> example() {
        return Stream.of(
                Arguments.of(new int[] {2, 1, 5, 1, 3, 2}, 3, 9),
                Arguments.of(new int[] {2, 3, 4, 1, 5}, 2, 7));
    }
}
