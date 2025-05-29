package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    // TODO: Define a data structure that stores memberIds and their matching member objects
    CustomHashMap<String, Member> members;

    public MemberManager() {
        // TODO: Initialize your data structure here
        members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        // TODO: Add member and their id to your data structure
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        // TODO
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        // TODO
        members.get(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        // TODO
        return members.get(memberId).getLastTransaction();
    }
}
