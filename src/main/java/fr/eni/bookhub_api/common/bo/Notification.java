package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.NotificationsTypes;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name  = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE",length = 150, nullable = false)
    private NotificationsTypes eTypeNotification;

    @Column(name = "MESSAGE",length = 250, nullable = false)
    private String message;

    @Column(name = "DATE_CREATE",nullable = false)
    private LocalDateTime dateCreate;

    @Column(name = "DATE_READING")
    private LocalDateTime dateReading;

    @Column(name = "IS_READING",nullable = false)
    private boolean isReading;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;


    public Notification() {
    }

    public Notification(Integer id, User user, NotificationsTypes eTypeNotification, String message, LocalDateTime dateCreate, LocalDateTime dateReading, boolean isReading) {
        this.id = id;
        this.user = user;
        this.eTypeNotification = eTypeNotification;
        this.message = message;
        this.dateCreate = dateCreate;
        this.dateReading = dateReading;
        this.isReading = isReading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NotificationsTypes geteTypeNotification() {
        return eTypeNotification;
    }

    public void seteTypeNotification(NotificationsTypes eTypeNotification) {
        this.eTypeNotification = eTypeNotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateReading() {
        return dateReading;
    }

    public void setDateReading(LocalDateTime dateReading) {
        this.dateReading = dateReading;
    }

    public boolean isReading() {
        return isReading;
    }

    public void setReading(boolean reading) {
        isReading = reading;
    }
}
