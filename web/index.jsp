<%-- 
    Document   : index
    Created on : Oct 9, 2023, 8:38:34 PM
    Author     : hendrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        
        <title>Welcome!!!</title>
    </head>
    <body>
       

        <% 
           String URL = "CentralController";
           request.setAttribute("role", "welcome");
           request.getRequestDispatcher(URL).forward(request, response);
        %>
    </body>
</html>
