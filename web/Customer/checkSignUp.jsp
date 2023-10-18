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
    </head>
    <body>
        <h1>Sign Up Confirmation</h1>

        <%
            String email = request.getParameter("txtemail");
            String password = request.getParameter("txtpassword");
            if(email != null && password != null){
            try {
                // Kiểm tra xem tài khoản đã tồn tại trong cơ sở dữ liệu chưa
                Account account = AccountDAO.getAccount(email, password);

                if (account != null) {
        %>
        <p>Username is already taken. Please choose another one.</p>
        <a href='signupPage.jsp'>Sign Up</a>
        <%
        } else {
            // Tên người dùng chưa tồn tại
            String role = "CS"; // Gán vai trò mặc định "CS"
            int result = AccountDAO.insertAccount(email, password, role);

            if (result > 0) {
        %>
        <p>Account created successfully. You can now <a href='CentralController?action=welcome'>log in</a>.</p>
        <%
        } else {
        %>
        <p>Failed to create the account.</p>
        <%
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
}
else{}
        %>
    </body>
</html>
