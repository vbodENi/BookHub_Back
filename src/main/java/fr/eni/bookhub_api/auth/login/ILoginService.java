package fr.eni.bookhub_api.auth.login;

import fr.eni.bookhub_api.common.ServiceResponse;

public interface ILoginService
{
    ServiceResponse<LoginResponse> checkAuth(String email, String password);
}
