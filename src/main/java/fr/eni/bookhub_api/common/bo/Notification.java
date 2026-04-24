package fr.eni.bookhub_api.common.bo;

import fr.eni.bookhub_api.common.enumeration.NotificationsTypes;
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
}
