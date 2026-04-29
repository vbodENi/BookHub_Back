package fr.eni.bookhub_api.profile;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileRestController {

    private ProfileService profileService;
    private JwtService jwtService;

    public ProfileRestController(ProfileService profileService, JwtService jwtService) {
        this.profileService = profileService;
        this.jwtService = jwtService;
    }

    @GetMapping
    public ServiceResponse<ProfileResponseDTO> getProfileByEmail(
            @RequestHeader("Authorization") String token) {
        try {
            String tokenClean = token.substring(7);
            String email = jwtService.extractEmail(tokenClean);
            ProfileResponseDTO data = profileService.getProfileByEmail(email);
            return new ServiceResponse<>("200", "Profil récupéré avec succès !", data);
        } catch (Exception e) {
            return new ServiceResponse<>("500", e.getMessage());
        }
    }

//    @PutMapping
//    //on renvoie un profileResponseDTO car il ne possède pas les mots de passe et on ne doit pas les afficher
//    public ServiceResponse<ProfileResponseDTO> updateProfile(
//            //on récupère l'email de l'utilisateur connecté depuis le token JWT
//            Principal principal,
//            //RequestBody tranforme Json en objet pour le mapping
//            @Valid @RequestBody ProfileUpdateRequestDTO profileUpdateRequestDTO) {
//
//        ProfileResponseDTO data = profileService.updateProfile(principal.getName(), profileUpdateRequestDTO);
//
//        return new ServiceResponse<>(
//                "200",
//                "Votre profil a bien été mis à jour !",
//                data
//        );
//    }

    @PutMapping
    public ServiceResponse<ProfileResponseDTO> updateProfile(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody ProfileUpdateRequestDTO profileUpdateRequestDTO) {
        try {
            String tokenClean = token.substring(7);
            String email = jwtService.extractEmail(tokenClean);
            ProfileResponseDTO data = profileService.updateProfile(email, profileUpdateRequestDTO);
            return new ServiceResponse<>("200", "Votre profil a bien été mis à jour !", data);
        } catch (Exception e) {
            return new ServiceResponse<>("500", e.getMessage());
        }
    }


//    @DeleteMapping
//    public ServiceResponse<Void> deleteAccount(Principal principal) {
//        profileService.deleteProfileByEmail(principal.getName());
//        return new ServiceResponse<>(
//                "200",
//                "Votre compte a été supprimé avec succès."
//        );
//    }

    @DeleteMapping
    public ServiceResponse<Void> deleteAccount(
            @RequestHeader("Authorization") String token) {
        try {
            //je nettoie le token
            String tokenClean = token.substring(7);
            //j'extrais l'email du token
            String email = jwtService.extractEmail(tokenClean);
            profileService.deleteProfileByEmail(email);
            return new ServiceResponse<>("200", "Votre compte a été supprimé avec succès.");
        } catch (Exception e) {
            return new ServiceResponse<>("500", e.getMessage());
        }
    }
    }
