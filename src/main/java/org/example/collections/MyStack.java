package org.example.collections;

import java.util.Arrays;

public class MyStack <E> {
    private final static int DEFAULT_CAPACITY = 5;
    private final static int CAPACITY_DIFFERENCE = 10;

    private Object[] stack = new Object[DEFAULT_CAPACITY];
    private int top = -1;

    public void push(E value) {
        if (top == stack.length - 1) {
            increaseCapacity();
        }
        stack[++top] = value;
    }

    public void remove(Object o) {
        int position = -1;
        for (int i = 0; i <= top; i++) {
            if (o.equals(stack[i])) {
                stack[i] = null;
                position = i;
                break;
            }
        }

        if (position == -1) {
            System.out.println("Object doesn't match queue values");
            return;
        } else if (position == 0) {
            stack = Arrays.copyOfRange(stack, 1, top + 1);
        } else {
            System.arraycopy(stack, position + 1, stack, position, top - position);
        }
        top--;

        if (top == stack.length - CAPACITY_DIFFERENCE - 2) {
            decreaseCapacity();
        }
    }

    public void clear() {
        stack = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public Object peek() {
        return stack[0];
    }

    public Object pop() {
        if (top == -1) {
            return "Stack empty";
        }
        if (top == stack.length - CAPACITY_DIFFERENCE - 2) {
            decreaseCapacity();
        }
        return stack[top--];
    }

    private void increaseCapacity() {
        stack = Arrays.copyOf(stack, stack.length + CAPACITY_DIFFERENCE);
    }

    private void decreaseCapacity() {
        stack = Arrays.copyOf(stack, stack.length - CAPACITY_DIFFERENCE);
        top -= 2;
    }

    @Override
    public String toString() {
        String show = "";
        for (int i = 0; i <= top; i++) {
            show += stack[i] + " ";
        }
        return show;
    }
}