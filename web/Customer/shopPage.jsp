<%-- 
    Document   : shopPage
    Created on : Oct 9, 2023, 8:39:39 PM
    Author     : hendrix
--%>

<%@page import="DAO.FlowerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Flowers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <title>Shopping</title>
    </head>
    <body>
        <%@include file="../Components/navBar.jsp" %> 
        <div class="myContainer">
           
            <%
                ArrayList<Flowers> result = new ArrayList<>();
                result = FlowerDAO.getFlower();
                for (Flowers flower : result) {
            %>

            <div class="row" style="display: inline">
                <div class="col s3" >
                    <div class="card">
                        <div class="card-image">
                            <img src="<%= flower.getImage() %>">
                            <span class="card-title"><%= flower.getFlower_name() %></span>
                        </div>
                        <div class="card-content">
                            <p>Import Date: <%= flower.getImport_date() %></p>
                            <p>Color: <%= flower.getFlower_color() %></p>
                            <p>Price <%= flower.getFlower_price() %>$</p>
                        </div>
                        <div class="card-action">
                            <a href="#">Add To Cart</a>
                        </div>
                    </div>
                </div>
            </div>

            <%
                }
            %>
        </div>
        <%@include file="../Components/footer.jsp" %> 
    </body>
</html>
