package leetcode.cyclic_sort;

import static leetcode.helpers.Swap.swap;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement # We are given an unsorted array containing numbers taken from the range 1 to
 * ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those
 * missing numbers.
 *
 * <p>Example 1:
 *
 * <p>Input: [2, 3, 1, 8, 2, 3, 5, 1] Output: 4, 6, 7 Explanation: The array should have all numbers
 * from 1 to 8, due to duplicates 4, 6, and 7 are missing. Example 2:
 *
 * <p>Input: [2, 4, 1, 2] Output: 3 Example 3:
 *
 * <p>Input: [2, 3, 2, 1] Output: 4
 *
 * <p>LeetCode: <a
 * href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">448. Find All
 * Numbers Disappeared in an Array</a>
 */
public class FindAllMissingNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
