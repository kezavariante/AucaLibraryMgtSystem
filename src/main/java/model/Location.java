package model;

import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "location_id", nullable = false)
    private UUID location_id;

    @Column(name = "location_code")
    private String location_code;

    @Column(name = "location_name")
    private String location_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_type")
    private LocationType location_type;

   
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parentLocation;
    

    public Location() {}


	public Location(UUID location_id, String location_code, String location_name, LocationType location_type,
			Location parentLocation) {
		super();
		this.location_id = location_id;
		this.location_code = location_code;
		this.location_name = location_name;
		this.location_type = location_type;
		this.parentLocation = parentLocation;
	}


	public UUID getLocation_id() {
		return location_id;
	}


	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}


	public String getLocation_code() {
		return location_code;
	}


	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}


	public String getLocation_name() {
		return location_name;
	}


	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}


	public LocationType getLocation_type() {
		return location_type;
	}


	public void setLocation_type(LocationType location_type) {
		this.location_type = location_type;
	}


	public Location getParentLocation() {
		return parentLocation;
	}


	public void setParentLocation(Location parentLocation) {
		this.parentLocation = parentLocation;
	}

    
}
