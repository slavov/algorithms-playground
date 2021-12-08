package sequences.leedcode;

import java.util.Arrays;

/** https://leetcode.com/problems/product-of-array-except-self/ */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];

        result[0] = 1;
        for (int i = 1; i < size; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = right * result[i];
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        final int[] result = productExceptSelf(nums);
        Arrays.stream(result).forEach(System.out::println);
    }
}
