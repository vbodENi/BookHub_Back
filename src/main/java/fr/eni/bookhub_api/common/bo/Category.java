package fr.eni.bookhub_api.common.bo;


import java.util.List;

public class Category {

    private int id;
    private String label;
    private String description;
    private List<Book> books;

    // Empty constructor
    public Category() {
    }

    // Full constructor
    public Category(int id, String label, String description, List<Book> books) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.books = books;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
