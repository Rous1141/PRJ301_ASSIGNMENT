<%-- 
    Document   : login
    Created on : Oct 9, 2023, 8:38:52 PM
    Author     : hendrix
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/LoginCSS.css" rel="stylesheet" type="text/css"/>

        <script src="https://kit.fontawesome.com/c9f5871d83.js" crossorigin="anonymous"></script>

        <title>Login Flower Store</title>
    </head>
    <body>

        <!--        <header class="header">
                    
                    <nav class="navi">
                        <a href="#">Home</a>
                        <a href="#">About</a>
                        <a href="#">Contract</a>
                        <a href="#">Service</a>
                    </nav>
                    <div class="search">
                        <input type="text" placeholder="Search ...">
                        <a><i class="fa-solid fa-magnifying-glass"></i></a>
                    </div>
                    
                </header>-->
        <div class="background"></div>
        <section class="home">
            <div class="content">
                <a href="#" class="Logo_Login">Flower Store</a>
                <h2>Welcome !</h2>
                <h3>Store Buy Flower</h3>
                <pre>Flowers can bring people happiness and heal all mental and physical wounds.</pre>
                <div class="icon">
                    <i class="fa-brands fa-instagram"></i>
                    <i class="fa-brands fa-facebook"></i>
                    <i class="fa-brands fa-tiktok"></i>
                    <i class="fa-brands fa-github"></i>
                </div>

            </div>
            <div class="Login">
                <div class="form">
                    <form method="POST" action="CentralController">
                        <div class="input">
                            <input type="hidden" name="action" value="welcome">
                            <input type="text" class="input1" name="email" placeholder="Email" value="" required>
                            <i class="fa-solid fa-envelope"></i>
                        </div>
                        <div class="input">
                            <input type="password" class="input1" name="pass" placeholder="Password" value="" required>
                            <i class="fa-solid fa-lock"></i>
                        </div>
                        <div class="check">
                            <label><input type="checkbox">Remember me</label>
                            <a href="#">Forgot password?</a>
                        </div>
                        <div class="button">
                            <button class="btnLogin">Sign In</button>
                        </div>
                        <%@include file="checkLogin.jsp"%>
                    </form>
                    <div class="Regsiter">

                        <form class="signUp" id="signUp" method="POST" action="CentralController">
                            <p>Don't have an account?</p>
                            <input type="hidden" name="action" value="signup"/>
                            <button class="btn" type="submit" form="signUp">Sign Up</button>
                        </form>

                    </div>
                </div>
            </div>
        </section>
    </body>
</html>