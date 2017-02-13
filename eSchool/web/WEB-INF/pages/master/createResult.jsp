<%-- 
    Document   : createResult
    Created on : Oct 20, 2011, 12:42:41 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" commandName="createResult">
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Get Result</legend> 
                    <table>                         
                        <tr>
                            <td>Seat Number :</td>
                            <td>
                                <form:input path="seatNumber"/>
                            </td>                                                    
                        </tr> 
                        <tr style="height: 50px">
                            <td colspan="2" align="center" style="vertical-align: bottom">
                                <input type="submit" value="Submit">
                            </td>
                        </tr>
                    </table> 
                </fieldset>
            </div>
        </form:form>
    </body>
</html>
