<%-- 
    Document   : header
    Created on : Jun 8, 2011, 5:13:13 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page language="java" session="true" %>
<!DOCTYPE html>
<%
String username = (String)session.getAttribute("userid");
if(null == username){
    username = "";
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>        
    </head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
    <body>
        <form:form method="POST" commandName="header">                    
            <div id="header">
                <center>
                    <h1>PRIMARY SCHOOL</h1>
                </center>
            </div>
            <div id="usernamediv">
                Welocome: <%= username %>
            </div>
            <div style="position: absolute;margin-top: -25px;text-align: right;width: 98%;">
                <a href="index.htm" title="Home" target="_parent">Logout</a>
            </div>
        </form:form>
    </body>
</html>
