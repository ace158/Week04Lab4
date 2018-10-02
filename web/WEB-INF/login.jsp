<%-- 
    Document   : login
    Created on : Oct 2, 2017, 12:12:26 PM
    Author     : NoahFerrier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Remember me login page</h1>
        <form action="login" method="post">
            Username: <input type="text" name="usrname" value="${username}"><br>
            Password: <input type="password" name="psswd" value="${password}"><br>
            <input type="submit" value="Login"><br>
            <input type="checkbox" name="remember">Remember me
        </form>
        <br>${message}
    </body>
</html>
