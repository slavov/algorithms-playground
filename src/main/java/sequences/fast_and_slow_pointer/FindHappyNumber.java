package sequences.fast_and_slow_pointer;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to
 * the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers
 * will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include
 * ‘1’.
 *
 * <p>Input: 23 Output: true (23 is a happy number)
 *
 * <p>Input: 12 Output: false (12 is not a happy number) LeetCode: <a
 * href="https://leetcode.com/problems/happy-number/submissions/">202. Happy Number</a>
 */
public class FindHappyNumber {

    /** Time complexity O(logN) Space complexity O(1) */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squaresSum(slow);
            fast = squaresSum(squaresSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int squaresSum(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n /= 10;
        }
        return sum;
    }
}
