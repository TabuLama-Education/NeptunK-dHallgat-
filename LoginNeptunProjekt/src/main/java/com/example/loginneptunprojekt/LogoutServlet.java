package com.example.loginneptunprojekt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session lekérése és törlése
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Visszairányítás a bejelentkezési oldalra
        response.sendRedirect("index.jsp");
    }
}
