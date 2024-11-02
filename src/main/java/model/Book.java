package model;

import java.util.Date;
import java.util.UUID;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "book_id", nullable = false)
    private UUID book_id;

    @Column(name = "book_title")
    private String book_title;

    @Column(name = "book_author")
    private String book_author;

    private int edition;

    @Column(name = "isbn_code")
    private String isbn_code;

    @Temporal(TemporalType.DATE)
    @Column(name = "publication_year")
    private Date publication_year;

    @Column(name = "publisher_name")
    private String publisher_name;

    @Enumerated(EnumType.STRING)
    private BookStatus book_status;

    @Column(name = "shelf_id")
    private UUID shelf_id;

    // Optional bidirectional relationship with Borrower
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Borrower> borrowers;

    public Book() {}

    // Getters and Setters

    // Constructor including all attributes
    public Book(UUID book_id, String book_title, String book_author, int edition, String isbn_code,
                Date publication_year, String publisher_name, BookStatus book_status, UUID shelf_id) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.edition = edition;
        this.isbn_code = isbn_code;
        this.publication_year = publication_year;
        this.publisher_name = publisher_name;
        this.book_status = book_status;
        this.shelf_id = shelf_id;
    }

    // Getters and Setters
    public UUID getBook_id() {
        return book_id;
    }

    public void setBook_id(UUID book_id) {
        this.book_id = book_id;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getIsbn_code() {
		return isbn_code;
	}

	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}

	public Date getPublication_year() {
		return publication_year;
	}

	public void setPublication_year(Date publication_year) {
		this.publication_year = publication_year;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public BookStatus getBook_status() {
		return book_status;
	}

	public void setBook_status(BookStatus book_status) {
		this.book_status = book_status;
	}

	public UUID getShelf_id() {
		return shelf_id;
	}

	public void setShelf_id(UUID shelf_id) {
		this.shelf_id = shelf_id;
	}

    
}
