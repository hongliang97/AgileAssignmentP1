
<%@page import="java.util.ArrayList"%>
<%@ page import="classes.Item" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Shopping Cart - Check out</title>
        <style type="text/css">
            
            <!--
            .container {
                height: 850px;
                width: 900px;
                margin:auto;
            }
            .headbanner {
                float: left;
                height: 80px;
                width: 900px;
                vertical-align:middle;
                background-color:#ffc9db;


            } 
            .container .headbanner h1 {
                font-family: Verdana, Geneva, sans-serif;
                color: #660c2b;

            }
            .mycontent {
                float: left;
                height: 650px;
                width: 900px;
            }
            
            td{
                font-family:Verdana, Geneva, sans-serif;
                font-weight:normal;
                font-size:14px;

            }

            -->
        </style>
    </head>

    <body style="margin:0; padding:0">
        <form action="purchase" method="post">   
            <%
                ArrayList it_list = (ArrayList) session.getAttribute("itemlist");

            %>
            <div class="container">

                <div class="headbanner">
                    <h1 style="display:inline"><center>
                         Florist Shop
                        </center></h1>
                </div>
                <div class="mycontent">
                    <a style="color:#660c2b; font-family:Verdana, Geneva, sans-serif; font-size:20px; font-weight:bold">Checkout My Cart</a><br />
                    <table width="500px">
                        <%
                            for (int i = 0; i < it_list.size(); i++) {
                                classes.Item itm = (Item) it_list.get(i);
                        %>
                        <tr>
                            <td><%out.print(itm.name);%></td> 
                            <td><%out.print(itm.price);%></td> 
                        </tr>
                        <% }%>
                        <tr>
                            <td style="font-weight:bold">My Total</td><td style="font-weight:bold">$[<%out.print(session.getAttribute("total"));%>]</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold">Payment Method</td>
                            
                        </tr>
                        
                        <tr>
                            <td><input type="radio" name="method"  />Cash on - Delivery</td>
                            <td><input type="radio" name="method"  />Cash on - Pick-Up</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Purchase" /></td>
                        </tr>	
                      
                    </table>
                </div>
              
            </div>
        </form>
    </body>
</html>

