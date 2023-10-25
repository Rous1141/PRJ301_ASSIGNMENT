



<%-- 
    Document   : adminPage
    Created on : Oct 9, 2023, 8:39:45 PM
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
       
        <title>Admin</title>
    </head>

    <body>
        <div class="background">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo" style="margin-left: 2%">Welcome Admin</a>
                    <a href="CentralController" class="out" style="margin-left: 2%">Log Out</a>
                </div>
            </nav>

            <div class="row">
                <form action="CentralController" method="post">
                    <input type="hidden" name="action" value="admin">
                    <input type="hidden" name="name" value="">
                    <input type="hidden" name="mail" value="">
                    <ul class="myTable col s3">

                        <li><button type="submit" name="page" value="profile" class="myColumn">

                                <span class="myTitle">Manage Profiles</span>
                                <i class="material-icons">account_box</i>
                            </button></li>

                        <li ><button type="submit" name="page" value="flower" class="myColumn">

                                <span class="myTitle">Manage Flowers</span>
                                <i class="material-icons">store</i>
                            </button></li>

                        <li><button type="submit" name="page" value="order" class="myColumn">

                                <span class="myTitle">Manage Orders</span>
                                <i class="material-icons">insert_chart</i>
                            </button></li>

                        <li><button type="submit" name="page" value="feedback" class="myColumn">

                                <span class="myTitle">Read Feedback</span>
                                <i class="material-icons">feedback</i>
                            </button>  </li>

                    </ul>
                </form>
                <%
                    String adPage = request.getParameter("page");
                    if (adPage == null) {
                        adPage = "";
                    }
                    switch (adPage) {
                        case "": {
                %> <%@include file="dashboard.jsp" %> <%                                    ;
                        ;break;

                    }

                    case "profile": {
                %> <%@include file="profile.jsp" %>  <%

                        ;break;
                    }
                    case "flower": {
                %> <%@include file="flower.jsp" %> <%
                        ;break;
                   }
                    case "order": {
                %> <%@include file="order.jsp" %> <%
                        break;
}

                    case "feedback": {
                %> <%@include file="feedback.jsp" %> <%
                            break;
                        }
                    
                       case "bandAccount": {
                %> <%@include file="bandAccount.jsp" %> <%
                            break;
                        }
                       case "checkBandAccount": {
                %> <%@include file="bandAccount.jsp" %> <%
                            break;
                        }
                    }

                %>
            </div>
        </div>    

    </body>
</html>
