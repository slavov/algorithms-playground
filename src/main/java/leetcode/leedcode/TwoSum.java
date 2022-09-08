package leetcode.leedcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/two-sum/ */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int r = target - nums[i];
            if (map.containsKey(r)) {
                return new int[] {map.get(r), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        final int[] nums = {2, 7, 11, 15};
        final int[] result = twoSum(nums, 9);
        Arrays.stream(result).forEach(System.out::print);
    }
}
