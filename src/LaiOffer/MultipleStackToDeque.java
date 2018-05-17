package LaiOffer;

import java.util.*;

public class MultipleStackToDeque {

    Deque<Integer> stack1 = new LinkedList<>();
    Deque<Integer> stack2 = new LinkedList<>();
    Deque<Integer> stack3 = new LinkedList<>();

    public MultipleStackToDeque(Deque<Integer> stack1, Deque<Integer> stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    public void leftAdd(int val) {
        stack1.offer(val);
    }

    public void rightAdd(int val) {
        stack2.offer(val);
    }

    public int leftRemove() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack1.isEmpty()) {
            shuffle();
        }
        return stack1.pop();
    }

    public int rightRemove() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            shuffle();
        }
        return stack2.pop();
    }

    private void shuffle() {
        Deque<Integer> nonEmptyStack = stack1;
        Deque<Integer> emptyStack = stack2;
        if (stack1.isEmpty()) {
            nonEmptyStack = stack2;
            emptyStack = stack1;
        }
        for (int i = 0; i < nonEmptyStack.size() / 2 ; i++) {
            stack3.offer(nonEmptyStack.poll());
        }
        while (!stack3.isEmpty()) {
            emptyStack.offer(stack3.pop());
        }
    }
}
