package fr.eni.bookhub_api.auth.login;

public class LoginResponse
{
    public String code;
    public String token;

    public LoginResponse() {
    }

    public LoginResponse(String code, String token) {
        this.code = code;
        this.token = token;
    }
}
