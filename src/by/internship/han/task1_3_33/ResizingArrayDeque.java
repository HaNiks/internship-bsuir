package by.internship.han.task1_3_33;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizingArrayDeque<T> implements Iterable<T>, StandardOperations {
    private Object[] elements;

    public ResizingArrayDeque() {
        elements = new Object[0];
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

    public Object popLeft() {
        if (elements != null) {
            Object item = elements[0];
            elements[0] = null;
            elements = trimToSize();
            return item;
        }
        return null;
    }

    public Object popRight() {
        if (elements != null) {
            Object item = elements[elements.length - 1];
            elements[elements.length - 1] = null;
            elements = trimToSize();
            return item;
        }
        return null;
    }

    private Object[] trimToSize() {
        int n = 0;
        for (Object element : elements) {
            if (element != null) {
                n++;
            }
        }
        Object[] arr = new Object[n];
        for (Object element : elements) {
            for (int i = 0; i < arr.length; i++) {
                if (element != null) {
                    arr[i] = element;
                }
            }
        }
        return arr;
    }

    private Object[] getNewArr(Object[] elements, int shiftNumber) {
        Object[] objects = new Object[elements.length + 1];
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
            return (T) String.valueOf(elements[i++]);
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
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();

        System.out.println("Пуст ли дэк? " + deque.isEmpty());

        deque.pushLeft("left push");
        deque.pushRight("right push");
        deque.pushLeft("left push");

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
