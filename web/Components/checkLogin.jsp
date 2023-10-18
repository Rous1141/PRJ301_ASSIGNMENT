<%-- 
    Document   : checkLogin
    Created on : Oct 17, 2023, 12:18:31 PM
    Author     : hendrix
--%>

<%@page import="DAO.LoginDAO"%>
<%@page import="DTO.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checking Page</title>
    </head>
    <body>
        <% 
             String email = request.getParameter("email");
             String pass = request.getParameter("pass");
             
             Login result = LoginDAO.LogIn(email, pass);
             
             String URL = "../CentralController";
             String role = "";
             if(result != null){
              session = request.getSession(); // GET CURRENT USER SESSION
              session.setAttribute("role", result.getRole());
            
                switch(result.getRole()){
                case "AD":{role = "admin";break;}
                case "SH":{role = "shipper";break;}
                case "CS":{role = "shop";break;}
            }
                request.setAttribute("role", role);
                request.getRequestDispatcher(URL).forward(request, response);
            }
            else{
                if(email==null && pass==null){
            %>
                <h3 style="color: yellow">Please Log In To Continue</h3>
            <%
                }
                else{
                    %>
                 <h3>User Doesn't Exist</h3>
                    <%
                }
            }
        %>
    </body>
</html>
