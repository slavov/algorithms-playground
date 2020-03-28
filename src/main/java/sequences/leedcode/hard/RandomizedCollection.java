package sequences.leedcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 *
 * LeetCode: <a href="https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/">381. Insert Delete GetRandom O(1) - Duplicates allowed</a>
 */
public class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        var isPresent = true;
        if (map.containsKey(val)) {
            isPresent = false;
        }
        map.computeIfAbsent(val, v -> new HashSet<>()).add(list.size());
        list.add(list.size(), val);
        return isPresent;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }

        Set<Integer> idxs = map.get(val);
        var idx = idxs.iterator().next();
        idxs.remove(idx);

        var lastElement = list.get(list.size() - 1);
        list.set(idx, lastElement);

        var lastElmIndexs = map.get(lastElement);
        lastElmIndexs.add(idx);
        lastElmIndexs.remove(list.size() - 1);

        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }
}
