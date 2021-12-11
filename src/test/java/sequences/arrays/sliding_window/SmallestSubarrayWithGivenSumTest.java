package sequences.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SmallestSubarrayWithGivenSumTest {

    private final SmallestSubarrayWithGivenSum instance = new SmallestSubarrayWithGivenSum();

    @Test
    void example1() {
        var result = instance.findMinSubArray(new int[] {2, 1, 5, 2, 3, 2}, 7);
        assertEquals(2, result);
    }

    @Test
    void example2() {
        var result = instance.findMinSubArray(new int[] {2, 1, 5, 2, 8}, 7);
        assertEquals(1, result);
    }

    @Test
    void example3() {
        var result = instance.findMinSubArray(new int[] {3, 4, 1, 1, 6}, 8);
        assertEquals(3, result);
    }
}
