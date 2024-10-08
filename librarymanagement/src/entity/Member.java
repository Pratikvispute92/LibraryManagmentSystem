package entity;

import java.util.ArrayList;

public class Member {

	String name;
	static long id = 1000;
	String memberId;

	ArrayList<Book> borrowedBooks;

	public Member(String name) {
		super();
		this.name = name;
		this.memberId = "LIB" + ++id;
		borrowedBooks = new ArrayList<Book>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberId() {
		return memberId;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void borrowBook(Book book) {
		if (book.isAvalibality()) {
			borrowedBooks.add(book);
			book.setAvalibality(false);
			System.out.println(this.name + " borrowed book " + book.getTitle());
		} else {
			System.out.println("Book is not available");
		}
	}

	public void returnBook(Book book) {
		if (borrowedBooks.contains(book)) {
			borrowedBooks.remove(book);
			book.setAvalibality(true);
			System.out.println(this.name + " returned book " + book.getTitle());
		} else {
			System.out.println("Book is not available");
		}
	}

}
