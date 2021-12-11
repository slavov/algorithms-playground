package sequences.merge_intervals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MergeIntervalsTest {
    private MergeIntervals instance = new MergeIntervals();

    @Test
    void testSortedMerged() {
        int[][] intervals = {{1, 4}, {2, 5}, {7, 9}};
        var result = instance.merge(intervals);
        assertArrayEquals(new int[] {1, 5}, result[0]);
        assertArrayEquals(new int[] {7, 9}, result[1]);
    }

    @Test
    void testUnsortedMerged() {
        int[][] intervals = {{6, 7}, {2, 4}, {5, 9}};
        var result = instance.merge(intervals);
        assertArrayEquals(new int[] {2, 4}, result[0]);
        assertArrayEquals(new int[] {5, 9}, result[1]);
    }

    @Test
    void testAllMerged() {
        int[][] intervals = {{1, 4}, {2, 6}, {3, 5}};
        var result = instance.merge(intervals);
        assertArrayEquals(new int[] {1, 6}, result[0]);
    }
}
