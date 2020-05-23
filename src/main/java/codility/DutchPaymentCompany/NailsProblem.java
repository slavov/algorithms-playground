package codility.DutchPaymentCompany;

/**
 * There are N nails hammered into the same block of wood.
 * Each nail sticks out of the wood at given length.
 * You can choose at most Y nails and hammer them down to any length between their original length and 0.
 * Nails cannot be pulled up.
 * The goal is to have as many nails of the same length as possible.
 * Array is sorted in ascending order. The range of array length is [1 .. 10 000]
 * Element of array is withing a range of [1 .. 1 000 000 000]
 * Y is within a range [0 .. Integer.MAX_VALUE]
 * <p>
 * Example: A = [1, 1, 3, 3, 3, 4, 5, 5, 5, 5], Y = 2
 * Answer: 5. One of the possibilities is to hammer the nails represented by A[8] & A[9] down to length 3.
 */
public class NailsProblem {

    public int solution(int[] a, int y) {
        int sofar = 0;
        int max = 0;
        int prev = a[0];
        for (int i = 0; i < a.length; i++) {
            if (prev == a[i]) {
                sofar++;
            } else {
                int remaining = a.length - i;
                int temp = sofar + potentialNails(remaining, y);
                max = Math.max(temp, max);
                sofar = 1;
            }
            prev = a[i];
        }
        max = Math.max(sofar, max);
        return max;
    }

    private int potentialNails(int len, int y) {
        return Math.min(len, y);
    }
}
