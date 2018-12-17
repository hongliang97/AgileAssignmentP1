<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shopping Page</title>
    <%
            String user = (String) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
            }
        %>
</head>
<body>

<h1>Flower list</h1>

<table cellpadding="5" border=1>

<tr valign="bottom">
    <td align="left"><b>#ID</b></td>
    <td align="left"><b>Name</b></td>
    <td align="left"><b>Description</b></td>
    <td align="left"><b>Price</b></td>
    <td align="left"><b>Pictures</b></td>
    <td align="left"></td>
  </tr> 
  
  <tr valign="top">
    <td>#1</td>
    <td>High Society Flower Centerpieces</td>
    <td>High Society Flower Centerpieces are fresh and lush; perfect to usher in a new season or to celebrate one of life's many surprises.</td>
    <td>$59.99</td>
    <td><img src="img/high_society.jpg" width="90" height="90" /></td>
    <td><a href="<%=response.encodeURL("cart?productCode=flo01")%>">Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>#2</td>
    <td>Huge Pastel Hues Flower Bouquet</td>
    <td>Mixture of pastel hues with roses, eustoams, silver brunia, spray carnation, statice ance baby's breath.</td>
    <td>$79.99</td>
    <td><img src="img/hues_flower.jpg" width="90" height="90" /></td>
    <td><a href="<%=response.encodeURL("cart?productCode=flo02")%>">Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>#3</td>
    <td>Impressive Daydream Bouquet</td>
    <td>Hues of purple, ranging from blue-tinted royal purple to tender pinky-lavender give this bouquet a dreamy feel.</td>
    <td>$49.99</td>
    <td><img src="img/impressive_daydream.jpg" width="90" height="90" /></td>
    <td><a href="<%=response.encodeURL("cart?productCode=flo03")%>">Add To Cart</a></td>
  </tr>

  <tr valign="top">
    <td>#4</td>
    <td>New Love Baby's Breath Flower</td>
    <td>New Love Baby's Breath is a dazzling popcorn-like white filler flower that can be used to accent your favorite flowers, or bunched together on its own for a dreamy cloud of white.</td>
    <td>$39.99</td>
    <td><img src="img/new_love.jpg" width="90" height="90" /></td>
    <td><a href="<%=response.encodeURL("cart?productCode=flo04")%>">Add To Cart</a></td>
  </tr>
  
  <tr valign="top">
    <td>#5</td>
    <td>Perfectly Peach Rustic Centerpiece</td>
    <td>Featuring White Roses, Peach Roses, White Asters, Baby's Breath, White Spray Roses, and Peach Spray Roses all beside the chic and shimmery Silver Dollar Eucalyptus.</td>
    <td>$59.99</td>
    <td><img src="img/perfect_peach.jpg" width="90" height="90" /></td>
    <td><a href="<%=response.encodeURL("cart?productCode=flo05")%>">Add To Cart</a></td>
  </tr>
  
  <tr valign="top">
    <td>#6</td>
    <td>Flower Centerpiece Delicate Romance</td>
    <td>Stunning deep red roses add enchanting color while white aster and ruscus create a whimsical feminine touch. </td>
    <td>$46.99</td>
    <td><img src="img/delicate_romance.jpg" width="90" height="90" /></td>
    <td><a href="<%=response.encodeURL("cart?productCode=flo06")%>">Add To Cart</a></td>
  </tr>

</table>

</body>
</html>
