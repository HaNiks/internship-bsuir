package by.internship.han.task1_3_33;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Deque<Item> implements Iterable<Item>, DequeOperations {

    private Node first;
    private Node last;
    private int count;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public void pushLeft(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.previous = null;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        count++;
    }

    public void pushRight(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        count++;
    }

    public Item popLeft() {
        Item item = first.item;
        first = first.next;
        count--;
        return item;
    }

    public Item popRight() {
        Item item = last.item;
        last = last.previous;
        last.next = null;
        count--;
        return item;
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
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
            Iterator.super.forEachRemaining(action);
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
