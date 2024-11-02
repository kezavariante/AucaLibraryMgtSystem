package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Memberships")
public class Membership {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID membership_id;

    @ManyToOne
    @JoinColumn(name = "membership_type_id", nullable = false)
    private MembershipType membershipType;

    @Column(name = "membership_code", nullable = false)
    private String membership_code;

    @Enumerated(EnumType.STRING)
    private MembershipStatus status;

    private Date exp_date;

    // Foreign key to Reader entity
    @Column(name = "reader_id", nullable = false)
    private UUID reader_id;

    private Date registration_date;
	
	
	public Membership() {}
	
	

	public Membership(UUID membership_id, MembershipType membershipType, String membership_code,
			MembershipStatus status, Date exp_date, UUID reader_id, Date registration_date) {
		super();
		this.membership_id = membership_id;
		this.membershipType = membershipType;
		this.membership_code = membership_code;
		this.status = status;
		this.exp_date = exp_date;
		this.reader_id = reader_id;
		this.registration_date = registration_date;
	}



	public UUID getMembership_id() {
		return membership_id;
	}


	public void setMembership_id(UUID membership_id) {
		this.membership_id = membership_id;
	}

	public String getMembership_code() {
		return membership_code;
	}


	public void setMembership_code(String membership_code) {
		this.membership_code = membership_code;
	}


	public MembershipStatus getStatus() {
		return status;
	}


	public void setStatus(MembershipStatus status) {
		this.status = status;
	}


	public Date getExp_date() {
		return exp_date;
	}


	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}


	public UUID getReader_id() {
		return reader_id;
	}


	public void setReader_id(UUID reader_id) {
		this.reader_id = reader_id;
	}


	public Date getRegistration_date() {
		return registration_date;
	}


	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}



	public MembershipType getMembershipType() {
		return membershipType;
	}



	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}
	
	
}