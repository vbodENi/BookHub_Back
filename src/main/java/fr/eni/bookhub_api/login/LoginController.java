package fr.eni.bookhub_api.login;

import fr.eni.bookhub_api.common.bo.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController
{
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login/auth")
    public LoginResponse login(@RequestBody User user)
    {
        return loginService.checkAuth(user.getEmail(), user.getPassword());
    }
}
