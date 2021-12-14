package sequences.arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two
 * baskets and your goal is to put maximum number of fruits in each basket. The only restriction is
 * that each basket can have only one type of fruit.
 *
 * <p>First solution is:
 *
 * <p>Time complexity: O(n) Space complexity: O(n). Extra space for the map
 *
 * <p>Second solution is:
 *
 * <p>Time complexity: O(n) Space complexity: O(1)
 *
 * <p><a href="https://leetcode.com/problems/fruit-into-baskets/">LeetCode: Fruit into baskets</a>
 *
 * <p><a href="https://www.youtube.com/watch?v=s_zu2dOkq80">Fruit into baskets by Nick White</a>
 */
class FruitsIntoBaskets {

    int findLength(char[] arr) {
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        int l = 0;
        int max = 0;
        for (int r = 0; r < arr.length; r++) {
            fruitFrequencyMap.put(arr[r], fruitFrequencyMap.getOrDefault(arr[r], 0) + 1);
            while (fruitFrequencyMap.size() > 2) { // bigger than 2 because we have 2 baskets
                fruitFrequencyMap.put(arr[l], fruitFrequencyMap.get(arr[l]) - 1);
                if (fruitFrequencyMap.get(arr[l]) == 0) {
                    fruitFrequencyMap.remove(arr[l]);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    int totalFruit(int[] fruits) {
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
}
