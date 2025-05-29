package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private final CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }

    @SuppressWarnings("unchecked cast")
    @Override
    public boolean add(Object t) {
        if (t == null) {
            throw new IllegalStateException("Cannot add null to the queue");
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
        return list.removeFirst();
    }

    @Override
    public T poll() {
        return list.removeFirst();
    }

    @Override
    public T element() {
        T result = list.getFirst();
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public T peek() {
        return list.getFirst();
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