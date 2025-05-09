package library;

import datastructures.stacks.CustomStack;

public class Member {
    private String memberId;
    private String name;
    // TODO: Define a data structure to hold transactions of each member
    CustomStack<Transaction> transactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        // TODO: Initialize your data structure here
        transactions = new CustomStack<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        // TODO
        transactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        // TODO
        return null;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
