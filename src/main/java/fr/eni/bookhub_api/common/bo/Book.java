package fr.eni.bookhub_api.common.bo;

import java.time.LocalDateTime;
import java.util.List;

public class Book {

    private Long id;
    private Category category;
    private String title;
    private String author;
    private String isbn;
    private String description;
    private String coverUrl;
    private int totalCopies;
    private int availableCopies;
    private LocalDateTime dateAdded;
    private Double averageRating;
    private List<Borrow> borrows;
    private List<Reservation> reservations;
    private List<Rating> ratings;
    private List<Comment> comments;

    // Empty constructor
    public Book() {
    }

    // Full constructor
    public Book(Long id, Category category, String title, String author, String isbn,
                String description, String coverUrl, int totalCopies,
                int availableCopies, LocalDateTime dateAdded,
                Double averageRating, List<Borrow> borrows,
                List<Reservation> reservations, List<Rating> ratings,
                List<Comment> comments) {

        this.id = id;
        this.category = category;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.coverUrl = coverUrl;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.dateAdded = dateAdded;
        this.averageRating = averageRating;
        this.borrows = borrows;
        this.reservations = reservations;
        this.ratings = ratings;
        this.comments = comments;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
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
}