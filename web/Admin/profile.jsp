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

        <title>JSP Page</title>
    </head>
    <body>
        <div class="myPage col s8 offset-s1">

        <h1>Profile</h1>
        <table>
        <thead>
          <tr>
              <th>Name</th>
              <th>Item Name</th>
              <th>Item Price</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Alvin</td>
            <td>Eclair</td>
            <td>$0.87</td>
          </tr>
          <tr>
            <td>Alan</td>
            <td>Jellybean</td>
            <td>$3.76</td>
          </tr>
          <tr>
            <td>Jonathan</td>
            <td>Lollipop</td>
            <td>$7.00</td>
          </tr>
        </tbody>
      </table>

            <h1>Profile</h1>
            <form action="CentralController" method="post" >
                <input type="hidden" name="action" value="admin"  />
                <input type="hidden" name="page" value="profile"  />
                <i class="material-icons prefix">account_circle</i>          
                <input id="icon_prefix" type="text" name="mail" class="validate">           
                <label for="icon_prefix">First Name</label>
                <input type="submit" name="button" value="Search By Mail" />
            </form>
            <form action="CentralController" method="post" >
                <input type="hidden" name="action" value="admin"  />
                <input type="hidden" name="page" value="profile"  />
                <i class="material-icons prefix">account_circle</i>          
                <input id="icon_prefix" type="text" name="name" class="validate">           
                <label for="icon_prefix">First Name</label>
                <input type="submit" name="button" value="Search By Name" />
            </form>
            <table>
                
                 <%
                    String name = request.getParameter("name");
                     String mail = request.getParameter("mail");
                    if (name != null) {
                        ArrayList<Customers> list = DAO.CustomerDAO.getCustomersByEmail(mail);

                        for (Customers e : list) {


                %>

                <tr>
                    <td><%= e.getCustomer_id()%></td>
                    <td><%= e.getEmail()%></td>
                    <td><%= e.getName()%></td>
                    <td><%= e.getBirth_date()%></td>
                    <td><%= e.getPhone_number()%></td>
                    <td><%= e.getAddress()%></td>
                    <td><%= e.getStaus()%></td>
                    <td><%= e.getOrders()%></td>

                </tr>

                <% }

                    }else if (mail != null) {
                        ArrayList<Customers> list = DAO.CustomerDAO.getCustomersByEmail(mail);

                        for (Customers e : list) {


                %>

                <tr>
                    <td><%= e.getCustomer_id()%></td>
                    <td><%= e.getEmail()%></td>
                    <td><%= e.getName()%></td>
                    <td><%= e.getBirth_date()%></td>
                    <td><%= e.getPhone_number()%></td>
                    <td><%= e.getAddress()%></td>
                    <td><%= e.getStaus()%></td>
                    <td><%= e.getOrders()%></td>

                </tr>

                <% }

                    }else{
                    ArrayList<Customers> List = DAO.CustomerDAO.getAll();
                    for (Customers d : List) {
                %>
                <tr>
                    <td><%= d.getCustomer_id()%></td>
                    <td><%= d.getEmail()%></td>
                    <td><%= d.getName()%></td>
                    <td><%= d.getBirth_date()%></td>
                    <td><%= d.getPhone_number()%></td>
                    <td><%= d.getAddress()%></td>
                    <td><%= d.getStaus()%></td>
                    <td><%= d.getOrders()%></td>

                </tr>
                <%  
                    }
                        }
                %>
                

                

            </table>





        </div>
    </body>
</html>
