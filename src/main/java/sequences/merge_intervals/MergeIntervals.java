package sequences.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only
 * mutually exclusive intervals.
 *
 * <p>Intervals: [[1,4], [2,5], [7,9]] Output: [[1,5], [7,9]] Explanation: Since the first two
 * intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
 *
 * <p>Intervals: [[6,7], [2,4], [5,9]] Output: [[2,4], [5,9]] Explanation: Since the intervals [6,7]
 * and [5,9] overlap, we merged them into one [5,9].
 *
 * <p>Intervals: [[1,4], [2,6], [3,5]] Output: [[1,6]] Explanation: Since all the given intervals
 * overlap, we merged them into one.
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/merge-intervals/">56. Merge Intervals</a>
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                var max = Math.max(result.get(result.size() - 1)[1], interval[1]);
                result.get(result.size() - 1)[1] = max;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
