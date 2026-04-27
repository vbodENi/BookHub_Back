package fr.eni.bookhub_api.auth.login;

import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.dal.UserRepository;
import fr.eni.bookhub_api.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements ILoginService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse checkAuth(String email, String password) {

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            return new LoginResponse("7001", "Email introuvable");
        }

        User user = userOpt.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return new LoginResponse("7002", "Mot de passe incorrect");
        }

        String token = jwtService.generateToken(email);

        return new LoginResponse("2002", token);
    }
}
