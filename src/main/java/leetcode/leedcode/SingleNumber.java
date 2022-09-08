package leetcode.leedcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/single-number/ */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        if (nums.length <= 0) return -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2, 2, 1}));
        System.out.println(singleNumber(new int[] {4, 1, 2, 1, 2}));

        int[][] intervals = {{9, 2, 6}, {4, 8, 1}};
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    }
}
