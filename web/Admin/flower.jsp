<%-- 
    Document   : flower
    Created on : Oct 13, 2023, 12:42:39 PM
    Author     : hendrix
--%>


<%@page import="DTO.Flowers"%>
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
        <div class="myPage col s8 offset-s1">

            <div class="myProfile">
                <h1>Flower</h1>


                <form class='form col s6' id="name" action="CentralController" method="post" >
                    <input  type="hidden" name="action" value="admin"  />
                    <input type="hidden" name="page" value="flower"  /> 
                    <input class=" col s6"  id="icon_prefix" type="text" name="name" class="validate"  placeholder="Search By Name">           
                    <button class="btn waves-effect waves-light" type="submit" form="name"><i class="material-icons prefix">search</i></button>
                </form>

                <div class='table col s12'>  
                    <table class="highlight">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Id</th>
                                <th>Price</th>
                                <th>Status</th>
                                <th>Category</th>
                                <th>Update</th>
                            </tr>
                        </thead>

                        <%
                            String name = request.getParameter("name");
                            if (name != null) {
                                ArrayList<Flowers> lists = DAO.FlowerDAO.getFlowerByName(name);

                                for (Flowers f : lists) {


                        %>
                        <tbody>
                            <tr>


                                <td><div><%= f.getFlower_name()%></div></td>
                                <td><div><%= f.getFlower_id()%> </div></td>
                                <td><div><%= f.getFlower_price()%></div></td>
                                <td><div><%= f.isStatus()%> </div></td>
                                <td><div><%= f.getCategory_id()%></div></td>
                                <td><div><button class="btn waves-effect waves-light" type="submit"><i class="material-icons">description</i></button></div></td>
                            </tr>
                        </tbody>


                        <% }
                        } else {

                            ArrayList<Flowers> list = DAO.FlowerDAO.getFlower();
                            for (Flowers m : list) {

                        %>
                        <tbody>
                            <tr>
                                <td><div><%= m.getFlower_name()%></div></td>
                                <td><div><%= m.getFlower_id()%> </div></td>
                                <td><div><%= m.getFlower_price()%></div></td>
                                <td><div><%= m.isStatus()%> </div></td>
                                <td><div><%= m.getCategory_id()%></div></td>
                                <td><div><button class="btn waves-effect waves-light" type="submit"><i class="material-icons">description</i></button></div></td>
                            </tr>
                        </tbody>
                    </table>
                    <% }
                        }%>

                </div>
            </div>

        </div>
    </body>
</html>
