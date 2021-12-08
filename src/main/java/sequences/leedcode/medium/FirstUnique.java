package sequences.leedcode.medium;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * <p>Implement the FirstUnique class:
 *
 * <p>FirstUnique(int[] nums) Initializes the object with the numbers in the queue. int
 * showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if
 * there is no such integer. void add(int value) insert value to the queue.
 *
 * <p>LeetCode Premium: <a href="https://leetcode.com/problems/first-unique-number/">1429. First
 * Unique Number</a>
 */
class FirstUnique {

    LinkedHashSet<Integer> unique = new LinkedHashSet<>();
    Set<Integer> set = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            if (unique.contains(num)) {
                unique.remove(num);
                continue;
            }
            if (!set.contains(num)) {
                unique.add(num);
                set.add(num);
            }
        }
    }

    public int showFirstUnique() {
        if (unique.isEmpty()) {
            return -1;
        }
        return unique.iterator().next();
    }

    public void add(int value) {
        if (unique.contains(value)) {
            unique.remove(value);
            return;
        }
        if (!set.contains(value)) {
            unique.add(value);
            set.add(value);
        }
    }
}
