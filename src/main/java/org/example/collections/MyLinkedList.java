package org.example.collections;

public class MyLinkedList<E> implements List<E> {
    private Node<Object> head;
    private Node<Object> tail;
    private int size = 0;

    @Override
    public void add(E value) {
        Node<Object> node = new Node<>(value);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    @Override
    public Object get(int index) {
        isElementExists(index);
        Node<Object> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public Object remove(int index) {
        isElementExists(index);
        Object removedNode;
        if (index == 0) {
            removedNode = head.data;
            head = head.next;
        } else {
            Node<Object> prev = (Node<Object>) get(index - 1);
            removedNode = prev.data;
            prev.next = prev.next.next;
        }
        size--;
        return removedNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private void isElementExists(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index " + index +
                    " doesn't exists");
    }

    @Override
    public String toString() {
        String show = "";
        Node<Object> current = head;
        if (head == null) {
            return "LinkedList is empty";
        }
        while (current != null) {
            show += current.data + " ";
            current = current.next;
        }
        return show;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }
}