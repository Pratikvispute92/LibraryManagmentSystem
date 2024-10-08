package service;

import java.util.HashMap;

import entity.*;

import java.util.*;

public class Library {
    private HashMap<String, Book> books;
    private HashMap<String, Member> members;

    // Constructor
    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
    }

    // Add, Remove, Update Books
    public void addBook(Book book) {
        books.put(book.getTitle(), book); // Assuming book title is unique
    }

    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    public void updateBook(String bookId, Book updatedBook) {
        books.put(bookId, updatedBook);
    }

    // Search Methods
    public Book searchBookByTitle(String title) {
        return books.get(title);
    }

    public ArrayList<Book> searchBookByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchBookByCategory(String category) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    // Manage Members
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    public void updateMember(String memberId, Member updatedMember) {
        members.put(memberId, updatedMember);
    }

    public Member getMemberById(String memberId) {
        return members.get(memberId);
    }

    // Borrow and Return Book
    public void borrowBook(String memberId, String bookId) {
        Member member = getMemberById(memberId);
        Book book = searchBookByTitle(bookId);
        if (member != null && book != null && book.isAvalibality()) {
            member.borrowBook(book);
        } else {
            System.out.println("Borrowing failed.");
        }
    }

    public void returnBook(String memberId, String bookId) {
        Member member = getMemberById(memberId);
        Book book = searchBookByTitle(bookId);
        if (member != null && book != null) {
            member.returnBook(book);
        } else {
            System.out.println("Returning failed.");
        }
    }

    // Display Methods
    public void displayAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void displayAllMembers() {
        for (Member member : members.values()) {
            System.out.println(member.getName() + " (ID: " + member.getMemberId() + ")");
        }
    }
}
