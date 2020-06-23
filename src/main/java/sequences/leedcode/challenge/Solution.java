package sequences.leedcode.challenge;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1) return num;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
