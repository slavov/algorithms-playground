package leetcode.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Minimum Meeting Rooms (medium) # Given a list of intervals representing the start and end time of
 * ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 *
 * <p>Example 1:
 *
 * <p>Meetings: [[1,4], [2,5], [7,9]] Output: 2 Explanation: Since [1,4] and [2,5] overlap, we need
 * two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later. Example 2:
 *
 * <p>Meetings: [[6,7], [2,4], [8,12]] Output: 1 Explanation: None of the meetings overlap,
 * therefore we only need one room to hold all meetings. Example 3:
 *
 * <p>Meetings: [[1,4], [2,3], [3,6]] Output:2 Explanation: Since [1,4] overlaps with the other two
 * meetings [2,3] and [3,6], we need two rooms to hold all the meetings.
 *
 * <p>Example 4:
 *
 * <p>Meetings: [[4,5], [2,3], [2,4], [3,5]] Output: 2 Explanation: We will need one room for [2,3]
 * and [3,5], and another room for [2,4] and [4,5].
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/meeting-rooms-ii/">253. Meeting Rooms II</a>
 */
public class MinimumMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(intervals.length, Comparator.comparingInt(i -> i[1]));
        int minRooms = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (minHeap.isEmpty() || intervals[i][0] >= minHeap.peek()[1]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i]);
            minRooms = Math.max(minRooms, minHeap.size());
        }

        return minRooms;
    }
}
