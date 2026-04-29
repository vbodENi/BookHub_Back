package fr.eni.bookhub_api.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

public class ProfileResponseDTO {

    private String lastName;
    private String firstName;
    private String email;
    private String phone;
}
