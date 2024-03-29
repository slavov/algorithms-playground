package leetcode.arrays.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string. Anagram is
 * actually a Permutation of a string.
 */
class StringAnagrams {

    List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final var c = str.charAt(windowEnd);

            if (charFrequencyMap.containsKey(c)) {
                charFrequencyMap.put(c, charFrequencyMap.get(c) - 1);
                if (charFrequencyMap.get(c) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) {
                final var c1 = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(c1)) {
                    if (charFrequencyMap.get(c1) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(c1, charFrequencyMap.get(c1) + 1);
                }
            }
        }
        return resultIndices;
    }
}
