package org.example;

import org.example.collections.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("MyArrayList:");
        list.add(2);
        list.add(3);
        list.add(5);
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());

        ////////

        System.out.println("MyLinkedList:");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(6);
        System.out.println(linkedList);
        System.out.println(linkedList.size());

        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.clear();
        System.out.println(linkedList.size());
        System.out.println(linkedList);

        ////////

        MyQueue<Integer> queue = new MyQueue<>();
        System.out.println("MyQueue:");
        queue.add(2);
        queue.add(4);
        queue.add(7);

        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(8);
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(10);
        System.out.println(queue.poll());
        queue.add(11);
        queue.add(12);
        queue.add(16);

        System.out.println(queue.peek());
        System.out.println(queue.size());

        queue.remove(1);
        System.out.println(queue);
        System.out.println(queue);
        queue.add(5);
        System.out.println(queue);
        queue.add(6);
        System.out.println(queue);
        queue.remove(16);
        queue.remove(11);
        queue.remove(6);

        queue.remove(5);
        queue.remove(12);
        queue.add(2);
        queue.add(6);
        queue.add(3);
        System.out.println(queue);

        /////////

        MyStack<Integer> stack = new MyStack<>();
        System.out.println("MyStack:");
        stack.push(5);
        stack.push(7);
        stack.push(10);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.push(5);
        stack.push(6);
        stack.push(10);
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println(stack.size());
        stack.push(10);
        System.out.println(stack);
        stack.push(34);
        System.out.println(stack);
        stack.remove(6);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack.pop());
        stack.push(2);
        System.out.println(stack);

        ////////

        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        System.out.println("MyHashMap:");
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, "5");
        System.out.println(hashMap);
        hashMap.remove(2);
        System.out.println(hashMap);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.size());
        hashMap.clear();
        hashMap.put(10, "10");
        System.out.println(hashMap);
    }
}

//TODO
//Привіт. Навіщо у проекті HelloWorld?

//Фактор збільшення коллекції - краще винести до констант. Зараз це "magic number".

//Константи класу мають бути статичними. (DEFAULT_CAPACITY) Вони не повинні створюватися для кожного екземпляру класу.

//Вертикальне форматування - константи від полів бажано відокремлювати пустою строкою.

//У ArrayList та Stack і Queue розмір масиву збільшується, та ніколи не зменьшується. Для списку то нормально. Для черги та стеку не дуже.