package codility.DutchBankingPlatform;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> result = new HashMap<>();
        if (visits == null) {
            return result;
        }

        Arrays.stream(visits)
                .filter(Objects::nonNull)
                .forEach(
                        visit ->
                                visit.forEach(
                                        (key, userStats) -> {
                                            if (!isNumber(key)) {
                                                return;
                                            }
                                            Long newKey = Long.valueOf(key);
                                            if (userStats == null) {
                                                return;
                                            }
                                            if (!userStats.getVisitCount().isPresent()) {
                                                return;
                                            }
                                            if (result.get(newKey) != null) {
                                                Long value = result.get(newKey);
                                                result.put(
                                                        newKey,
                                                        userStats.getVisitCount().get() + value);
                                            } else {
                                                result.put(newKey, userStats.getVisitCount().get());
                                            }
                                        }));

        return result;
    }

    private boolean isNumber(String value) {
        if (value == null) {
            return false;
        }
        try {
            Long.parseLong(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
