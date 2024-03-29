package leetcode.cyclic_sort;

import static leetcode.helpers.Swap.swap;

/**
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array
 * has only one duplicate but it can be repeated multiple times. Find that duplicate number without
 * using any extra space. You are, however, allowed to modify the input array.
 *
 * <p>Example 1:
 *
 * <p>Input: [1, 4, 4, 3, 2] Output: 4 Example 2:
 *
 * <p>Input: [2, 1, 3, 3, 5, 4] Output: 3 Example 3:
 *
 * <p>Input: [2, 4, 1, 4, 4] Output: 4
 *
 * <p>LeetCode: <a href="https://leetcode.com/problems/find-the-duplicate-number/">287. Find the
 * Duplicate Number</a>
 */
public class FindDuplicateNumber {

    /** Time complexity O(n) Space complexity O(1) Cyclic sort approach */
    public int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[j] != nums[i]) {
                swap(nums, j, i);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

    /** Time complexity O(n) Space complexity O(1) without modifying array Fast & Slow pointers */
    public int findNumberFastSlow(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (slow < nums.length && fast < nums.length && nums[fast] < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                int slow2 = 0;
                while (slow2 != slow) {
                    slow = nums[slow];
                    slow2 = nums[slow2];
                }
                return slow;
            }
        }
        return -1;
    }
}
