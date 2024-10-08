package userinterface;

import java.util.Scanner;

import entity.*;

import service.*;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library library = new Library();
		Transaction transaction = new Transaction();
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n===== Bai Jerabai Wadia Library Fergusson College =====");
			System.out.println("1. Add a Book");
			System.out.println("2. Remove a Book");
			System.out.println("3. Search Book by Title");
			System.out.println("4. Search Book by Author");
			System.out.println("5. Search Book by Category");
			System.out.println("6. Add a Member");
			System.out.println("7. Remove a Member");
			System.out.println("8. Borrow a Book");
			System.out.println("9. Return a Book");
			System.out.println("10. Display All Books");
			System.out.println("11. Display All Members");
			System.out.println("12. Display Transactions");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:

				System.out.print("Enter book title: ");
				String title = scanner.nextLine();
				System.out.print("Enter book author: ");
				String author = scanner.nextLine();
				System.out.print("Enter book category: ");
				String category = scanner.nextLine();
				library.addBook(new Book(title, author, category, true));
				System.out.println("Book added successfully!");
				break;

			case 2:

				System.out.print("Enter the title of the book to remove: ");
				String bookId = scanner.nextLine();
				library.removeBook(bookId);
				System.out.println("Book removed successfully!");
				break;

			case 3:

				System.out.print("Enter the book title to search: ");
				String searchTitle = scanner.nextLine();
				Book foundBook = library.searchBookByTitle(searchTitle);
				if (foundBook != null) {
					System.out.println("Book Found: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
				} else {
					System.out.println("Book not found.");
				}
				break;

			case 4:

				System.out.print("Enter the author's name to search: ");
				String searchAuthor = scanner.nextLine();
				for (Book book : library.searchBookByAuthor(searchAuthor)) {
					System.out.println(book.getTitle() + " by " + book.getAuthor());
				}
				break;

			case 5:

				System.out.print("Enter the category to search: ");
				String searchCategory = scanner.nextLine();
				for (Book book : library.searchBookByCategory(searchCategory)) {
					System.out.println(book.getTitle() + " by " + book.getAuthor());
				}
				break;

			case 6:

				System.out.print("Enter member name: ");
				String memberName = scanner.nextLine();
				System.out.print("Enter member ID: ");
				String memberId = scanner.nextLine();
				library.addMember(new Member(memberName));
				System.out.println("Member added successfully!");
				break;

			case 7:

				System.out.print("Enter the member ID to remove: ");
				String removeMemberId = scanner.nextLine();
				library.removeMember(removeMemberId);
				System.out.println("Member removed successfully!");
				break;

			case 8:

				System.out.print("Enter member ID: ");
				String borrowMemberId = scanner.nextLine();
				System.out.print("Enter book title to borrow: ");
				String borrowBookId = scanner.nextLine();
				library.borrowBook(borrowMemberId, borrowBookId);
				transaction.recordBorrowTransaction(borrowMemberId, borrowBookId);
				System.out.println("Book borrowed successfully!");
				break;

			case 9:

				System.out.print("Enter member ID: ");
				String returnMemberId = scanner.nextLine();
				System.out.print("Enter book title to return: ");
				String returnBookId = scanner.nextLine();
				library.returnBook(returnMemberId, returnBookId);
				transaction.recordReturnTransaction(returnMemberId, returnBookId);
				System.out.println("Book returned successfully!");
				break;

			case 10:

				System.out.println("All Books:");
				library.displayAllBooks();
				break;

			case 11:

				System.out.println("All Members:");
				library.displayAllMembers();
				break;

			case 12:

				System.out.println("All Transactions:");
				transaction.displayTransactions();
				break;

			case 0:

				System.out.println("Exiting Library Management System. Goodbye!");
				break;

			default:
				System.out.println("Invalid choice, please try again.");
			}
		} while (choice != 0);

		scanner.close();
	}
}
