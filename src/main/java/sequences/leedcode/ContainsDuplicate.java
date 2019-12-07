package sequences.leedcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Set<Integer> s = new HashSet<>(nums.length);
        for (int n : nums) {
            if (s.contains(n)) return true;
            s.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
