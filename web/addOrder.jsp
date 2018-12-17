<%-- 
    Document   : addCustomizeData
    Created on : Nov 26, 2018, 12:46:12 AM
    Author     : user
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="da.OrderDA"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="domain.CustOrder"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Order</title>
    </head>
    <body>
    
<%
    Calendar now = Calendar.getInstance();    
    int day = now.get(Calendar.DAY_OF_MONTH);
    int month = now.get(Calendar.MONTH) + 1;
    int year = now.get(Calendar.YEAR);
                String orderDate = day +"/"+ month +"/"+ year;
                Integer tempid = 2001;            
                Integer newid = tempid;
               
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                String method = request.getParameter("pmethod");
                Integer custid = Integer.parseInt(request.getParameter("user"));
               
               
             
                CustOrder order = new CustOrder(newid,name,email,address,city,state,zip,orderDate,method,custid);
                OrderDA oDA = new OrderDA();
                ResultSet rs = oDA.getQuery();
               
                oDA.addOrderRecord(order);
        %>
               
        <p>Order Successfully!</p>
        <a href="shop.jsp"><button>Back</button></a>
    </body>
</html>
