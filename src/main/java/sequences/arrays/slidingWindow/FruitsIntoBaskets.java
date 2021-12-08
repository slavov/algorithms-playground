package sequences.arrays.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two
 * baskets and your goal is to put maximum number of fruits in each basket. The only restriction is
 * that each basket can have only one type of fruit.
 *
 * <p>Time complexity: O(n) Space complexity: O(1)
 *
 * <p><a href="https://leetcode.com/problems/fruit-into-baskets/">LeetCode: Fruit into baskets</a>
 */
class FruitsIntoBaskets {

    int findLength(char[] arr) {
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        int windowStart = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            fruitFrequencyMap.put(arr[i], fruitFrequencyMap.getOrDefault(arr[i], 0) + 1);
            while (fruitFrequencyMap.size() > 2) { // bigger than 2 because we have 2 baskets
                fruitFrequencyMap.put(
                        arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            max = Math.max(max, i - windowStart + 1);
        }
        return max;
    }

    static int totalFruit(int[] fruits) {
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currentMax = 0;
        int max = 0;

        for (Integer fruit : fruits) {

            if (fruit == lastFruit || fruit == secondLastFruit) {
                currentMax += 1;
            } else {
                currentMax = lastFruitCount + 1;
            }

            if (fruit == lastFruit) {
                lastFruitCount += 1;
            } else {
                lastFruitCount = 1;
            }

            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(currentMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Total fruit (3): " + totalFruit(new int[] {0, 1, 2, 2}));
        System.out.println("Total fruit (5): " + totalFruit(new int[] {1, 2, 3, 2, 2, 2}));
        System.out.println("Total fruit (5): " + totalFruit(new int[] {0, 1, 6, 6, 4, 4, 6}));
        System.out.println(
                "Total fruit (5): " + totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}
