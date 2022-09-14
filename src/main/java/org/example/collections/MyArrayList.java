package org.example.collections;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> implements List<E> {
    private final static int DEFAULT_CAPACITY = 5;

    private int size = 0;
    private Object[] elements = new Object[DEFAULT_CAPACITY];

    @Override
    public void add(E value) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = value;
    }

    public Object remove(int index) {
        Objects.checkIndex(index, size);
        Object removedElement = elements[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        }
        size--;
        return removedElement;
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        Objects.checkIndex(index, size);
        return elements[index];
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @Override
    public String toString() {
        String show = "";
        for (int i = 0; i < size; i++) {
            show += elements[i] + " ";
        }
        return show;
    }
}
