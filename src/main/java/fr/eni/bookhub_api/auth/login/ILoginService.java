package fr.eni.bookhub_api.auth.login;

public interface ILoginService
{
    LoginResponse checkAuth(String email, String password);
}
