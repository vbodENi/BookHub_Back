package fr.eni.bookhub_api.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateRequestDTO {

    @NotBlank(message = "Le nom est obligatoire.")
    @Size(max = 100, message = "Le nom ne peut pas dépasser 100 caractères.")
    private String lastName;

    @NotBlank(message = "Le prénom est obligatoire.")
    @Size(max = 100, message = "Le prénom ne peut pas dépasser 100 caractères.")
    private String firstName;


    @Pattern(
            regexp = "^[0-9\\s\\+\\-]{0,20}$",
            message = "Numéro de téléphone invalide."
    )
    private String phone;

    // Optionnel — rempli uniquement si l'utilisateur veut changer son mot de passe
    private String oldPassword;

    @Size(min = 12, message = "Le mot de passe doit contenir au moins 12 caractères.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&\\-_#])[A-Za-z\\d@$!%*?&\\-_#]{12,}$",
            message = "Le mot de passe doit contenir au moins 1 majuscule, 1 minuscule, 1 chiffre et 1 caractère spécial."
    )
    private String newPassword;
}
