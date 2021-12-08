package sequences.educative;

import java.util.Arrays;

/**
 * Re-arrange the elements of a sorted array in such a way that the first position will have the
 * largest number, the second will have the smallest, the third will have the second largest, and so
 * on. Input: arr = {1, 2, 3, 4, 5} Output: arr = {5, 1, 4, 2, 3}
 */
public class CheckMaxMin {

    public static void maxMin(int[] arr) {
        int size = arr.length;
        int maxIndex = size - 1;
        int minIndex = 0;
        int maxElement = arr[maxIndex] + 1;

        for (int i = 0; i < size; i++) {
            // at even index : we have to put maximum element
            // at odd index : we have to put minimum element
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }
        for (int i = 0; i < size; i++) {
            arr[i] = arr[i] / maxElement;
        }
    }

    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 4, 5};
        maxMin(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
