package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomStack() {
        list = new CustomLinkedList<>();
    }

    @SuppressWarnings("unchecked cast")
    @Override
    public boolean add(Object t) {
        if (t == null) {
            throw new IllegalStateException("Cannot push null onto the stack");
        }
        list.addLast((T) t);
        return true;
    }

    @SuppressWarnings("unchecked cast")
    @Override
    public boolean offer(Object t) {
        if (t == null) {
            return false;
        }
        list.addLast((T) t);
        return true;
    }

    @Override
    public T remove() {
        T result = list.removeLast();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public T poll() {
        return list.removeLast();
    }

    @Override
    public T element() {
        T result = list.getLast();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public T peek() {
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}