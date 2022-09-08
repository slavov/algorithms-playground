package leetcode.leedcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode: <a href="https://leetcode.com/problems/time-based-key-value-store/">981. Time Based
 * Key-Value Store</a>
 */
class TimeMap {

    private Map<String, List<Item>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Item(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        var items = map.get(key);
        int start = 0;
        int end = items.size() - 1;
        String result = "";
        while (start <= end) {
            int pivot = start + (end - start) / 2;
            if (items.get(pivot).t == timestamp) {
                result = items.get(pivot).value;
            }
            if (items.get(pivot).t < timestamp) {
                start = pivot + 1;
                result = items.get(pivot).value;
            } else {
                end = pivot - 1;
            }
        }
        return result;
    }
}

class Item {
    int t;
    String value;

    Item(String value, int t) {
        this.t = t;
        this.value = value;
    }
}
