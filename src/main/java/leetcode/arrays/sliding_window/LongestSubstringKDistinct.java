package leetcode.arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct
 * characters.
 *
 * <p>Time complexity: O(n) Space complexity: O(k)
 */
class LongestSubstringKDistinct {

    public int findLength(String str, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int l = 0;
        int max = 0;

        for (int r = 0; r < str.length(); r++) {
            charFrequencyMap.put(
                    str.charAt(r), charFrequencyMap.getOrDefault(str.charAt(r), 0) + 1);
            while (charFrequencyMap.size() > k) {
                var c = str.charAt(l);
                charFrequencyMap.put(c, charFrequencyMap.get(c) - 1);
                if (charFrequencyMap.get(c) == 0) {
                    charFrequencyMap.remove(c);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
