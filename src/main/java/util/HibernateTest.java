package util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import model.Room;
import model.Shelf;
import model.Book;
import model.Borrower;
import model.User;
import model.Location;
import model.BookStatus;
import model.PersonGender;
import model.userRole;
import model.Membership;
import model.MembershipType;
import model.MembershipStatus;
import java.util.Date;
import java.util.UUID;

public class HibernateTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            // Start transaction
            transaction = session.beginTransaction();

            // 1. Create Room
            Room room = new Room();
            room.setRoom_code("R001");
            session.save(room);
            System.out.println("Room created with ID: " + room.getRoom_id());

            // 2. Create Shelf linked to Room
            Shelf shelf = new Shelf();
            shelf.setRoom(room); // Associate shelf with room
            shelf.setAvailable_stock(50);
            shelf.setBook_category("Psychology");
            shelf.setInitial_stock(50);
            shelf.setBorrowed_number(0);
            session.save(shelf);
            System.out.println("Shelf created with ID: " + shelf.getShelf_id() + " and linked to Room ID: " + room.getRoom_id());

            // 3. Create Book linked to Shelf
            Book book = new Book();
            book.setBook_title("Intro to psychologie");
            book.setBook_author("Tony Blaise");
            book.setEdition(1);
            book.setIsbn_code("703-0-8041-3902-1");
            book.setPublication_year(new Date());
            book.setPublisher_name("Crown Publishing");
            book.setBook_status(BookStatus.AVAILABLE);
            book.setShelf_id(shelf.getShelf_id());
            session.save(book);
            System.out.println("Book created with ID: " + book.getBook_id() + " and linked to Shelf ID: " + shelf.getShelf_id());
            
            // 4. Create User
            User user = new User();
            user.setUsername("Romeo");
            user.setPassword("123");
            user.setRole(userRole.DEAN);
            user.setVillage(null);
            user.setFirst_name("Romeo");
            user.setLast_name("Dushima");
            user.setPhone_number("0799027396");
            user.setGender(PersonGender.MALE);
            session.save(user);
            System.out.println("User created with ID: " + user.getUser_id());
            
            // 5. Create MembershipType
            MembershipType memT = new MembershipType();
            memT.setMax_book(5);
            memT.setMembershipType_name("Gold");
            memT.setPrice(50);
            session.save(memT);
            
            MembershipType memT2 = new MembershipType();
            memT2.setMax_book(3);
            memT2.setMembershipType_name("Silver");
            memT2.setPrice(30);
            session.save(memT2);
            
            MembershipType memT3 = new MembershipType();
            memT3.setMax_book(2);
            memT3.setMembershipType_name("Silver");
            memT3.setPrice(10);
            session.save(memT3);
            
            
         // 6. Create Membership
            Membership mem = new Membership();
            mem.setExp_date(new Date());
            mem.setMembership_code("M1");
            mem.setMembershipType(memT3);
            mem.setReader_id(user.getUser_id());
            mem.setRegistration_date(new Date());
            mem.setStatus(MembershipStatus.PENDING);
            session.save(mem);

            // 6. Create Borrower linked to Book
            Borrower borrower = new Borrower();
            borrower.setReader_id(user.getUser_id());;
            borrower.setDue_date(new Date()); // Set appropriate due date
            borrower.setLate_charge_fees(0);
            borrower.setPickup_date(new Date());
            borrower.setReturn_date(new Date());
            borrower.setBook(book); // Associate borrower with book
            session.save(borrower);
            System.out.println("Borrower created for Book ID: " + book.getBook_id());
//
//            // 5. Create Location for User's Village
//            Location village = new Location();
//            village.setLocation_name("Nyamwenda Village");
//            village.setLocation_code("Ny101");
//            // Assume that location_type and other attributes are set as needed
//            session.save(village);
//            System.out.println("Location created with ID: " + village.getLocation_id());

            
            

            // Commit the transaction
            transaction.commit();
            System.out.println("Room, shelf, User and Borrower created and saved successfully!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();  // Close the session
        }
    }
}