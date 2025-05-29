package library;

import datastructures.queues.CustomQueue;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean isAvailable;

    // TODO: Define a data structure to hold members waiting for this book
    CustomQueue<Member> waiter;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;

        // TODO: Initialize your data structure here
        waiter = new CustomQueue<>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void addToWaitlist(Member member) {
        // TODO
        waiter.add(member);
    }

    public Member getNextInWaitlist() {
        // TODO
        return waiter.remove();
    }

    public boolean hasWaitlist() {
        // TODO
        return waiter.isEmpty();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + isAvailable +
                '}';
    }
}