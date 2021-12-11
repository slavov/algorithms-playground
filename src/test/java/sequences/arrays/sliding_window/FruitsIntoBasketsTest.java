package sequences.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FruitsIntoBasketsTest {

    private final FruitsIntoBaskets instance = new FruitsIntoBaskets();

    @Test
    void exampleWithMap1() {
        assertEquals(3, instance.findLength(new char[] {'A', 'B', 'C', 'A', 'C'}));
    }

    @Test
    void exampleWithMap2() {
        assertEquals(5, instance.findLength(new char[] {'A', 'B', 'C', 'B', 'B', 'C'}));
    }

    @Test
    void example1() {
        assertEquals(3, instance.totalFruit(new int[] {0, 1, 2, 2}));
    }

    @Test
    void example2() {
        assertEquals(5, instance.totalFruit(new int[] {1, 2, 3, 2, 2, 2}));
    }

    @Test
    void example3() {
        assertEquals(5, instance.totalFruit(new int[] {0, 1, 6, 6, 4, 4, 6}));
    }

    @Test
    void example4() {
        assertEquals(5, instance.totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}
