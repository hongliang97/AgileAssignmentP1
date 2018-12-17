<%-- 
    Document   : index
    Created on : Jun 8, 2013, 12:31:14 AM
    Author     : Dilukshan Mahendra
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Shopping Cart - Login</title>
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
          
            .space {
                float: left;
                height: 35px;
                width: 900px;
                font-size: 24px;
                font-family: Verdana, Geneva, sans-serif;
                padding-top:15px;

            }
            .formcontent {
                float: left;
                height: 200px;
                width: 900px;
            }
            .formtext {
                color:#660c2b;
                font-family:Verdana, Geneva, sans-serif;
            }
            -->
        </style>
    </head>
    <body style="margin:0; padding:0">
        <div class="container">
            <div class="headbanner">
                <h1 style="display:inline">
                    <center>
                        Florist Shop
                    </center>
                </h1>
            </div>
            <div class="mycontent">
                <div class="space"><span><a class="formtext">Login</a></span></div>
                <div class="formcontent">
                    <form action="loginval" method="post">
                        <table>
                            <tr>
                                <td class="formtext">Username :</td>
                                <td><input id="name" name="uname" type="text" size="30" /></td><td><a style="font-size: 10px; font-family:lucida sans; color: darkgray">[Any name]</a></td>
                            </tr>
                            <tr>
                                <td class="formtext">Password :</td>
                                <td><input id="pas" name="pass" type="password" size="30" /></td><td><a style="font-size: 10px; font-family:lucida sans; color: darkgray">[Pass = 1234]</a></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Submit"/></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            
        </div>
    </body>
</html>
