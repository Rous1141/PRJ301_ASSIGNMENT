<%-- 
    Document   : feedback
    Created on : Oct 13, 2023, 12:43:00 PM
    Author     : hendrix
--%>

<%@page import="DAO.FeedbackDAO"%>
<%@page import="DTO.Feedbacks"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/feedbackAdmin.css" rel="stylesheet" type="text/css"/>
        <script type = "text/javascript"  
                src = "https://code.jquery.com/jquery-2.1.1.min.js">
        </script>   
        <title>JSP Page</title>
    </head>
    <body>
        <div class="myPage col s8 offset-s1">
            <div class="myProfile">
                <h1>Feedback From Customer</h1>

                <form class='col s6' id="name" action="CentralController" method="post" >
                    <input type="hidden" name="action" value="admin"  />
                    <input type="hidden" name="page" value="feedback"  /> 
                    <input class=" col s6" id="icon_prefix" type="text" name="cusID" class="validate"  placeholder="Search By Customer ID">           
                    <button class="btn waves-effect waves-light" type="submit" form="name"><i class="material-icons prefix">search</i></button>
                </form>

                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Customer ID</th>
                            <th>Submit Date</th>
                            <th>Rating</th>
                            <th>Content</th>
                        </tr>
                    </thead>

                    <tbody>
                        <%
                            ArrayList<Feedbacks> feedbackList = FeedbackDAO.getAll();
                            String cusID = request.getParameter("cusID") ;
                            if(cusID != null && cusID!=""){feedbackList = FeedbackDAO.getFeedbackByCusID(Integer.parseInt(cusID));}
                            for (Feedbacks feed : feedbackList) {
                        %>
                        <tr>
                            <td><%= feed.getOrder_id()%></td>
                            <td><%= feed.getCustomer_id()%></td>
                            <td><%= feed.getFeedback_date()%></td>
                            <td><%= feed.getRating()%></td>
                            <td>
                                <ul class="collapsible" data-collapsible="accordion" style="color: white"> 
                                    <li> 
                                        <div class="collapsible-header teal accent-4 waves-effect waves-light "> 
                                            View Content
                                        </div> 
                                        <div style="color: black" class="collapsible-body"> 
                                            <p><%= feed.getFeedback_content()%><p>
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
