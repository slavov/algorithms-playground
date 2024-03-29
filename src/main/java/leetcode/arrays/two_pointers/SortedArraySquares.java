package leetcode.arrays.two_pointers;

/**
 * Given a sorted array, create a new array containing squares of all the number of the input array
 * in the sorted order.
 *
 * <p>Example 1:
 *
 * <p>Input: [-2, -1, 0, 2, 3] Output: [0, 1, 4, 4, 9] Example 2:
 *
 * <p>Input: [-3, -1, 0, 1, 2] Output: [0 1 1 4 9]
 */
public class SortedArraySquares {

    int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        if (n == 0) return squares;
        int left = 0, right = n - 1, i = n - 1;
        while (left <= right && i >= 0) {
            if (sqr(arr[left]) >= sqr(arr[right])) {
                squares[i] = sqr(arr[left++]);
            } else {
                squares[i] = sqr(arr[right--]);
            }
            i--;
        }
        return squares;
    }

    private int sqr(int num) {
        return num * num;
    }
}
