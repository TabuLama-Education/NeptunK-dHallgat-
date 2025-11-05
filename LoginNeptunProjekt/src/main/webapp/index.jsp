<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Bejelentkezés</title>
</head>
<body>
<center>
    <h2>Bejelentkezési Oldal</h2>

    <form action="login" method="post">
        <input type="text" name="name" placeholder="Név" required/>
        <br/><br/>
        <input type="text" name="neptun" placeholder="Neptun kód" required/>
        <br/><br/>
        <button type="submit">Belépés</button>
    </form>

    <p style="color:red;">
        <% String error = (String) request.getAttribute("errorMessage");
            if (error != null) out.print(error);
        %>
    </p>
</center>
</body>
</html>
