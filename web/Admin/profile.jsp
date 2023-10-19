<%-- 
    Document   : profile
    Created on : Oct 13, 2023, 12:42:26 PM
    Author     : hendrix
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Customers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/profileAdmin.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="myPage col s8 offset-s1">
            <div class="myProfile">
                <h1>Profile</h1>
                <form class='col s6' id="mail" action="CentralController" method="post" >
                    <input type="hidden" name="action" value="admin"  />
                    <input type="hidden" name="page" value="profile"  />
                    <input class=" col s10" id="icon_prefix" type="text" name="mail" class="validate" placeholder="Search By Mail">   
                    <button class="btn waves-effect waves-light" type="submit" form="mail"><i class="material-icons prefix">search</i></button>


                </form>
                <form class='col s6' id="name" action="CentralController" method="post" >
                    <input type="hidden" name="action" value="admin"  />
                    <input type="hidden" name="page" value="profile"  /> 
                    <input class=" col s10" id="icon_prefix" type="text" name="name" class="validate"  placeholder="Search By Name">           
                    <button class="btn waves-effect waves-light" type="submit" form="name"><i class="material-icons prefix">search</i></button>
                </form>

                <div class='table col s12'>  
                    <table class="highlight">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Mail</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Status</th>
                                <th>Order</th>
                                <th>Ban Account</th>
                                
                            </tr>
                        </thead>

                        <%
                            String name = request.getParameter("name");
                            String mail = request.getParameter("mail");
                            if (name != null) {
                                ArrayList<Customers> list = DAO.CustomerDAO.getCustomersByEmail(mail);
                                for (Customers e : list) {


                        %>

                        <tr>
                            <td><%= e.getName()%></td>
                            <td><%= e.getEmail()%></td>
                            <td><%= e.getPhone_number()%></td>
                            <td><%= e.getAddress()%></td>
                            <td><%= e.getStaus()%></td>
                            <td><%= e.getOrders()%></td>
                            <td><div><button class="btn waves-effect waves-light" type="submit"><i class="material-icons">warning</i></button></div></td>

                        </tr>

                        <% }

                        } else if (mail != null) {
                            ArrayList<Customers> list = DAO.CustomerDAO.getCustomersByEmail(mail);
                            for (Customers e : list) {


                        %>

                        <tr>
                            <td><%= e.getName()%></td>
                            <td><%= e.getEmail()%></td>
                            <td><%= e.getPhone_number()%></td>
                            <td><%= e.getAddress()%></td>
                            <td><%= e.getStaus()%></td>
                            <td><%= e.getOrders()%></td>
                            <td><div><button class="btn waves-effect waves-light" type="submit"><i class="material-icons">warning</i></button></div></td>

                        </tr>

                        <% }

                        } else {
                            ArrayList<Customers> List = DAO.CustomerDAO.getAll();
                            for (Customers e : List) {
                        %>
                        <tr>
                            <td><%= e.getName()%></td>
                            <td><%= e.getEmail()%></td>
                            <td><%= e.getPhone_number()%></td>
                            <td><%= e.getAddress()%></td>
                            <td><%= e.getStaus()%></td>
                            <td><%= e.getOrders()%></td>
                            <td><div><button class="btn waves-effect waves-light" type="submit"><i class="material-icons">warning</i></button></div></td>

                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
