package internetshop.controller;

import internetshop.lib.Inject;
import internetshop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexController extends HttpServlet {
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (userService.getAll().size() > 0) {
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/injectData");
        }
    }
}
