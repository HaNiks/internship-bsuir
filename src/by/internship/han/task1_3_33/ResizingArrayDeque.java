package by.internship.han.task1_3_33;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizingArrayDeque<T> implements Iterable<T>, DequeOperations<T> {
    private T[] elements;

    public ResizingArrayDeque() {
        elements = (T[]) new Object[0];
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public int size() {
        return elements.length;
    }

    public void pushLeft(T t) {
        if (t == null) {
            throw new NullPointerException();
        } else {
            elements = getNewArr(elements, 1);
            elements[0] = t;
        }
    }

    public void pushRight(T t) {
        if (t == null) {
            throw new NullPointerException();
        } else {
            elements = getNewArr(elements, 0);
            elements[elements.length - 1] = t;
        }
    }

    public T popLeft() {
        try {
            T t = elements[0];
            elements[0] = null;
            elements = trimToSize();
            return t;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new ArrayIndexOutOfBoundsException("Пустой массив");
        }
    }

    public T popRight() {
        try {
            T t = elements[elements.length - 1];
            elements[elements.length - 1] = null;
            elements = trimToSize();
            return t;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new ArrayIndexOutOfBoundsException("Пустой массив");
        }
    }

    private T[] trimToSize() {
        int n = 0;
        int copyFrom = 0;
        if (elements[0] == null) {
            copyFrom = 1;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                n++;
            }
        }
        T[] arr = (T[]) new Object[n];
        System.arraycopy(elements, copyFrom, arr, 0, arr.length);
        return arr;
    }

    private T[] getNewArr(Object[] elements, int shiftNumber) {
        T[] objects = (T[]) new Object[elements.length + 1];
        System.arraycopy(elements, 0, objects, shiftNumber, elements.length);
        return objects;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return elements.length > i;
        }

        @Override
        public T next() {
            return elements[i++];
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        System.out.println("Пуст ли дэк? " + deque.isEmpty());

        deque.pushLeft(1);
        deque.pushRight(2);
        deque.pushLeft(3);
        deque.pushLeft(4);
        deque.pushRight(5);

        System.out.println("Очередь: ");
        deque.forEach(System.out::println);

        Object deleteRight = deque.popRight();
        Object deleteLeft = deque.popLeft();

        System.out.println("Очередь после преобразований: ");
        deque.forEach(System.out::println);

        System.out.println("Размерность после преобразований: " + deque.size());
        System.out.println("Удаленный правый элемент: " + deleteRight + ", Удаленный левый элемент: " + deleteLeft);

        System.out.println("Пуст ли дэк? " + deque.isEmpty());
    }
}
