package codility.DutchPaymentCompany.transStack;

import java.util.LinkedList;

public class EsStack {

    private LinkedList<Event> events = new LinkedList<>();

    public void push(Integer value) {
        events.add(Event.num(value));
    }

    public int top() {
        return popTop(false);
    }

    public int pop() {
        return popTop(true);
    }

    public void begin() {
        events.add(Event.trans());
    }

    public boolean rollback() {
        return submit(true);
    }

    public boolean commit() {
        return submit(false);
    }

    private int popTop(boolean remove) {
        var iter = events.descendingIterator();
        while (iter.hasNext()) {
            var curr = iter.next();
            if (!curr.trans) {
                if (remove) {
                    iter.remove();
                }
                return curr.num;
            }
        }
        return 0;
    }

    private boolean submit(boolean rollback) {
        if (events.stream().anyMatch(e -> e.trans)) {
            var iter = events.descendingIterator();
            while (iter.hasNext()) {
                var curr = iter.next();
                if (curr.trans) {
                    iter.remove();
                    return true;
                }
                if (rollback) {
                    iter.remove();
                }
            }
        }
        return false;
    }
}

class Event {
    int num;
    boolean trans;

    Event(int n, boolean t) {
        num = n;
        trans = t;
    }

    static Event num(int n) {
        return new Event(n, false);
    }

    static Event trans() {
        return new Event(0, true);
    }
}
