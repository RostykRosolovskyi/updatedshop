package internetshop.service.impl;

import internetshop.dao.BucketDao;
import internetshop.dao.UserDao;
import internetshop.exceptions.AuthentificationException;
import internetshop.lib.Inject;
import internetshop.lib.Service;
import internetshop.model.User;
import internetshop.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private static UserDao userDao;
    @Inject
    private static BucketDao bucketDao;

    @Override
    public User add(User user) {
        User newUser = userDao.add(user);
        user.setToken(getTocken());
        bucketDao.add(newUser.getBucket());
        return newUser;
    }

    @Override
    public String getTocken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Optional<User> getByToken(String token) {
        return userDao.getByTocken(token);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public List getOrders(User user) {
        return userDao.get(user.getId()).getOrders();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User login(String login, String password) throws AuthentificationException {
        return userDao.login(login, password);
    }
}
