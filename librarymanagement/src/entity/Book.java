package entity;

public class Book {

	String title;
	String author;
	String category;
	boolean avalibality;

	public Book(String title, String author, String category, boolean avalibality) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.avalibality = avalibality;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public boolean isAvalibality() {
		return avalibality;
	}

	public void setAvalibality(boolean avalibality) {
		this.avalibality = avalibality;
	}

}
