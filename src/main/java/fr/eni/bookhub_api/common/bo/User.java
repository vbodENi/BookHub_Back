package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(of = {"email"})

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

    public User(String mail, String password)
    {
        this.email = mail;
        this.password = password;
    }
}
