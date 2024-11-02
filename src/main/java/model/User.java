package model;

import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User extends Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", nullable = false)
    private UUID user_id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private userRole role;

    // Map village_id to location_id where location_type = VILLAGE
    @ManyToOne
    @JoinColumn(name = "village_id", referencedColumnName = "location_id", nullable = true)
    private Location village;
    
    public User() {}

    public User(String person_id, String first_name, String last_name, PersonGender gender, String phone_number) {
        super(person_id, first_name, last_name, gender, phone_number);
    }

    public User(UUID user_id, String person_id, String first_name, String last_name, PersonGender gender,
            String phone_number, String username, String password, userRole role, Location village) {
        super(person_id, first_name, last_name, gender, phone_number);
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.village = village;
    }

    // Getters and Setters
    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public userRole getRole() {
        return role;
    }

    public void setRole(userRole role) {
        this.role = role;
    }

    public Location getVillage() {
        return village;
    }

    public void setVillage(Location village) {
        this.village = village;
    }
}
