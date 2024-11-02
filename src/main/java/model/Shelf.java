package model;

import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "shelf_id", nullable = false, updatable = false)
    private UUID shelf_id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "available_stock")
    private int available_stock;

    @Column(name = "book_category")
    private String book_category;

    @Column(name = "initial_stock")
    private int initial_stock;

    @Column(name = "borrowed_number")
    private int borrowed_number;

    public Shelf() {}

    public Shelf(Room room, int available_stock, String book_category, int initial_stock, int borrowed_number) {
        this.room = room;
        this.available_stock = available_stock;
        this.book_category = book_category;
        this.initial_stock = initial_stock;
        this.borrowed_number = borrowed_number;
    }

    // Getters and Setters
    public UUID getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(UUID shelf_id) {
        this.shelf_id = shelf_id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getAvailable_stock() {
        return available_stock;
    }

    public void setAvailable_stock(int available_stock) {
        this.available_stock = available_stock;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public int getInitial_stock() {
        return initial_stock;
    }

    public void setInitial_stock(int initial_stock) {
        this.initial_stock = initial_stock;
    }

    public int getBorrowed_number() {
        return borrowed_number;
    }

    public void setBorrowed_number(int borrowed_number) {
        this.borrowed_number = borrowed_number;
    }
}