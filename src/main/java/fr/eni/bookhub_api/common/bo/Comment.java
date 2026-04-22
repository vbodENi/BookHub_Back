package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.ModerationStatuts;
import java.time.LocalDateTime;

public class Comment
{
    private Integer id;
    private User user;
    private Book book;
    private ModerationStatuts eModerationStatuts;
    private String description;
    private LocalDateTime datePublication;
    private LocalDateTime dateModify;

    public Comment() {
    }

    public Comment(Integer id, User user, Book book, ModerationStatuts eModerationStatuts, String description, LocalDateTime datePublication, LocalDateTime dateModify) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.eModerationStatuts = eModerationStatuts;
        this.description = description;
        this.datePublication = datePublication;
        this.dateModify = dateModify;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ModerationStatuts geteModerationStatuts() {
        return eModerationStatuts;
    }

    public void seteModerationStatuts(ModerationStatuts eModerationStatuts) {
        this.eModerationStatuts = eModerationStatuts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }

    public LocalDateTime getDateModify() {
        return dateModify;
    }

    public void setDateModify(LocalDateTime dateModify) {
        this.dateModify = dateModify;
    }
}
