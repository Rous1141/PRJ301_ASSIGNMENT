<%-- 
    Document   : order
    Created on : Oct 13, 2023, 12:42:47 PM
    Author     : hendrix
--%>

<%@page import="DAO.OrderDAO"%>
<%@page import="DTO.Orders"%>
<%@page import="DAO.ShipperDAO"%>
<%@page import="DTO.Shippers"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        <script type = "text/javascript"  
                src = "https://code.jquery.com/jquery-2.1.1.min.js">
        </script>   
    </head>
    <body>
        <--<!-- WARNING!!! THIS PAGE IS ONLY UI COMPLETED, 
           DUE TO SHIPPER FUNCTION IS NOT DONE, 
           DO NOT ASSIGN ORDER TO SHIPPER
           OR YOU MUST GO TO SSMS AND SWITCH ORDER TO TRUE MANUALLY
           NOTE: 1 SHIPPER 1 ORDER
        -->
        <div class="myPage col s8 offset-s1">

            <div class="myProfile">
                <h1>Assign A Shipper To The Order</h1>
                <form class='col s3' id="name" action="CentralController" method="post" >
                    <input type="hidden" name="action" value="admin"  />
                    <input type="hidden" name="page" value="shipper"  /> 
                    <button class="btn waves-effect waves-light">View Shipper's Profiles</button>
                </form>
                 <form class='col s3' id="name" action="CentralController" method="post" >
                    <input type="hidden" name="action" value="admin"  />
                    <input type="hidden" name="page" value="orderDetail"  /> 
                    <button class="btn waves-effect waves-light">View Order's Detail</button>
                </form>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Status</th>
                            <th>On Order?</th>
                            <th>Assign Order</th>
                        </tr>
                    </thead>


                    <tbody>
                        <%
                            ArrayList<Shippers> shipList = new ArrayList<>();
                            shipList = ShipperDAO.getAll();
                            ArrayList<Orders> orderList = new ArrayList<>();
                            orderList = OrderDAO.getAllOrders();
                            String shipOrder = "disabled"; //check if shipper is already on shift
                            String className = "collapsible"; // If shipper is already on duty we will disable the order button
                            String color = "teal accent-4"; //style the disabled color teal accent-4
                            for(Shippers ship : shipList){
                        %>
                        <tr>

                            <td><%= ship.getName() %></td>
                            <td><%= ship.getAddress() %></td>
                            <td><% if(ship.isStatus()){%>Active<%}else{%>Inactive<%} %></td>
                            <td><% if(ship.getOrder_assigned()!= 0){%>Busy With Order: <%= ship.getOrder_assigned() %> <% }else{ shipOrder = "";
                                            %>Shipper is free<%}  %></td>
                            <td>
                                
                                <ul <%= shipOrder %> class="<% if(ship.getOrder_assigned()== 0){ color = "teal accent-4"; %> <%= className %> <% 
                                                         }else{
                                                              color = "grey";
                                                         } %>" 
                                            
                                                     data-collapsible="accordion" style="color: white"> 
                                    <li> 
                                        <div class="collapsible-header <%= color %> waves-effect waves-light "> 
                                            Orders
                                        </div> 
                                        <div class="collapsible-body"> 
                                            <% 
                                                for(Orders order : orderList){
                                                if(order.getStatus() == false){shipOrder = "disabled" ;}
                                                else{shipOrder="";}
                                            %>
                                            <form method="POST" action="CentralController">
                                                <input type="hidden" name="action" value="admin"  />
                                                <input type="hidden" name="page" value="checkUpdateOrder"  />
                                                <input type="hidden" name="orderID" value="<%= order.getOrder_id() %>"  />
                                                <input type="hidden" name="shipper" value="<%= ship.getEmail() %>"  />
                                                <button class="btn waves-effect waves-light" type="submit"
                                                        <%= shipOrder %>
                                                        >Order: <%= order.getOrder_id() %></button>
                                            </form>
                                            <br>
                                            <% 
                                                }
                                            %>
                                        </div> 
                                    </li> 
                                </ul>
                               
                            </td>
                            
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <script src= 
                "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js">
        </script> 
    </body>
</html>
