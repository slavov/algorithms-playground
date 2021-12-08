package sequences.leedcode.hard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomizedCollectionTest {

    private RandomizedCollection instance = new RandomizedCollection();

    @Test
    void testCaseOne() {
        assertTrue(instance.insert(4));
        assertTrue(instance.insert(3));
        assertFalse(instance.insert(4));
        assertTrue(instance.insert(2));
        assertFalse(instance.insert(4));
        assertTrue(instance.remove(4));
        assertTrue(instance.remove(3));
        assertTrue(instance.remove(4));
        assertTrue(instance.remove(4));
    }
}
