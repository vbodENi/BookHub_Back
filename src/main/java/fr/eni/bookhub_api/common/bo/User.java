package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.Roles;

import java.time.LocalDateTime;
import java.util.List;

public class User {

    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String phone;
    private Roles role;
    private LocalDateTime registrationDate;
    private boolean active;
    private boolean blocked;
    private List<Borrow> borrows;
    private List<Reservation> reservations;
    private List<Rating> ratings;
    private List<Comment> comments;
    private List<Notification> notifications;

    // Empty constructor
    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Full constructor
    public User(int id, String lastName, String firstName, String email,
                String password, String phone, Roles role,
                LocalDateTime registrationDate, boolean active, boolean blocked,
                List<Borrow> borrows, List<Reservation> reservations,
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
        this.borrows = borrows;
        this.reservations = reservations;
        this.ratings = ratings;
        this.comments = comments;
        this.notifications = notifications;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
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
