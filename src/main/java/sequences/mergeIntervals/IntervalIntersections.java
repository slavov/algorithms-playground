package sequences.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement # Given two lists of intervals, find the intersection of these two lists. Each
 * list consists of disjoint intervals sorted on their start time.
 *
 * <p>Example 1:
 *
 * <p>Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]] Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists. Example 2:
 *
 * <p>Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]] Output: [5, 7], [9, 10] Explanation: The
 * output list contains the common intervals between the two lists.
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/interval-list-intersections/">986. Interval
 * List Intersections</a>
 */
public class IntervalIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < A.length && j < B.length) {
            // the overlapping interval will be equal to:
            var start = Math.max(A[i][0], B[j][0]);
            var end = Math.min(A[i][1], B[j][1]);

            if (start <= end) {
                result.add(new int[] {start, end});
            }

            // Remove the interval with the smallest end
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
