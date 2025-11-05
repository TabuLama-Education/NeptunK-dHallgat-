<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Üdvözlet</title>
</head>
<body>
<center>
    <h2>Üdvözlünk!</h2>
    <%
        Object obj = session.getAttribute("currentUser");
        String currentUserName = "Ismeretlen";

        if (obj != null) {
            // Reflection segítségével kinyerjük a nevet
            try {
                currentUserName = (String) obj.getClass().getMethod("getName").invoke(obj);
            } catch (Exception e) {
                currentUserName = "Hiba";
            }
        }
    %>
    <h3>Bejelentkezve mint: <b><%= currentUserName %></b></h3>

    <form action="users" method="get">
        <button type="submit">Felhasználók megtekintése</button>
    </form>

    <br/>

    <form action="logout" method="post">
        <button type="submit">Kijelentkezés</button>
    </form>
</center>
</body>
</html>
