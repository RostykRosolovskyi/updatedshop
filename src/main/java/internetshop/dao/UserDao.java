package internetshop.dao;

import internetshop.exceptions.AuthentificationException;
import internetshop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);

    List<User> getAll();

    User login(String login, String password) throws AuthentificationException;

    Optional<User> getByTocken(String token);
}
