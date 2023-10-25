<%-- 
    Document   : bandAccount
    Created on : Oct 25, 2023, 12:21:01 PM
    Author     : THY
--%>

<%@page import="DTO.Customers"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/flowerAdmin.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    
    <body>
        <form action="checkBandAccount.jsp" method="post">
         <select name='Staus'>
                    <%
                        ArrayList<Customers> list = DAO.CustomerDAO.getAll();
                        
                        for (Customers F : list) {
                    %>
                    <option value='<%= F.getStaus()%>'><%= F.getStaus()%></option>
                    <%
                        }
                    %>
                </select>
        </form>
    </body>
</html>
