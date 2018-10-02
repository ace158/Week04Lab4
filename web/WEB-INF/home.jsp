<%-- 
    Document   : home
    Created on : Oct 2, 2017, 12:12:53 PM
    Author     : NoahFerrier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        <h1>Home Page</h1><br>
        <form action="" method="get">
        Hello, ${User.username} <br><br>
        <input type="hidden" name="action" value="logout">
        <a href="login?action=logout">Logout</a> 
        </form>
    </body>

</html>
