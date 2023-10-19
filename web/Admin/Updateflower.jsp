<%@page import="DTO.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Flowers"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flower Form</title>
    </head>
    <body>
        <div class="">
            <h1>Flower Form</h1>
            <form action="processFlower.jsp" method="post">
                <!-- Flower ID (int) -->
                <label for="flowerId">Flower ID</label>
                <input type="text" name="flowerId" id="flowerId"><br/>

                
                <label for="flowerName">Flower Name</label>
                <input type="text" name="flowerName" id="flowerName"><br/>

              
                <label for="flowerColor">Flower Color</label>
                <input type="text" name="flowerColor" id="flowerColor"><br/>

             
                <label for="flowerPrice">Flower Price :</label>
                <input type="text" name="flowerPrice" id="flowerPrice"><br/>

                
                <label for="status">Status</label>
                <input type="checkbox" name="status" id="status"><br/>

                
                <label for="importDate">Import Date</label>
                <input type="date" name="importDate" id="importDate"><br/>

                
                <label for="categoryId">Category ID</label>


                <select name='categoryId'>
                    <%
                        ArrayList<Category> list = DAO.FlowerDAO.getAllCategory();
                        
                        for (Category F : list) {
                    %>
                    <option value='<%= F.getCategory_id()%>'><%= F.getCategory_id()  %></option>
                    <%
                        }
                    %>
                </select>
          <br/>
                <label for="image">Image</label>
                <input type="text" name="image" id="image">

                <input type="submit" name="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
