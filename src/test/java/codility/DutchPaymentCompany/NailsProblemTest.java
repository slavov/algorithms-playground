package codility.DutchPaymentCompany;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NailsProblemTest {

    private NailsProblem problem = new NailsProblem();

    @Test
    void testCase() {
        assertEquals(5, problem.solution(new int[] {1, 1, 3, 3, 3, 4, 5, 5, 5, 5}, 2));
        assertEquals(5, problem.solution(new int[] {1, 1, 3, 3, 3, 4, 5, 5, 5, 5, 5, 5}, 2));
        assertEquals(6, problem.solution(new int[] {1, 1, 3, 3, 5, 5, 5, 5, 5, 5}, 2));
        assertEquals(6, problem.solution(new int[] {1, 1, 3, 3, 3, 4, 5, 5, 5, 5, 5, 6}, 2));
        assertEquals(7, problem.solution(new int[] {1, 1, 3, 3, 3, 3, 4, 5, 5, 5, 5, 5, 6}, 3));
        assertEquals(4, problem.solution(new int[] {1, 2, 2, 3}, 3));
    }
}
