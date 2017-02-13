<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SCHOOL MANAGEMENT SYSTEM</title>
        <style type="text/css">
            body{
                margin-top: 200px;
            }
        </style>
        <script type="text/javascript">
            function load(){
                document.getElementById("username").focus();
            }
        </script>
    </head>
    <body background="<%=request.getContextPath()%>/images/school_header.jpg" style="background-repeat: no-repeat;" onload="load();">
        <sf:form action="login.htm" method="POST" commandName="login">        
            <div align="center">
                <table style="background-image: url(<%=request.getContextPath()%>/images/login.jpg);">
                    <tr height="200px;">
                        <td>
                            <table style="margin-top: 120px;">
                                <tr>
                                    <td>
                                        <b>USER NAME</b>
                                    </td>
                                    <td>
                                        <input type="text" id="username" name="username" style="background: #95B9C7"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>PASSWORD</b>
                                    </td>
                                    <td>
                                        <input type="password" id="password" name="password" style="background: #95B9C7"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="submit" value="Login"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>                
                </table>
            </div>
        </sf:form>
    </body>
</html>
