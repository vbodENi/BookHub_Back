package fr.eni.bookhub_api.common.bo;

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

@Entity
@Table(name  = "BOOK")
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE",length = 255, nullable = false)
    private String title;

    @Column(name = "AUTHOR",length = 255, nullable = false)
    private String author;

    @Column(name = "ISBN",length = 20, unique = true)
    private String isbn;

    @Column(name = "DESCRIPTION",length = 250)
    private String description;

    @Column(name = "COVER_URL",length = 255)
    private String coverUrl;

    @Column(name = "TOTAL_COPIES",nullable = false)
    private int totalCopies;

    @Column(name = "AVAILABLE_COPIES",nullable = false)
    private int availableCopies;

    @Column(name = "DATE_ADDED",nullable = false)
    private LocalDateTime dateAdded;

    @Column(name = "AVERAGE_RATING")
    private Double averageRating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Loans> loans;

    @OneToMany(mappedBy = "book")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "book")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;

}