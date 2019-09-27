package internetshop.controller;

import internetshop.exceptions.AuthentificationException;
import internetshop.lib.Inject;
import internetshop.model.User;
import internetshop.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Inject
    private static UserService userService;
    private static Logger logger = Logger.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String psw = req.getParameter("psw");
        try {
            User user = userService.login(login, psw);
            Cookie cookie = new Cookie("MATE", user.getToken());
            resp.addCookie(cookie);
            HttpSession session = req.getSession(true);
            session.setAttribute("loggedInUser", user);
            logger.info("User " + user.getLogin() + " logged in");
            resp.sendRedirect(req.getContextPath() + "/shop");
        } catch (AuthentificationException e) {
            req.setAttribute("prevLogin", login);
            req.setAttribute("prevPsw", psw);
            logger.error(e);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
