<%@ page import ="java.sql.*" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String connectionUrl = "jdbc:derby://localhost:1527/orderdb";
    String userId = "nbuser";
    String password = "nbuser";
    
    try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;
    
    String username = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
   
   
   connection = DriverManager.getConnection(connectionUrl, userId, password);
   statement=connection.createStatement();
  
    
    String sql ="SELECT * FROM Customer";

            resultSet = statement.executeQuery(sql);
    
    while (resultSet.next()) {
       if(username.equals(resultSet.getString("cust_id")) && pwd.equals(resultSet.getString("password"))){
        session.setAttribute("cust_id",username );
        String user = resultSet.getString("cust_id");
        session.setAttribute("user",user );
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("shop.jsp");
    } 
    } out.println("Invalid password <a href='Login.jsp'>try again</a>");
%>