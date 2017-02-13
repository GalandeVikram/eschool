<%-- 
    Document   : userForm
    Created on : Jul 4, 2011, 3:23:44 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .even {
                background-color: silver;
            }
        </style>
    </head>
    <body>        
        <form:form method="POST" commandName="user">
            <table>
                <tr>
                    <td>User Name :</td>
                    <td><form:input path="u_name" /></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:password path="u_password" /></td>
                </tr>                
                <tr>
                    <td>Authorization :</td>
                    <td>
                        <form:select path="ua_code" id="ua_code">
                            <form:option value="0" label="Select" />
                            <form:options items="${userAuthList}" itemValue="id" itemLabel="ua_name"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Create User"></td>
                </tr>
            </table>
        </form:form>
        <c:if test="${fn:length(userList) > 0}">
            <table cellpadding="5">
                <tr class="even">
                    <th>Name</th>
                    <th>Password</th>                    
                </tr>
                <c:forEach items="${userList}" var="user" varStatus="status">
                    <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
                        <td>${user.u_name}</td>
                        <td>${user.u_password}</td>                        
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>