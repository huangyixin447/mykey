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
@WebServlet("/index")
public class indexServlet extends ViewBaseServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String sessionValue = session.getId();
        System.out.println(sessionValue);

        String length = req.getParameter("length");
        if(length==null||length.equals("")){
            throw new RuntimeException("密码长度为空");
        }
        int length1 = Integer.parseInt(length);
        String key = generatePassword(length1);
        keybean keybean = new keybean(0,key,sessionValue);
        keyDAOimpl keyDAOimpl = new keyDAOimpl();
        keyDAOimpl.addkey(keybean);
        session.setAttribute("length",length1);
        String url="http://localhost:8080/keyword/show?session="+sessionValue;
        session.setAttribute("url",url);
        super.processTemplate("index",req,resp);
    }

}
