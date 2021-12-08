package sequences.arrays.slidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any
 * contiguous subarray of size ‘k’.
 *
 * <p>Time complexity: O(n) Space complexity: O(1)
 */
class MaximumSumSubarrayOfSizeK {

    private static int findMaxSumSubArray(int k, int[] arr) {
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

    public static void main(String[] args) {
        var result = MaximumSumSubarrayOfSizeK.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2});
        System.out.println("Maximum Sum Subarray of Size K  " + result);
    }
}
