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
        <style>
            /*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
            */
            /* 
                Created on : Oct 19, 2023, 10:13:57 AM
                Author     : bolic
            */

            @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');


            body{
                margin: 0 ;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins',sans-serif;
                width: 100%;
                height: 100vh;
                background-image: url('https://images.pexels.com/photos/7778287/pexels-photo-7778287.jpeg');
                background-position: center;
                background-size: cover;
                color: #fff;
            }
            .container {
                margin:  auto;
                margin-top: 10%;
                width: 70%;
                padding: 20px;
            }

            h1 {
                text-align: center;
            }

            form {
                padding: 20px;
                border: 1px solid rgb(48, 120, 69);
                border-radius: 10px;
                transform: translate(-50% , -50%);
                background-image: url('https://images.pexels.com/photos/7778287/pexels-photo-7778287.jpeg') ;
                background-position: center;
                background-size: cover;
                position: absolute;
                top: 50%;
                left: 50%;
                width: 65%;
                height: 30%;
            }
            .signup{

                border-radius: 6px;

            }

            input[type="text"],
            input[type="password"] {
                width: 95%;
                padding: 5px;
                margin-bottom: 10px;
                border: none;
                outline: none;
                font-size: 20px;
                background: transparent;
                color: #fff;
                border-bottom: 2px solid #fff;
            }
            ::placeholder{
                color: #fff;
                font-size: 18px;
            }

            input[type="submit"] {

                background-color: #fff;
                color: #fff;
                padding: 10px;
                margin-left: 40%;
                background: fixed;
                border: 0.1ch solid #fff;
                outline: none;
                border-radius:3px;
                cursor: pointer;
                transition: 0.3s;
            }

            input[type="submit"]:hover {
                background-color: rgb(48, 120, 69);
                color: #fff;
            }

            input[type="submit"]:active{
                font-size: 15px;
            }

        </style>
        <script>
            function checkPassword() {
                if (document.getElementById("txtpassword").value !== document.getElementById("txtrepassword").value) {
                    alert("password is invalid");
                    return false;
                }
                return true;
            }

        </script>
    </head>
    <body>
        <div class="container">
            <h1>Sign Up</h1>
            <form action="CentralController" method="post" >
                <input type="hidden" name="action" value="signup" >
                <div class="signup">
                    <p><input type="text" name="txtemail" required=""  placeholder="Email"></p>
                    <p><input type="password" id="txtpassword" name="txtpassword" required="" placeholder="Password"></p>
                    <p><input type="password" id="txtrepassword" name="txtrepassword" required="" placeholder="Re-Password"></p>
                    <p><input type="submit" value="register" onclick="return checkPassword()"></p>
                    <%@include file="checkSignUp.jsp" %>
                </div>
            </form>
            
        </div>

    </body>
</html>

