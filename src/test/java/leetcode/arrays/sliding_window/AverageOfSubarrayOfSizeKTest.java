package leetcode.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AverageOfSubarrayOfSizeKTest {

    private final AverageOfSubarrayOfSizeK instance = new AverageOfSubarrayOfSizeK();

    @ParameterizedTest(name = "Average of subarray of size {1}")
    @MethodSource
    void example(int k, int[] input) {
        var result = instance.findAverages(k, input);
        assertArrayEquals(new double[] {2.2, 2.8, 2.4, 3.6, 2.8}, result);
    }

    private static Stream<Arguments> example() {
        return Stream.of(Arguments.of(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}));
    }
}
