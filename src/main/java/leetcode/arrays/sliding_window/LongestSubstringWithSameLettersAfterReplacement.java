package leetcode.arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’
 * letters with any letter, find the length of the longest substring having the same letters after
 * replacement.
 *
 * <p><a href="https://leetcode.com/problems/longest-repeating-character-replacement/">424. Longest
 * Repeating Character Replacement</a>
 */
class LongestSubstringWithSameLettersAfterReplacement {

    public int findLength(String str, int k) {
        int windowStart = 0;
        int max = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            letterFrequencyMap.put(c, letterFrequencyMap.getOrDefault(c, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(c));

            if (i - windowStart + 1 - maxRepeatLetterCount > k) {
                var charAtStart = str.charAt(windowStart);
                letterFrequencyMap.put(charAtStart, letterFrequencyMap.get(charAtStart) - 1);
                windowStart++;
            }
            max = Math.max(max, i - windowStart + 1);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        var l = 0;
        var max = 0;
        var maxCount = 0; // max of specific letter count
        var charCounts = new int[26]; // keep track how many times letter appears.

        for (int r = 0; r < s.length(); r++) {
            charCounts[s.charAt(r) - 'a']++;
            maxCount = Math.max(maxCount, charCounts[s.charAt(r) - 'a']);

            // r - l - maxCount gives you how many digestive characters.
            // E.g  if (r - l - maxCount + 1 > k) that means that we used all allowed transformation
            while (r - l - maxCount + 1 > k) {
                charCounts[s.charAt(l) - 'a']--;
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
