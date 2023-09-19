package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author : sharch
 * @create 2023/9/14 20:43
 */
public class MinStack {
    private Stack<Long> stack;
    private Stack<Long> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty()){
            minStack.push((long)val);
        }
        long min = minStack.peek();
        if (val <= min) {
            minStack.push((long)val);
        } else {
            minStack.push(min);
        }
        stack.push((long)val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return Integer.parseInt(stack.peek().toString());
    }

    public int getMin() {
        return Integer.parseInt(minStack.peek().toString());
    }
}
