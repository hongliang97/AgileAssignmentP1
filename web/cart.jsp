<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shopping Cart</title>
      <%
            String user = (String) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
            }
        %>
</head>
<body>

<h1>Your cart</h1>
<table border="1" cellpadding="5">
  <tr>
    <th>Quantity</th>
    <th>Name</th>
    <th>Description</th>
    <th>Price</th>
    <th>Amount</th>
  </tr>

<%@ page import="business.*, java.util.ArrayList" %>
<% 
   Cart cart = (Cart) session.getAttribute("cart"); 
   double subtotal = 0.0;
   ArrayList<LineItem> items = cart.getItems();
   for (LineItem item : items)
   {
       Product product = item.getProduct();
%>

  <tr valign="top">
    <td>
      <form action="<%=response.encodeURL("cart")%>" method="post">
        <input type="hidden" name="productCode" 
               value="<%=product.getCode()%>">
        <input type="text" size=2 name="quantity" 
               value="<%=item.getQuantity()%>">
        <input type="submit" value="Update">
      </form>
    </td>
    
    <td>
      <%=product.getName()%>
    </td>
     <td>
      <%=product.getDescription()%>
    </td>
    <td>
      <%=product.getPriceCurrencyFormat()%>
    </td>
    <td>
      <%=item.getTotalCurrencyFormat()%>
    </td>
    <td>
      <form action="<%= response.encodeURL("cart")%>" method="post">
        <input type="hidden" name="productCode" 
               value="<%=product.getCode()%>">
        <input type="hidden" name="quantity" 
               value="0">
        <input type="submit" value="Remove Item">
      </form>
    </td>
  </tr>
 <% 
         double total = item.getTotal();
         subtotal += total;
         %>

<% } %>
  <tr>
    <td colspan="4">
      <p><b>To change the quantity</b>, enter the new quantity 
            and click on the Update button.</p>
    </td>
    <td colspan="1">
       
      <p>Subtotal : $<%out.print(subtotal);%></p>
    </td>
  </tr>
</table>

<br>

<form action="<%= response.encodeURL("shop.jsp")%>" method="post">
  <input type="submit" name="continue" value="Continue Shopping">
</form>

<form action="<%= response.encodeURL("checkout.jsp")%>" method="post">
     <input type="hidden" name="user" value="<%=(String) session.getAttribute("user")%>">
  <input type="submit" name="checkout" value="Checkout">
</form>

</body>
</html>
