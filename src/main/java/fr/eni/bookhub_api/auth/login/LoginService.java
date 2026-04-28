package fr.eni.bookhub_api.auth.login;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.User;
import fr.eni.bookhub_api.common.dal.UserRepository;
import fr.eni.bookhub_api.loans.LoanResponse;
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

    public ServiceResponse<LoginResponse> checkAuth(String email, String password)
    {
        try
        {
            Optional<User> userOpt = userRepository.findByEmail(email);

            if (userOpt.isEmpty()) {
                throw new RuntimeException("Email not found");
            }

            User user = userOpt.get();

            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new RuntimeException("Password not found");
            }

            String token = jwtService.generateToken(user);

            if (token.isEmpty()) {
                throw new RuntimeException("Error token generation");
            }

            LoginResponse loginResponse = new LoginResponse("2002", token);
            return new ServiceResponse<>("2002", "Success", loginResponse);
        }
        catch (Exception ex)
        {
            switch (ex.getMessage()) {
                case "Password not found":
                    return new ServiceResponse<>("7001", "Password not found");

                case "Email not found":
                    return new ServiceResponse<>("7002", "Email not found");

                case "Error token generation":
                    return new ServiceResponse<>("7002", "Error token generation");

                default:
                    return new ServiceResponse<>("7000", "Fatal error");
            }
        }
    }
}
