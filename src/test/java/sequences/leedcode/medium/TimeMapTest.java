package sequences.leedcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeMapTest {

    private TimeMap timeMap;

    @BeforeEach
    void setUp() {
        timeMap = new TimeMap();
    }

    @Test
    void success() {
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
    }

    @Test
    void success2() {
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        assertEquals("", timeMap.get("love", 5));
        assertEquals("high", timeMap.get("love", 10));
        assertEquals("high", timeMap.get("love", 10));
        assertEquals("low", timeMap.get("love", 20));
        assertEquals("low", timeMap.get("love", 25));
    }
}
