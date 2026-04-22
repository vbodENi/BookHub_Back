package fr.eni.bookhub_api.common;

import fr.eni.bookhub_api.common.enumeration.Roles;

import java.time.LocalDateTime;

public class User
{
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDateTime dateOfInscription;
    private boolean active;
    private boolean blocked;
    private Roles eRoles;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String firstName, String lastName, String email, String password, String phoneNumber, LocalDateTime dateOfInscription, boolean active, boolean blocked, Roles eRoles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateOfInscription = dateOfInscription;
        this.active = active;
        this.blocked = blocked;
        this.eRoles = eRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getDateOfInscription() {
        return dateOfInscription;
    }

    public void setDateOfInscription(LocalDateTime dateOfInscription) {
        this.dateOfInscription = dateOfInscription;
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

    public Roles geteRoles() {
        return eRoles;
    }

    public void seteRoles(Roles eRoles) {
        this.eRoles = eRoles;
    }
}
