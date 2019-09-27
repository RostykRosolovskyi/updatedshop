package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Item;
import internetshop.model.Role;
import internetshop.model.User;
import internetshop.service.ItemService;
import internetshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class InjectDataController extends HttpServlet {
    @Inject
    private static UserService userService;
    @Inject
    private static ItemService itemService;

    @Override
    public void init() throws ServletException {
        itemService.add(new Item("Xiaomi", 15.));
        itemService.add(new Item("Iphone", 350.));
        itemService.add(new Item("Samsung", 40.));
        itemService.add(new Item("Huawei", 15.));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User admin = new User();
        admin.setName("admin");
        admin.setSurname("admin");
        admin.setLogin("admin");
        admin.setPassword("1");
        admin.setToken(UUID.randomUUID().toString());
        admin.addRole(Role.of("ADMIN"));
        userService.add(admin);

        User user = new User();
        user.setName("user");
        user.setSurname("user");
        user.setLogin("user");
        user.setPassword("1");
        user.setToken(UUID.randomUUID().toString());
        user.addRole(Role.of("USER"));
        userService.add(user);
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
