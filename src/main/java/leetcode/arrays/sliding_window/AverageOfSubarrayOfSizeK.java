package leetcode.arrays.sliding_window;

class AverageOfSubarrayOfSizeK {

    public double[] findAverages(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of
            // 'k'
            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return result;
    }
}
