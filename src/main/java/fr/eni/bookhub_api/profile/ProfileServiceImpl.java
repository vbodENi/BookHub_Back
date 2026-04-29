package fr.eni.bookhub_api.profile;

import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.dal.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProfileServiceImpl implements ProfileService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public ProfileServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ProfileResponseDTO getProfileByEmail(String email) {

        User user = userRepository.findByEmail(email)
                //permet d'extraire la valeur d'un Optional
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable."));

        return ProfileResponseDTO.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    @Override
    @Transactional
    public ProfileResponseDTO updateProfile(String email, ProfileUpdateRequestDTO profileUpdateRequestDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable."));

        //mise à jour des informations
        user.setLastName(profileUpdateRequestDTO.getLastName());
        user.setFirstName(profileUpdateRequestDTO.getFirstName());
        user.setPhone(profileUpdateRequestDTO.getPhone());

        //changement du mot de passe uniquement si l'utilisateur a rempli les champs
        if (profileUpdateRequestDTO.getOldPassword() != null && profileUpdateRequestDTO.getNewPassword() != null) {
            handlePasswordChange(user,  profileUpdateRequestDTO);
        }
        userRepository.save(user);

        //affichage profil mis à jour
        return ProfileResponseDTO.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    @Override
    @Transactional
    public void deleteProfileByEmail(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable."));

        // Soft delete RGPD — anonymisation des données personnelles
        // On ne supprime pas la ligne pour conserver l'intégrité
        // des données liées (emprunts, réservations, notes, commentaires)
        user.setFirstName("Anonyme");
        user.setLastName("Anonyme");
        // Email unique basé sur l'id pour éviter les conflits de contrainte d'unicité
        user.setEmail("anonyme_" + user.getId() + "@supprime.fr");
        user.setPhone(null);
        // Vide le mot de passe — connexion impossible
        user.setPassword("");
        // Désactive et bloque le compte
        user.setActive(false);
        user.setBlocked(true);
        // Enregistre la date de suppression pour traçabilité
        user.setDeletedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    //méthode privée pour la gestion du changement de mot de passe
    private void handlePasswordChange(User user, ProfileUpdateRequestDTO requestDTO) {
        if (!passwordEncoder.matches(requestDTO.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("L'ancien mot de passe est incorrect.");
        }
        user.setPassword(passwordEncoder.encode(requestDTO.getNewPassword()));
    }
}
