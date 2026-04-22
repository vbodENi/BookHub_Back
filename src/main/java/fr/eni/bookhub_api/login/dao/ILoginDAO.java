package fr.eni.bookhub_api.login.dao;

import fr.eni.bookhub_api.common.bo.User;

public interface ILoginDAO
{
    User findByLogin(String login,String password);
}
