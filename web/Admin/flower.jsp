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

        <title>JSP Page</title>
    </head>
    <body>
        <div class="myPage col s8 offset-s1">
        <h1>Flower</h1>
        <form action="CentralController" method="post" >
                <input type="hidden" name="action" value="admin"  />
                <input type="hidden" name="page" value="flower"  />
                <i class="material-icons prefix">account_circle</i>          
                <input id="icon_prefix" type="text" name="name" class="validate">           
                <label for="icon_prefix">First Name</label>
                <input type="submit" name="button" value="Search By Name" />
            </form>
        
         <table>
       <%
                    String name = request.getParameter("name");
                     
                    if (name != null) {
                        ArrayList<Flowers> lists = DAO.FlowerDAO.getFlowerByName(name);

                        for (Flowers f : lists) {


                %>

                <tr>
                    <td><%= f.getFlower_id()%></td>
                    <td><%= f.getFlower_name()   %></td>
                    <td><%= f.getFlower_color()   %></td>
                    <td><%= f.getFlower_price()   %></td>
                    <td><%= f.isStatus()      %></td>
                    <td><%=  f.getImport_date()  %></td>
                    <td><%= f.getCategory_id()   %></td>
                    <td><%=f.getImage()  %></td>
                    

                </tr>

                <% }
                    } 
         else  {
       
                       ArrayList<Flowers> list = DAO.FlowerDAO.getFlower();
               for (Flowers m : list) {
                            
         %>
                     <tr>
                    <td><%= m.getFlower_id()%></td>
                    <td><%= m.getFlower_name()   %></td>
                    <td><%= m.getFlower_color()   %></td>
                    <td><%= m.getFlower_price()   %></td>
                    <td><%= m.isStatus()      %></td>
                    <td><%= m.getImport_date()  %></td>
                    <td><%= m.getCategory_id()   %></td>
                    <td><%=m.getImage()  %></td>
                    <td><a href="Updateflower.jsp" >update</a></td>
                    

                </tr>
         
         <% } 
            }%>
        
         </table>
           
        
        
        
        
        </div>
    </body>
</html>
