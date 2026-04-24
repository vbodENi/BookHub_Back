package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.ModerationStatuts;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString


@Entity
@Table(name  = "COMMENT")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
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
}
