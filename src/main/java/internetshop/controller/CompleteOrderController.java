package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Bucket;
import internetshop.model.Order;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.OrderService;
import internetshop.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompleteOrderController extends HttpServlet {
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;
    @Inject
    private static BucketService bucketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        User userFromSession = (User) req.getSession().getAttribute("user");
        User user = userService.get(userFromSession.getId());
        Bucket bucket = bucketService.get(user.getBucket().getId());
        if (bucket.getItems().size() != 0) {
            Order order = new Order(bucket.getItems(), user);
            orderService.add(order);
            user.getOrders().add(order);
            bucketService.clear(bucket);
        }
        resp.sendRedirect(req.getContextPath() + "/shop");
    }
}
