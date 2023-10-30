



<%@page import="DAO.AdminDAO"%>
<%@page import="DTO.Admin"%>
<%@page import="DTO.Login"%>
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
        <link href="css/orderAdmin.css" rel="stylesheet" type="text/css"/>

        <title>Admin</title>
    </head>

    <body>
        <div class="background">
            <nav>
                <%
                    String role = (String) session.getAttribute("role");
                    Login user = (Login) session.getAttribute("user");
                    Admin result = AdminDAO.getAccount(user.getEmail());

                    if (role == null) {
                        role = "-1";
                    }
                    if (!role.equalsIgnoreCase("AD") || result == null) {
                        request.setAttribute("role", "-1"); //Send You To Error Page
                        request.getRequestDispatcher("../CentralController").forward(request, response);
                    }
                %>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo" style="margin-left: 2%">Welcome Admin <%= result.getName()%></a>
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
                    String adPage = request.getParameter("page"); //Making it feel like the Page switch seemlessly - which it is NOT. This is NOT REACT, this is a hack (don't do what I do)
                    String attPage = (String) request.getAttribute("page");  //Making it feel like the Page switch seemlessly - which it is NOT. This is NOT REACT, this is a hack (don't do what I do)

//get Atributte to get quickly to Other Page Automatically after CRUD
                    if (attPage != null) {
                        adPage = attPage;
                    }
                    if (adPage == null) {
                        adPage = "";
                    }

                    switch (adPage) {
                        case "": {
                %> <%@include file="dashboard.jsp" %> <%                                    ;
                        ;
                        break;
                    }

                    case "profile": {
                %> <%@include file="customerProfile.jsp" %>  <%                        ;
                        break;
                    }
                    case "flower": {
                %> <%@include file="flower.jsp" %> <%                        ;
                        break;
                    }
                    case "order": {
                %> <%@include file="order.jsp" %> <%                        break;
                    }

                    case "shipper": {
                %> <%@include file="shipper.jsp" %> <%                        break;
                    }

                    case "orderDetail": {
                %> <%@include file="orderDetail.jsp" %> <%                        break;
                    }

                    case "feedback": {
                %> <%@include file="feedback.jsp" %> <%
                        break;
                    }
                    case "flowerupdate": {
                %> <%@include file="updateFlower.jsp" %> <%                        break;
                    }

                    case "checkUpdateFlo": {
                %> <%@include file="checkUpdateFlo.jsp" %> <%                        break;
                    }

                    case "checkUpdateOrder": {
                %> <%@include file="updateOrder.jsp" %> <%                        break;
                    }

                    case "checkUpdateStatus": {
                %> <%@include file="checkUpdateStatus.jsp" %> <%                        break;
                    }

                    default: {
                %> <%@include file="dashboard.jsp" %> <%
                            break;
                        }
                    }

                %>
            </div>
        </div>    

    </body>
</html>
