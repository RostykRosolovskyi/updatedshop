package internetshop.service;

import internetshop.exceptions.AuthentificationException;
import internetshop.model.Order;
import internetshop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);

    List<Order> getOrders(User user);

    List<User> getAll();

    User login(String login, String password) throws AuthentificationException;

    String getTocken();

    Optional<User> getByToken(String token);
}
