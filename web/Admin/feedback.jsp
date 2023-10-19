<%-- 
    Document   : feedback
    Created on : Oct 13, 2023, 12:43:00 PM
    Author     : hendrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="myPage col s8 offset-s1">
        <h1>Feedback</h1>

        <form action="CentralController" method="post" >
                <input type="hidden" name="action" value="admin"  />
                <input type="hidden" name="page" value="feedback"  />
                <i class="material-icons prefix">account_circle</i>          
                <input id="icon_prefix" type="text" name="name" class="validate">           
                <label for="icon_prefix">First Name</label>
                <input type="submit" name="button" value="Search By Name" />
            </form>

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
        </div>
    </body>
</html>
