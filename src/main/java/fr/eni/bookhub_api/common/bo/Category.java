package fr.eni.bookhub_api.common.bo;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString


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

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}
