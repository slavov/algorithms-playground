package sequences.leedcode.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
