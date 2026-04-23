package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.Roles;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name  = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LAST_NAME",length = 100, nullable = false)
    private String lastName;

    @Column(name = "FIRST_NAME",length = 100, nullable = false)
    private String firstName;

    @Column(name = "EMAIL",length = 255, nullable = false)
    private String email;

    @Column(name = "PASSWORD",length = 255, nullable = false)
    private String password;

    @Column(name = "PHONE",length = 255)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE",length = 255,nullable = false)
    private Roles role;

    @Column(name = "REGISTRATION_DATE",nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "ACTIVE",nullable = false)
    private boolean active;

    @Column(name = "BLOCKED",nullable = false)
    private boolean blocked;

    @OneToMany(mappedBy = "user")
    private List<Loans> loans;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;


    // Empty constructor
    public User() {
    }

    public User(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Full constructor
    public User(Integer id, String lastName, String firstName, String email,
                String password, String phone, Roles role,
                LocalDateTime registrationDate, boolean active, boolean blocked,
                List<Loans> loans, List<Reservation> reservations,
                List<Rating> ratings, List<Comment> comments,
                List<Notification> notifications) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.registrationDate = registrationDate;
        this.active = active;
        this.blocked = blocked;
        this.loans = loans;
        this.reservations = reservations;
        this.ratings = ratings;
        this.comments = comments;
        this.notifications = notifications;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<Loans> getBorrows() {
        return loans;
    }

    public void setBorrows(List<Loans> loans) {
        this.loans = loans;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
