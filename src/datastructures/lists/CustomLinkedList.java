package datastructures.lists;

import datastructures.interfaces.LinkedList;

public class CustomLinkedList<T> implements LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;


    @Override
    public void addFirst(T t) {
        if (t == null) return;

        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        if (t == null) return;

        Node<T> newNode = new Node<>(t);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (head == null) return null;

        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (tail == null) return null;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return tail.data;
    }

    @Override
    public T getFirst() {
        return head == null ? null : head.data;
    }

    @Override
    public T getLast() {
        return tail == null ? null : tail.data;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return findNode(index);
    }

    @SuppressWarnings("unchecked cast")
    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (element == null) return null;

        Node<T> current = findNode(index);
        current.data = (T) element;
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked cast")
    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        }
        addLast((T) o);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        Node<T> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }

        Node<T> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private Node<T> findNode(int index) {
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
}