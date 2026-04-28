package fr.eni.bookhub_api.profile;

public interface ProfileService {
    //j'affiche le profil par son e-mail
    ProfileResponseDTO getProfileByEmail(String email);

    //J'identifie l'utilisateur à modifier par son email et par le DTP afin de transporter les nouvelles données en BDD
    ProfileResponseDTO updateProfile(String email, ProfileUpdateRequestDTO profileUpdateRequestDTO);

    //suppression d'un utilisateur
    void deleteProfileByEmail(String email);

}
