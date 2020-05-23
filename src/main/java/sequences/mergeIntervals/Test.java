package sequences.mergeIntervals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("love", 2);
        map.put("coding", 1);
        map.put("i", 2);
        map.put("leetcode", 1);

        Queue<String> pq = new PriorityQueue<>((w1, w2) ->
            map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));

        for (String word : map.keySet()) {
            pq.add(word);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
