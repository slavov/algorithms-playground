package leetcode.arrays.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Given a string, find the length of the longest substring which has no repeating characters. */
class NoRepeatSubstring {

    public int findLength(String str) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int lo = 0;
        int max = 0;

        for (int hi = 0; hi < str.length(); hi++) {
            char c = str.charAt(hi);
            if (charIndexMap.containsKey(c)) {
                lo = Math.max(lo, charIndexMap.get(c) + 1);
            }
            charIndexMap.put(c, hi);
            max = Math.max(max, hi - lo + 1);
        }
        return max;
    }

    public int noRepeatSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        while (r < str.length()) {
            if (!set.contains(str.charAt(r))) {
                set.add(str.charAt(r));
                r++;
            } else {
                set.remove(str.charAt(l));
                l++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
