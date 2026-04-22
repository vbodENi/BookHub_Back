package fr.eni.bookhub_api.login.dao.mock;

import fr.eni.bookhub_api.common.User;
import fr.eni.bookhub_api.login.dao.ILoginDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DAOLoginMock implements ILoginDAO
{
    private List<User> users;

    public DAOLoginMock() {
        users = new ArrayList<>();

        users.add(new User("loginMock@email.com", "123456Test"));
        users.add(new User("user1@email.com", "password1"));
        users.add(new User("user2@email.com", "password2"));
        users.add(new User("admin@email.com", "admin123"));
    }

    @Override
    public User findByLogin(String login,String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(login) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
