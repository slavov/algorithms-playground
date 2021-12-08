package codility.DutchPaymentCompany.transStack;

import java.util.Stack;

/**
 * Implement a stack data structure. The data structure will hold positive integers within the range
 * [1..1 000 000 000] and should implement stack operations: 1. push(value). Pushes an element value
 * to the stack 2. top(). Returns the topmost element (without removing it from the stack), or 0 ifs
 * the stack is empty. 3. pop(). Removes the topmost element from the stack, or does nothing if the
 * stack is empty.
 *
 * <p>In addition to the above operations, the stack should also support transactions by
 * implementing the following operations: 1. begin(). Opens a new transaction block. Transaction
 * blocks can be nested. Can be issued inside another existing block. Note that no transaction is in
 * progress before the first begin() call. 2. rollback(). Undoes every stack operation issued in the
 * current transaction block, and closes the block. Return true if successful or false if no
 * transaction is in progress. 3. commit(). Applies every stack operation issued in the current
 * transaction block, and closes the block. Returns true if successful or false if no transaction is
 * in progress.
 *
 * <p>Example 1: TransactionalStack obj1 = new TransactionalStack(); obj1.push(4) //stack: [4]
 * obj1.push(7) // stack: [4,7] obj1.top() // 7 obj1.pop() // stack: [4] obj1.top() // 4
 *
 * <p>Example 2: TransactionalStack obj = new TransactionalStack(); obj.push(4); obj.begin();
 * //start transaction 1 obj.push(7); // stack: [4,7] obj.begin(); // start transaction 2
 * obj.push(3); // stack: [4,7,3] obj.rollback(); // returns true; rollbacks transaction 2
 * obj.top(); //returns 7. stack: [4,7] obj.begin(); // start transaction 3 obj.push(8); // stack:
 * [4,7,8] obj.commit(); // returns true; commits transaction 3 obj.top(); // returns 8;
 * obj.rollback(); // returns true. rollbacks transaction 1; obj.top(); // returns 4. stack: [4]
 * obj.commit(); // returns false;
 */
public class TransactionalStack {

    private Stack<Integer> data;
    private Stack<TransactionalStack> transactions;

    public TransactionalStack() {
        this.data = new Stack<>();
        transactions = new Stack<>();
    }

    public void push(Integer value) {
        if (transactions.isEmpty()) {
            data.push(value);
            return;
        }
        transactions.peek().data.push(value);
    }

    public Integer top() {
        if (transactions.isEmpty()) {
            return data.peek();
        }
        return transactions.peek().data.peek();
    }

    public Integer pop() {
        if (transactions.isEmpty()) {
            return data.pop();
        }
        return transactions.peek().data.pop();
    }

    public void begin() {
        var latest = new TransactionalStack();
        if (transactions.isEmpty()) {
            latest.data = (Stack<Integer>) this.data.clone();
        } else {
            latest.data = (Stack<Integer>) transactions.peek().data.clone();
        }
        transactions.push(latest);
    }

    public boolean rollback() {
        if (transactions.isEmpty()) {
            return false;
        }
        transactions.pop();
        return true;
    }

    public boolean commit() {
        if (transactions.isEmpty()) {
            return false;
        }
        var last = transactions.pop();
        if (transactions.isEmpty()) {
            data = last.data;
            return true;
        }
        transactions.peek().data = last.data;
        return true;
    }
}
