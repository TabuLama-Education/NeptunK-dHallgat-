package com.example.loginneptunprojekt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/users"})
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session ellenőrzés - bejelentkezve van-e
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Globális lista lekérése
        List<User> users = LoginServlet.allUsers;

        // HTML válasz generálása
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'/><title>Felhasználók listája</title></head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h2>Regisztrált Felhasználók</h2>");

        if (users == null || users.isEmpty()) {
            out.println("<p>Nincsenek felhasználók.</p>");
        } else {
            out.println("<table border='1' cellpadding='5' cellspacing='0'>");
            out.println("<tr><th>Név</th><th>Neptun kód</th></tr>");

            for (User u : users) {
                out.println("<tr>");
                out.println("<td>" + u.getName() + "</td>");
                out.println("<td>" + u.getNeptun() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }

        out.println("<br/><a href='welcome.jsp'>Vissza</a>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
