package by.internship.han.task1_3_33;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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
        first.previous = null;
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
        last.next = null;
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

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
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

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Iterator.super.forEachRemaining(action);
        }
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();
        System.out.println("???????? ???? ??????? " + deque.isEmpty());

        deque.pushLeft(5);
        deque.pushRight(3);
        deque.pushRight(8);
        deque.pushLeft(11);

        System.out.println("??????????????: ");
        deque.forEach(System.out::println);

        Integer deleteRight = deque.popRight();
        Integer deleteLeft = deque.popLeft();

        System.out.println("?????????????? ?????????? ????????????????????????????: ");
        deque.forEach(System.out::println);

        System.out.println("?????????????????????? ?????????? ????????????????????????????: " + deque.size());
        System.out.println("?????????????????? ???????????? ??????????????: " + deleteRight + ", ?????????????????? ?????????? ??????????????: " + deleteLeft);

        System.out.println("???????? ???? ??????? " + deque.isEmpty());
    }
}
