package sequences.leedcode;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for(char c: s.toCharArray()) {
            chars[c - 'a']++;
        }
        for(char c: t.toCharArray()) {
            chars[c - 'a']--;
        }
        for (int aChar : chars) {
            if (aChar != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
