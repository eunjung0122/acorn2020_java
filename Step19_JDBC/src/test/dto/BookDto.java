package test.dto;

public class BookDto {
	private int num;
	private String title;
	private String author;
	private double rating;
	
	public BookDto() {}

	public BookDto(int num, String title, String author, double rating) {
		super();
		this.num = num;
		this.title = title;
		this.author = author;
		this.rating = rating;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
