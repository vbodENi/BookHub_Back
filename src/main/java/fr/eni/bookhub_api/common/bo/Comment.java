package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.ModerationStatuts;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name  = "COMMENT")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "STATUS",length = 255, nullable = false)
    private ModerationStatuts eModerationStatuts;

    @Column(name = "DESCRIPTION",length = 255, nullable = false)
    private String description;

    @Column(name = "DATE_PUBLICATION",nullable = false)
    private LocalDateTime datePublication;

    @Column(name = "DATE_MODIFY")
    private LocalDateTime dateModify;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;

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
