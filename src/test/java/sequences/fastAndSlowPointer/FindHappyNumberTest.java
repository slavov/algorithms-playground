package sequences.fastAndSlowPointer;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindHappyNumberTest {

    private FindHappyNumber instance = new FindHappyNumber();

    @Test
    void findSuccess() {
        assertThat(instance.isHappy(23), equalTo(true));
    }

    @Test
    void findNotHappy() {
        assertThat(instance.isHappy(12), equalTo(false));
    }

}
