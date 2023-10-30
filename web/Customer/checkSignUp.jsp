<%-- 
    Document   : checkSignUp
    Created on : Oct 18, 2023, 10:28:11 AM
    Author     : bolic
--%>

<%@page import="DAO.AccountDAO"%>
<%@page import="DTO.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check SignUp</title>
        <style>
            .notice{
                width: 100%;
                text-align: center;
            }
        </style>
    </head>
    <body>


        <%
            String button = request.getParameter("btnAction");
            if (button == null) {
                button = "";
            }
            switch (button) {
                case "Sign Up": {
                    String email = request.getParameter("txtemail");
                    
                    String password = request.getParameter("txtpassword");
                    if (email != null && password != null) {
                        try {
                            // Kiểm tra xem tài khoản đã tồn tại trong cơ sở dữ liệu chưa
                            Account account = AccountDAO.getAccount(email, password);

                            if (account != null) {
        %>
                                    <p class="notice">Username is already taken. Please choose another one.</p>
                                    <a href='CentralController'>Return</a>
        <%
                            } else {
                                // Tên người dùng chưa tồn tại
                                String role = "CS"; // Gán vai trò mặc định "CS"
                                int result = AccountDAO.insertAccount(email, password, role);

                                if (result > 0) {
                                    request.setAttribute("role", "information");
                                    request.getRequestDispatcher("../CentralController").forward(request, response);
                                } else {
                                    out.print("Fail To Register Your Account");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {

                    }
                }
                case "Register": {
                    
                    String email = request.getParameter("txtemail");
                    String name = request.getParameter("name");
                    String birthday = request.getParameter("birth");
                    String phone = request.getParameter("phone");
                    String address = request.getParameter("address");
                    Boolean Status = true;
                    String order = "0";

                    int flag = 0;

                    int result = DAO.CustomerDAO.CreateCus(email, name, birthday, phone, address, Status, order, flag);
                    if (result > 0) {
                        request.setAttribute("message", "createSuccess");
                        request.setAttribute("role", "welcome");
                        request.getRequestDispatcher("../CentralController").forward(request, response);
                    } else {
                        out.print("Fail To Register Your Personal Infomation ");
                    }
                }
            }

        %>
    </body>
</html>
