package com.galvanize.tmo.paspringstarter;


public class Book {

	private long id;
    private String author;
    private String title;
    private String yearPublished;
    
    public Book() {}

    
    @Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", yearPublished=" + yearPublished + "]";
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}
}