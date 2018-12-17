<%-- 
    Document   : success
    Created on : Jun 8, 2013, 12:14:15 PM
    Author     : Dilukshan Mahendra
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Shopping Cart - Success</title>
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
           
          .container .mycontent h3 {
	font-family: Verdana, Geneva, sans-serif;
}

            -->
        </style>
    </head>

    <body style="margin:0; padding:0">
        <%if(session.getAttribute("purch")!="true"){response.sendRedirect("index.jsp");
        } %>
        
        <form action="shop.jsp" method="post">
            <div class="container">

                <div class="headbanner">
                    <h1 style="display:inline"><center>
                            Florist Shop
                        </center></h1>
                </div>
                <div class="mycontent">
                    <h3 align="center" style="color:#660c2b;">Purchase has been succeeded! Thank You.<br /><input type="submit" value="Ok" /></h3>
                </div>
              
            </div>
        </form>
    </body>
</html>
