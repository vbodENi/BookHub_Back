package fr.eni.bookhub_api.auth.login;

import fr.eni.bookhub_api.common.ServiceResponse;
import fr.eni.bookhub_api.common.bo.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController
{
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/auth/login")
    public ServiceResponse<LoginResponse> login(@RequestBody User user)
    {
        return loginService.checkAuth(user.getEmail(), user.getPassword());
    }
}
