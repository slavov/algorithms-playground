package codility.DutchPaymentCompany.transStack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TransactionalStackTest {

    @Test
    void useCaseOne() {
        TransactionalStack obj = new TransactionalStack();
        obj.push(4);
        obj.begin(); // start transaction 1
        obj.push(7); // stack: [4,7]
        obj.begin(); // start transaction 2
        obj.push(3); // stack: [4,7,3]
        assertTrue(obj.rollback()); // returns true; rollbacks transaction 2
        assertEquals(7, obj.top()); // returns 7. stack: [4,7]
        obj.begin(); // start transaction 3
        obj.push(8); // stack: [4,7,8]
        assertTrue(obj.commit()); // returns true; commits transaction 3
        assertEquals(8, obj.top()); // returns 8;
        assertTrue(obj.rollback()); // returns true. rollbacks transaction 1;
        assertEquals(4, obj.top()); // returns 4. stack: [4]
        assertFalse(obj.commit()); // returns false;
    }

    @Test
    void useCaseTwo() {
        TransactionalStack obj = new TransactionalStack();
        obj.push(2);
        obj.begin();
        obj.push(3);
        assertTrue(obj.commit());
        assertEquals(3, obj.top());
    }
}
