package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.NotificationsTypes;

import java.time.LocalDateTime;

public class Notification {

    private Integer id;
    private User user;
    private NotificationsTypes eTypeNotification;
    private String message;
    private LocalDateTime dateCreate;
    private LocalDateTime dateReading;
    private boolean isReading;

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
