<%-- 
    Document   : shipperPage
    Created on : Oct 10, 2023, 12:32:07 PM
    Author     : hendrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminCss.css" rel="stylesheet" type="text/css">
        <title>Shipper</title>
    </head>

    <body>
        <div class="background">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo" style="margin-left: 2%">Welcome Shipper</a>
                    <a href="CentralController" class="out" style="margin-left: 2%">Log Out</a>
                </div>
            </nav>

            <div class="row">
                <form action="CentralController" method="post">
                    <input type="hidden" name="action" value="shipper">
                    <ul class="myTable col s3">

                        <li><button type="submit" name="page" value="profile" class="myColumn">

                                <span class="myTitle">Manage Profiles</span>
                                <i class="material-icons">account_box</i>
                            </button></li>

                        <li ><button type="submit" name="page" value="order" class="myColumn">

                                <span class="myTitle">View Order</span>
                                <i class="material-icons">store</i>
                            </button></li>
                    </ul>
                </form>
                <%
                    String adPage = request.getParameter("page");
                    if (adPage == null) {
                        adPage = "welcome";
                    }

                %>


            </div>
        </div>    

    </body>
</html>
