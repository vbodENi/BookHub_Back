package fr.eni.bookhub_api.common.bo.compositeKey;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReservationId implements Serializable
{
    private Integer user;
    private Integer book;
}
