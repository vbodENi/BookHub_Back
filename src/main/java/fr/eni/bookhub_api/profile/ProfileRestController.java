package fr.eni.bookhub_api.profile;

import fr.eni.bookhub_api.common.ServiceResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/profile")
public class ProfileRestController {

    private ProfileService profileService;

    public ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ServiceResponse<ProfileResponseDTO> getProfileByEmail(Principal principal) {
        ProfileResponseDTO data = profileService.getProfileByEmail(principal.getName());

        return new ServiceResponse<>(
                "200",
                "Profil récupéré avec succès !",
                data
        );
    }

    @PutMapping
    //on renvoie un profileResponseDTO car il ne possède pas les mots de passe et on ne doit pas les afficher
    public ServiceResponse<ProfileResponseDTO> updateProfile(
            //on récupère l'email de l'utilisateur connecté depuis le token JWT
            Principal principal,
            //RequestBody tranforme Json en objet pour le mapping
            @Valid @RequestBody ProfileUpdateRequestDTO profileUpdateRequestDTO) {

        ProfileResponseDTO data = profileService.updateProfile(principal.getName(), profileUpdateRequestDTO);

        return new ServiceResponse<>(
                "200",
                "Votre profil a bien été mis à jour !",
                data
        );
    }

    @DeleteMapping
    public ServiceResponse<Void> deleteAccount(Principal principal) {
        profileService.deleteProfileByEmail(principal.getName());
        return new ServiceResponse<>(
                "200",
                "Votre compte a été supprimé avec succès."
        );
    }
}
