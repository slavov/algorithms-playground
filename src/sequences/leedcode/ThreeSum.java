package sequences.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //1. sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //avoid duplicates, coz in sorted array we cant have same value for different i
            if (i == 0 || nums[i] > nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                //find all possible combinations if any
                while (start < end) {
                    final int threeSum = nums[i] + nums[start] + nums[end];
                    if (threeSum == 0) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    }
                    //increment
                    if (threeSum < 0) {
                        int currentStart = start;
                        //avoiding duplicates
                        while (nums[start] == nums[currentStart] && start < end) {
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        //avoiding duplicates
                        while (nums[end] == nums[currentEnd] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        final List<List<Integer>> result = threeSum(nums);
        result.forEach(r -> r.forEach(System.out::println));
    }
}
