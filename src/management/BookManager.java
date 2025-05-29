package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    // TODO: Define a data structure that stores ISBNs and their matching Book objects
    CustomHashMap<String, Book> books;

    private final MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        // TODO: Initialize your data structure here
        books = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        // TODO: Add the book and its ISBN to your data structure
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        // TODO
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        // TODO
        return books.get(isbn).isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        // TODO
        books.get(isbn).setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        // TODO
        books.get(isbn).addToWaitlist(memberManager.getMember(memberId));
    }

    public Member getNextFromWaitlist(String isbn) {
        // TODO
        return books.get(isbn).getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        // TODO
        return books.get(isbn).hasWaitlist();
    }
}