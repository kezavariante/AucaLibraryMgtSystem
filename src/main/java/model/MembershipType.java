package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MembershipTypes")
public class MembershipType {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID membershipType_id;

    @Column(name = "membershipType_name", nullable = false)
    private String membershipType_name;

    @Column(name = "max_books", nullable = false)
    private int max_book;

    @Column(name = "price", nullable = false)
    private int price;

    // One-to-Many relationship
    @OneToMany(mappedBy = "membershipType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membership> memberships = new ArrayList<>();
	
	public MembershipType() {}
	
	
	public MembershipType(UUID membershipType_id, String membershipType_name, int max_book, int price) {
		this.membershipType_id = membershipType_id;
		this.membershipType_name = membershipType_name;
		this.max_book = max_book;
		this.price = price;
	}


	public UUID getMembershipType_id() {
		return membershipType_id;
	}


	public void setMembershipType_id(UUID membershipType_id) {
		this.membershipType_id = membershipType_id;
	}


	public String getMembershipType_name() {
		return membershipType_name;
	}


	public void setMembershipType_name(String membershipType_name) {
		this.membershipType_name = membershipType_name;
	}


	public int getMax_book() {
		return max_book;
	}


	public void setMax_book(int max_book) {
		this.max_book = max_book;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
}