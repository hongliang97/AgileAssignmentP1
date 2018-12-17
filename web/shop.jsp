<%-- 
    Document   : shop
    Created on : Jun 8, 2013, 12:33:37 AM
    Author     : Dilukshan Mahendra
--%>



<%@page import="java.util.ArrayList"%>
<%@ page import="classes.Item" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%
            String user = (String) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("index.jsp");
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>Shopping Cart - Shop</title>
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
           
            
            .cartof {
                float: left;
                height: 25px;
                width: 900px;
                font-family: Verdana, Geneva, sans-serif;
                font-weight: bold;
                padding-top:5px;
            }
            .cartcontent {
                float: left;
                height: 200px;
                width: 900px;
                background-color:#ffc1d7;
                border-width:1px;
                border-style:solid;
                border-color:#a82828;
            }
            .prod1 {
                float: left;
                height: 100px;
                width: 900px;
                border-bottom-width:1px;
                border-bottom-style:solid;
                border-bottom-color:#FFCC00;
            }
            td{
                padding-left:5px;
                color:#660c2b;
                font-family:Verdana, Geneva, sans-serif;

            }
            .items {
                float: left;
                height: auto;
                width: 900px;
            }
            tr.border_bottom td {
                border-bottom-width:1px;
                border-bottom-style:solid;
                border-bottom-color:#f98b9c;
                height:100px;
            }
            .myitems {
                float: left;
                height: 200px;
                width: 600px;
                border-right-width:1px;
                border-right-style:solid;
                border-right-color:#f98b9c;
                overflow: auto;
            }
            th{
                color:#660c2b;
                font-family:Verdana, Geneva, sans-serif;
                font-weight:normal;
                background-color:#ff8cb2;
            }
            .total {
                float: left;
                height: 180px;
                width: 285px;
                font-family: Verdana, Geneva, sans-serif;
                font-size: 24px;
                font-weight: bold;
                padding-top:20px;
                padding-left:10px;
            }

            -->
        </style>
    </head>
    <body style="margin:0; padding:0">


        <div class="container">
            <form action="requesthandle" method="post"> 
                <div class="headbanner">
                    <h1 style="display:inline">
                        <center>
                            Florist Shop
                        </center>
                    </h1>
                </div>
                <div class="mycontent">
                    <div class="cartof">
                        <center><a style="color: #660c2b;">Cart Of [<% out.print(session.getAttribute("user"));%>]<input name="logout" type="submit" value="Logout"></input></a></center>
                    </div>
                    <div class="cartcontent">
                        <div class="myitems">
                            <table width="600px" cellpadding="0" cellspacing="0">
                                <tr>
                                    <th>#id</th> 
                                    <th>Item</th>
                                    <th>Price</th>
                                    <th>Action</th>
                                </tr>
                                <%if (session.getAttribute("itemlist") != null) {
                                        ArrayList mycart = (ArrayList) session.getAttribute("itemlist");
                                        for (int i = 0; i < mycart.size(); i++) {
                                            Item it = (Item) mycart.get(i);
                                %>
                                <tr>
                                    <td align="center"><%out.print(i);%></td>
                                    <td align="center"><% out.print(it.name);%></td> 
                                    <td align="center"><% out.print(it.price);%></td>
                                    <td align="center"><input name="del" type="submit" value="Delete" onclick="this.value=<%out.print(i);%>"></input></td>
                                </tr>
                                <%}
                                    }
                                %>    
                            </table>
                        </div>
                        <div class="total">
                            <a>My Total : $[<% out.print(session.getAttribute("total"));%>]</a><br />
                            <a style="font-size:14px">Total Qty: [<% ArrayList il = (ArrayList) session.getAttribute("itemlist");
                       out.print(il.size());%>]</a><br />
                            <input name="chkout" type="submit" value="Checkout" />
                        </div>
                    </div>
                    <div class="items">
                        <table width="900px">
                            <tr class="border_bottom">
                                <td>#1</td>
                                <td>High Society Flower Centerpieces</td>
                                <td>High Society Flower Centerpieces are fresh and lush; perfect to usher in a new season or to celebrate one of life's many surprises.</td>
                                <td>$59</td>
                                <td><img src="img/high_society.jpg" width="90" height="90" /></td>
                                <td><input name="addtocart1" type="submit" value="Add to Cart" /></td>
                            </tr>
                            <tr class="border_bottom">
                                <td>#2</td>
                                <td>Huge Pastel Hues Flower Bouquet</td>
                                <td>Mixture of pastel hues with roses, eustoams, silver brunia, spray carnation, statice ance baby's breath</td>
                                <td>$79</td>
                                <td><img src="img/hues_flower.jpg" width="90" height="90" /></td>
                                <td><input name="addtocart2" type="submit" value="Add to Cart" /></td>
                            </tr>
                            <tr class="border_bottom">
                                <td>#3</td>
                                <td>Impressive Daydream Bouquet</td>
                                <td>Hues of purple, ranging from blue-tinted royal purple to tender pinky-lavender give this bouquet a dreamy feel.</td>
                                <td>$99</td>
                                <td><img src="img/impressive_daydream.jpg" width="90" height="90" /></td>
                                <td><input name="addtocart3" type="submit" value="Add to Cart" /></td>
                            </tr>
                            <tr class="border_bottom">
                                <td>#4</td>
                                <td>New Love Baby's Breath Flower</td>
                                <td>New Love Baby's Breath is a dazzling popcorn-like white filler flower that can be used to accent your favorite flowers, or bunched together on its own for a dreamy cloud of white.</td>
                                <td>$40</td>
                                <td><img src="img/new_love.jpg" width="90" height="90" /></td>
                                <td><input name="addtocart4" type="submit" value="Add to Cart" /></td>
                            </tr>
                             <tr class="border_bottom">
                                <td>#5</td>
                                <td>Perfectly Peach Rustic Centerpiece</td>
                                <td>Featuring White Roses, Peach Roses, White Asters, Baby's Breath, White Spray Roses, and Peach Spray Roses all beside the chic and shimmery Silver Dollar Eucalyptus.</td>
                                <td>$60</td>
                                <td><img src="img/perfect_peach.jpg" width="90" height="90" /></td>
                                <td><input name="addtocart5" type="submit" value="Add to Cart" /></td>
                            </tr>
                            <tr class="border_bottom">
                                <td>#6</td>
                                <td>Flower Centerpiece Delicate Romance</td>
                                <td>Stunning deep red roses add enchanting color while white aster and ruscus create a whimsical feminine touch. </td>
                                <td>$46</td>
                                <td><img src="img/delicate_romance.jpg" width="90" height="90" /></td>
                                <td><input name="addtocart6" type="submit" value="Add to Cart" /></td>
                            </tr>
                        </table>
                    </div>
                </div>
              
            </form>
        </div>
    </body>
</html>

