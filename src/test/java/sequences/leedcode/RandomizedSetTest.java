package sequences.leedcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomizedSetTest {

    private RandomizedSet instance = new RandomizedSet();

    @Test
    void success() {
        assertTrue(instance.insert(1));
        assertFalse(instance.remove(2));
        assertTrue(instance.insert(2));
        assertTrue(instance.remove(1));
        assertFalse(instance.insert(2));
        assertEquals(2, instance.getRandom());
    }

}
