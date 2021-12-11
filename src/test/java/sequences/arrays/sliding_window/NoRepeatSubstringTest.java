package sequences.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NoRepeatSubstringTest {

    private final NoRepeatSubstring instance = new NoRepeatSubstring();

    @ParameterizedTest
    @ValueSource(strings = {"aabccbb", "abbbb", "abccde", "aaabbabccbb"})
    void examples(String string) {
        assertEquals(instance.noRepeatSubstring(string), instance.findLength(string));
    }
}
