package com.example.loginneptunprojekt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    // GLOBÁLIS statikus lista - minden felhasználó megosztja
    public static List<User> allUsers = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Formadatok lekérése
        String name = request.getParameter("name");
        String neptun = request.getParameter("neptun");

        // Validálás
        if (name == null || name.trim().isEmpty() || neptun == null || neptun.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Kérjük, töltsd ki az összes mezőt!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // Új user létrehozása
        User user = new User(name.trim(), neptun.trim());

        // GLOBÁLIS listához hozzáadás
        allUsers.add(user);

        // Session létrehozása és bejelentkezett user tárolása
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", user);

        // Átirányítás a welcome oldalra
        response.sendRedirect("welcome.jsp");
    }
}
