<%-- 
    Document   : signup
    Created on : Oct 9, 2023, 8:39:11 PM
    Author     : hendrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function checkPassword(){
                if(document.getElementById("txtpassword").value!==document.getElementById("txtrepassword").value){
                    alert("password is invalid");
                    return false;
                }
                return true;
            }
            
        </script>
    </head>
    <body>
        <h1>Sign Up</h1>
        <form action="checkSignUp.jsp" method="post" >
            <p><input type="text" name="txtemail" required="" >Email</p>
            <p><input type="password" id="txtpassword" name="txtpassword" required="">Password</p>
            <p><input type="password" id="txtrepassword" name="txtrepassword" required="">Re-Password</p>
            <p><input type="submit" value="register" onclick="return checkPassword()"></p>
        </form>
        <%@include file="checkSignUp.jsp" %>
    </body>
</html>

