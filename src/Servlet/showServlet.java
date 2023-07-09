package Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import method.*;
import myDAO.*;

import static method.PasswordGenerator.generatePassword;
import myspringmvc.*;
@WebServlet("/show")
public class showServlet extends ViewBaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String session = req.getParameter("session");
        System.out.println(session);
        if (session == null) {
            session="";
        }
        HttpSession nowsession = req.getSession();
        Integer counter = (Integer) nowsession.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        nowsession.setAttribute("counter", counter);
        keyDAOimpl keyDAOimpl = new keyDAOimpl();
        keybean ekey = keyDAOimpl.getkey(session);
        String key1 = ekey.getKey1();
        nowsession.setAttribute("key", key1);
        nowsession.setAttribute("counter", counter);
        if (counter > 2) {
            keyDAOimpl.deletekey(key1); // assuming deletekey method exists in keyDAOimpl

            nowsession.removeAttribute("key");

        }
        super.processTemplate("show",req,resp);
    }
}
