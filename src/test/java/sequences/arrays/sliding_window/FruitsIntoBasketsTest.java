package sequences.arrays.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FruitsIntoBasketsTest {

    private final FruitsIntoBaskets instance = new FruitsIntoBaskets();

    @ParameterizedTest
    @MethodSource
    void exampleWithMap(char[] fruits, int output) {
        assertEquals(output, instance.findLength(fruits));
    }

    @ParameterizedTest
    @MethodSource
    void example(int[] fruits, int output) {
        assertEquals(output, instance.totalFruit(fruits));
    }

    private static Stream<Arguments> example() {
        return Stream.of(
                Arguments.of(new int[] {0, 1, 2, 2}, 3),
                Arguments.of(new int[] {1, 2, 3, 2, 2, 2}, 5),
                Arguments.of(new int[] {0, 1, 6, 6, 4, 4, 6}, 5),
                Arguments.of(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}, 5));
    }

    private static Stream<Arguments> exampleWithMap() {
        return Stream.of(
                Arguments.of(new char[] {'A', 'B', 'C', 'A', 'C'}, 3),
                Arguments.of(new char[] {'A', 'B', 'C', 'B', 'B', 'C'}, 5));
    }
}
