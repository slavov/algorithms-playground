package leetcode.leedcode;

/** https://leetcode.com/problems/maximum-subarray/ */
public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int opt = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            opt = Math.max(opt, sum);
        }
        return opt;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // Explanation: [4,-1,2,1] has the largest sum = 6.
        System.out.println(maxSubArray(nums));
    }
}
