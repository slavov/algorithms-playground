package sequences.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/insert-interval/">57. Insert Interval</a>
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        // add all intervals starting before newInterval
        int i = 0;
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // add newInterval
        if (result.isEmpty() || result.get(result.size() - 1)[1] < newInterval[0]) {
            // if there is no overlap, just add the interval
            result.add(newInterval);
        } else {
            // if there is an overlap, merge with the last interval
            var max = Math.max(result.get(result.size() - 1)[1], newInterval[1]);
            result.get(result.size() - 1)[1] = max;
        }

        // add next intervals, merge with newInterval if needed
        while (i < intervals.length) {
            var interval = intervals[i++];
            if (result.get(result.size() - 1)[1] < interval[0]) {
                // if there is no overlap, just add an interval
                result.add(interval);
            } else {
                // if there is an overlap, merge with the last interval
                var max = Math.max(result.get(result.size() - 1)[1], interval[1]);
                result.get(result.size() - 1)[1] = max;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
