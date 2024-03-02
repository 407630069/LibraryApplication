package model;

public class Book {

    private String isbn;
    private String name;
    private String author;
    private String introduction;

    public Book() {
    }

    public Book(String isbn, String name, String author, String introduction) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.introduction = introduction;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setAvailable(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
