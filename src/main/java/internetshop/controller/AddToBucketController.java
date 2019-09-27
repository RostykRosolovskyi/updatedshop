package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.ItemService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToBucketController extends HttpServlet {
    @Inject
    private static BucketService bucketService;
    @Inject
    private static ItemService itemService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        User user = (User) req.getSession().getAttribute("loggedInUser");
        Bucket bucket = bucketService.get(user.getBucket().getId());
        Long itemId = Long.parseLong(req.getParameter("item_id"));
        Item item = itemService.get(itemId);
        bucketService.addItem(bucket, item);
        resp.sendRedirect(req.getContextPath() + "/shop");
    }
}
