package org.example.collections;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyQueue<E> {
    private final static int DEFAULT_CAPACITY = 5;
    private final static int CAPACITY_DIFFERENCE = 10;

    private int front = 0;
    private int rear = -1;
    private int size = 0;
    private Object[] queue = new Object[DEFAULT_CAPACITY];

    public void add(E value) {
        if (size == queue.length) {
            increaseCapacity();
        }
        if (rear == queue.length - 1) {
            rear = -1;
        }
        queue[++rear] = value;
        size++;
    }

    public void remove(Object o) {
        int position = -2;
        for (int i = 0; i <= rear; i++) {
            if (o.equals(queue[i])) {
                queue[i] = null;
                position = i;
                break;
            }
        }
        if (position == -2) {
            System.out.println("Object doesn't match queue values");
            return;
        } else if (position == rear - 1) {
            rear--;
        } else if (position == front) {
            front++;
        } else {
            if (rear - position + 1 >= 0) {
                System.arraycopy(queue, position + 1, queue, position, rear - position);
            }
            rear--;
        }
        size--;
        if (isSizeDecreaseNeeded()) {
            decreaseCapacity();
        }
    }

    public void clear() {
        queue = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return queue[rear];
    }

    public Object poll() {
        if (front >= size) {
            increaseCapacity();
        }
        if (isSizeDecreaseNeeded()) {
            decreaseCapacity();
        }
        Object result = queue[front];
        queue[front++] = null;
        size--;
        return result;
    }

    private void increaseCapacity() {
        queue = Arrays.copyOf(queue, queue.length + 2);
    }

    private void decreaseCapacity() {
        queue = Arrays.copyOf(Arrays.stream(queue).filter(Objects::nonNull).toArray(),
                (int) Arrays.stream(queue).filter(Objects::nonNull).count() + CAPACITY_DIFFERENCE);
        rear = (int) Arrays.stream(queue).filter(Objects::nonNull).count();
        front = 0;
        size = rear;
    }

    private boolean isSizeDecreaseNeeded() {
        return Arrays.stream(queue).filter(Objects::nonNull).count() <
                Arrays.stream(queue).filter(Objects::isNull).count();
    }

    @Override
    public String toString() {
        String show = "";
        for (Object o : Arrays.stream(queue).filter(Objects::nonNull).collect(Collectors.toList())) {
            show += o + " ";
        }
        return show;
    }
}
