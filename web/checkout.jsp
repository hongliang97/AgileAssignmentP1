<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <%
            String user = (String) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
            }
        %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>CheckOut Page</title>
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<body>

<h2>Responsive Checkout Form</h2>
<!-- <p>Resize the browser window to see the effect. When the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other.</p> -->
<div class="row">
  <div class="col-75">
    <div class="container">
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
                  
                
                %>
        <%
         try{ 
            connection = DriverManager.getConnection(connectionUrl, userId, password);
            statement=connection.createStatement();
            String sql ="SELECT * FROM Customer";
            
            
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getString("cust_id").equals(session.getAttribute("user"))){
  

                %>   
      <form action="addOrder.jsp" method="post">
      
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname">Choose any one method to get your flowers :</label>
            <label>
            <input type="radio" name="pmethod" value="Delivery"/>Delivery
            <br/> <br/>
            <input type="radio"name="pemthod"value="PickUp"/>Pick-Up
            <br/> <br/>
           
           </label>          
            <label for="name"><i class="fa fa-user"></i> Full Name</label>
           <input type="text" id ="fname" name="name" size="50" value="<%=resultSet.getString("cust_name")%>" readonly></p>
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="abc@example.com">
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" id="adr" name="address" placeholder="Jalan 123, Taman 456">
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="Puchong">

            <div class="row">
              <div class="col-50">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="Selangor">
              </div>
              <div class="col-50">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="10001">
              </div>
                 <div class="col-50">
                <label for="date">Date</label>
                <input type="text" id="date" name="date" Value="29-Nov-2018">
              </div>
                
                  <input type="hidden" name="user" value="<%=(String) session.getAttribute("user")%>">
            </div>
          </div>
            
          <!-- <div class="col-50">
            <h3>Payment Method 2 - Online Banking</h3>
         
            <label for="fname">Choose any one method to get your flowers</label>
            <label>
            <input type="radio" name="sameadr"/> Delivery
            <br/> <br/>
            <input type="radio"name="sameadr"/> Pick-Up
            <br/> <br/>
            
       
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352">
              </div>
            </div>
          </div>
          -->
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        </label>
         
        <input type="submit" value="Continue to checkout" class="btn">
          <%}}}
                 catch (Exception e) {
                    e.printStackTrace();
                }%>   
      </form>
    </div>
  </div>
            
   <div class="col-25">
   <div class="container">
        <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> </span></h4>
       <table border="1" cellpadding="5">
  <tr>
  
    <th>Name</th>
    <th>Quantity</th>
    <th>Price</th>
    
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
      <%=product.getName()%>
    </td>
    <td><%=item.getQuantity()%></td>
    <td>
     <span class="price"> <%=item.getTotalCurrencyFormat()%></span>
    </td>
   
  </tr>
 <% 
         double total = item.getTotal();
         subtotal += total;
         %>

<% } %>
  <tr>
  
    <td colspan="3" border-top="0">
      
      <p>Subtotal :<span class="price" style="color:black"><b> $<%out.print(subtotal);%></b></span></p>
    </td>
  </tr>
</table>
  
   
    </div>
  </div>
 
</div>

</body>
</html>
