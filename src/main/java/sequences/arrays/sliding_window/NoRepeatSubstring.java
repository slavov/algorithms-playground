package sequences.arrays.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Given a string, find the length of the longest substring which has no repeating characters. */
class NoRepeatSubstring {

    static int findLength(String str) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int lo = 0, max = 0;

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

    static int noRepeatSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        while (end < str.length()) {
            if (!set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
                end++;
            } else {
                set.remove(str.charAt(start));
                start++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        var result = NoRepeatSubstring.findLength("aaabbabccbb");
        System.out.println("longest substring which has no repeating characters " + result);

        System.out.println(
                "longest substring which has no repeating characters "
                        + noRepeatSubstring("aaabbabccbb"));
    }
}
