package sequences.arrays.sliding_window;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any
 * contiguous subarray of size ‘k’.
 *
 * <p>Time complexity: O(n) Space complexity: O(1)
 */
class MaximumSumSubarrayOfSizeK {

    int findMaxSumSubArray(int k, int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                max = Math.max(max, sum);
                sum -= arr[i - (k - 1)];
            }
        }
        return max;
    }
}
