package fr.eni.bookhub_api.common.bo.compositeKey;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RatingId implements Serializable
{
    private Integer user;
    private Integer book;
}