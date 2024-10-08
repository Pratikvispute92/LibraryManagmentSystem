package service;
import entity.*;
import java.util.ArrayList;

public class Transaction {
    private ArrayList<TransactionRecord> transactions;

    // Constructor
    public Transaction() {
        transactions = new ArrayList<>();
    }

    // Record Borrow and Return Transactions
    public void recordBorrowTransaction(String memberId, String bookId) {
        transactions.add(new TransactionRecord(memberId, bookId, "Borrow"));
    }

    public void recordReturnTransaction(String memberId, String bookId) {
        transactions.add(new TransactionRecord(memberId, bookId, "Return"));
    }

    // Display Transactions
    public void displayTransactions() {
        for (TransactionRecord record : transactions) {
            record.displayTransaction();
        }
    }
}
