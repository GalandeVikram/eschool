<%-- 
    Document   : result
    Created on : Jun 29, 2011, 3:31:50 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            function generatePDF(){
                $.ajax({
                    url: 'getResultPDF.htm',
                    data: ({seatNumber : $("#seatNumber").val()}),
                    success: function(data) {
                        
                    }
                });
            }
        </script>
    </head>
    <body>        
        <form:form method="POST" commandName="result">
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Get Result</legend> 
                    <table>                         
                        <tr>
                            <td>Seat Number :</td>
                            <td>
                                <form:input path="seatNumber" id="seatNumber"/>
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
