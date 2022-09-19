package by.internship.han.task1_3_33;

import java.util.Iterator;

public class Deque<T> implements Iterable<T>, DequeOperations<T> {

    private Node first;
    private Node last;
    private int count;

    private class Node {
        T t;
        Node next;
        Node previous;
    }

    @Override
    public void pushLeft(T t) {
        Node oldFirst = first;
        first = new Node();
        first.t = t;
        first.next = oldFirst;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        count++;
    }

    @Override
    public void pushRight(T t) {
        Node oldLast = last;
        last = new Node();
        last.t = t;
        last.previous = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        count++;
    }

    @Override
    public T popLeft() {
        T t = first.t;
        first = first.next;
        first.previous = null;
        count--;
        return t;
    }

    @Override
    public T popRight() {
        T t = last.t;
        last = last.previous;
        last.next = null;
        count--;
        return t;
    }


    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.next;
            return t;
        }
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();
        System.out.println("Пуст ли дэк? " + deque.isEmpty());

        deque.pushLeft(5);
        deque.pushRight(3);
        deque.pushRight(8);
        deque.pushLeft(11);

        System.out.println("Очередь: ");
        deque.forEach(System.out::println);

        Integer deleteRight = deque.popRight();
        Integer deleteLeft = deque.popLeft();

        System.out.println("Очередь после преобразований: ");
        deque.forEach(System.out::println);

        System.out.println("Размерность после преобразований: " + deque.size());
        System.out.println("Удаленный правый элемент: " + deleteRight + ", Удаленный левый элемент: " + deleteLeft);

        System.out.println("Пуст ли дэк? " + deque.isEmpty());
    }
}
