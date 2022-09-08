package leetcode.merge_intervals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class IntervalIntersectionsTest {

    private IntervalIntersections instance = new IntervalIntersections();

    @Test
    void testMerge() {
        int[][] A = {{1, 3}, {5, 6}, {7, 9}};
        int[][] B = {{2, 3}, {5, 7}};

        var result = instance.intervalIntersection(A, B);
        assertArrayEquals(new int[] {2, 3}, result[0]);
        assertArrayEquals(new int[] {5, 6}, result[1]);
        assertArrayEquals(new int[] {7, 7}, result[2]);
    }

    @Test
    void testMergeSec() {
        int[][] A = {{1, 3}, {5, 7}, {9, 12}};
        int[][] B = {{5, 10}};

        var result = instance.intervalIntersection(A, B);
        assertArrayEquals(new int[] {5, 7}, result[0]);
        assertArrayEquals(new int[] {9, 10}, result[1]);
    }
}
