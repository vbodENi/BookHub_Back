package fr.eni.bookhub_api.auth.register;

import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.dal.UserRepository;
import fr.eni.bookhub_api.common.enumeration.Roles;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegisterServiceImpl implements RegisterService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterServiceImpl(UserRepository userRepository,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public void register(RegisterRequestDTO requestDTO) {

        // Vérification unicité email
        if (userRepository.existsByEmail(requestDTO.getEmail())) {
            throw new EmailAlreadyUsedException("Cette adresse email est déjà utilisée.");
        }

        //construction de l'entité User
        User user = User.builder()
                .lastName(requestDTO.getLastName())
                .firstName(requestDTO.getFirstName())
                .email(requestDTO.getEmail())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .phone(requestDTO.getPhone())
                .role(Roles.USER)
                .registrationDate(LocalDateTime.now())
                .active(true)
                .blocked(false)
                .build();

        userRepository.save(user);
    }
}
