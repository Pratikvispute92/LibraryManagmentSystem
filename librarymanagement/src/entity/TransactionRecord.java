package entity;

import java.util.Date;

public class TransactionRecord {
    private String memberId;
    private String bookTitle;
    private String transactionType; 
    private Date transactionDate;

    
    public TransactionRecord(String memberId, String bookTitle, String transactionType) {
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.transactionType = transactionType;
        this.transactionDate = new Date();
    }

   
    public String getMemberId() {
        return memberId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

   
    public void displayTransaction() {
        System.out.println(transactionType + " - Member: " + memberId + ", Book: " + bookTitle + ", Date: " + transactionDate);
    }
}

