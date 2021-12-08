package sequences.mergeIntervals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class MinimumMeetingRoomsTest {

    private MinimumMeetingRooms instance = new MinimumMeetingRooms();

    @Test
    void testOneOverlap() {
        var input = new int[][] {{1, 4}, {2, 5}, {7, 9}};
        assertThat(instance.minMeetingRooms(input), equalTo(2));
    }

    @Test
    void testNoOverlap() {
        var input = new int[][] {{6, 7}, {2, 4}, {8, 12}};
        assertThat(instance.minMeetingRooms(input), equalTo(1));
    }

    @Test
    void testFewOverlaps() {
        var input = new int[][] {{1, 4}, {2, 3}, {3, 6}};
        assertThat(instance.minMeetingRooms(input), equalTo(2));
    }
}
