package sequences.leedcode.medium;

import org.junit.jupiter.api.Test;
import sequences.leedcode.medium.FirstUnique;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueTest {

    private FirstUnique solution;

    @Test
    void success() {
        solution = new FirstUnique(new int[]{2, 3, 4});
        assertEquals(2, solution.showFirstUnique());
        solution.add(5);
        assertEquals(2, solution.showFirstUnique());
        solution.add(2);
        assertEquals(3, solution.showFirstUnique());
        solution.add(3);
        assertEquals(4, solution.showFirstUnique());
    }

    @Test
    void caseWhereIhadWrongAnswer() {
        solution = new FirstUnique(new int[]{7, 7, 7, 7, 7, 7});
        assertEquals(-1, solution.showFirstUnique());
        solution.add(7);
        solution.add(3);
        solution.add(3);
        solution.add(7);
        solution.add(17);
        assertEquals(17, solution.showFirstUnique());
    }

    @Test
    void caseWhereIhadWrongAnswer2() {
        solution = new FirstUnique(new int[]{233});
        assertEquals(233, solution.showFirstUnique());
        solution.add(11);
        assertEquals(233, solution.showFirstUnique());
    }

}
