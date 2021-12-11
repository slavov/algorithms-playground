package sequences.cyclic_sort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class FindDuplicateNumberTest {

    private FindDuplicateNumber instance = new FindDuplicateNumber();

    @Test
    void testFind() {
        assertThat(instance.findNumber(new int[] {1, 4, 4, 3, 2}), equalTo(4));
    }

    @Test
    void testFindAll() {
        assertThat(instance.findNumberFastSlow(new int[] {1, 4, 4, 3, 2}), equalTo(4));
    }
}
