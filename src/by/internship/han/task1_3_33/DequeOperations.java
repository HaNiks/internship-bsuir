package by.internship.han.task1_3_33;

public interface DequeOperations<T> {
    boolean isEmpty();

    int size();

    void pushLeft(T t);

    void pushRight(T t);

    T popLeft();

    T popRight();
}
