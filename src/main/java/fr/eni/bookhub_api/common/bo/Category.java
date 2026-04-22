package fr.eni.bookhub_api.common.bo;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name  = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LABEL",length = 255, nullable = false, unique = true)
    private String label;

    @Column(name = "DESCRIPTION",length = 255)
    private String description;

    @OneToMany(mappedBy = "CATEGORY")
    private List<Book> books;

    // Empty constructor
    public Category() {
    }

    // Full constructor
    public Category(Integer id, String label, String description, List<Book> books) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.books = books;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
