package sequences.prefixSum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RandomPickWithWeightTest {

    @Test
    void test() {
        RandomPickWithWeight randomPickIndex = new RandomPickWithWeight(new int[] {1});
        assertEquals(0, randomPickIndex.pickIndex());
    }
}
