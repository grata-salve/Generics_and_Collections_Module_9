package org.example.collections;

import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Objects;

import static java.util.Objects.hash;

public class MyHashMap<K, V> {
    private int capacity = 100;
    @SuppressWarnings("unchecked")
    private Entry<K, V>[] table = new Entry[capacity];

    public void put(K newKey, V data) {
        if (capacity + 10 >= table.length) {
            increaseCapacity();
        }

        if (newKey == null) {
            return;
        }

        int hash = hash(newKey);
        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    newEntry.next = current.next;
                    if (previous == null) {
                        table[hash] = newEntry;
                    } else {
                        previous.next = newEntry;
                    }
                    return;
                }
                previous = current;
                current = current.next;
            }
            Objects.requireNonNull(previous).next = newEntry;
        }
    }

    public void remove(K deleteKey) {
        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                    } else {
                        previous.next = current.next;
                    }
                    return;
                }
                previous = current;
                current = current.next;
            }
        }

    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] != null) {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        table = new Entry[capacity];
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                size++;
            }
        }
        return size;
    }

    private void increaseCapacity() {
        table = Arrays.copyOf(table, table.length * 5);
    }

    @Override
    public String toString() {
        String show = "";
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> newEntry = table[i];
                while (newEntry != null) {
                    show += "{" + newEntry.key + "=" + newEntry.value + "}" + " ";
                    newEntry = newEntry.next;
                }
            }

        }
        return show;
    }

    static class Entry<K, V> {
        @NotNull
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}