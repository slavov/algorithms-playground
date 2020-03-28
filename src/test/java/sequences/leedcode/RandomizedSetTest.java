package sequences.leedcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomizedSetTest {

    private RandomizedSet instance = new RandomizedSet();

    @Test
    void testCaseOne() {
        assertTrue(instance.insert(1));
        assertFalse(instance.remove(2));
        assertTrue(instance.insert(2));
        assertTrue(instance.remove(1));
        assertFalse(instance.insert(2));
        assertEquals(2, instance.getRandom());
    }

    @Test
    void testCaseTwo() {
        assertTrue(instance.insert(0));
        assertTrue(instance.insert(1));
        assertTrue(instance.remove(0));
        assertTrue(instance.insert(2));
        assertTrue(instance.remove(1));
        assertEquals(2, instance.getRandom());
    }

    @Test
    void testCaseThree() {
        assertFalse(instance.remove(0));
        assertFalse(instance.remove(0));
        assertTrue(instance.insert(0));
        assertTrue(instance.remove(0));
        assertTrue(instance.insert(0));
    }
}
