package org.example.collections;

public interface List<E> {
    void add(E value);
    Object get(int index);
    Object remove(int index);
    int size();
    void clear();
}
