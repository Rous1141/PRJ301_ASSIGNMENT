<%-- 
    Document   : order
    Created on : Oct 13, 2023, 12:42:47 PM
    Author     : hendrix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/orderAdmin.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="myPage col s8 offset-s1">

            <div class="myProfile">
                <h1>Assign A Shipper To The Order</h1>
                <form class='col s6' id="name" action="CentralController" method="post" >
                    <input type="hidden" name="action" value="admin"  />
                    <input type="hidden" name="page" value="order"  />
                    <input type="hidden" name="page" value="shipper"  /> 
                    <input class=" col s6" id="icon_prefix" type="text" name="name" class="validate"  placeholder="Search By Name">           
                    <button class="btn waves-effect waves-light" type="submit" form="name"><i class="material-icons prefix">search</i></button>
                </form>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Status</th>
                            <th>Name</th>
                            <th>On Order</th>
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
        </div>
    </body>
</html>
