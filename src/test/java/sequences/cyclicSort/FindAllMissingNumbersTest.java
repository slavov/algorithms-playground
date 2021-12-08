package sequences.cyclicSort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.junit.jupiter.api.Test;

class FindAllMissingNumbersTest {

    private FindAllMissingNumbers instance = new FindAllMissingNumbers();

    @Test
    void findNumber() {
        var numbers = instance.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1});
        assertThat(numbers, contains(5, 6));
    }
}
