<%-- 
    Document   : examForm
    Created on : Jun 28, 2011, 6:49:26 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Admission Registration</title>
        <script type="text/javascript" src="js/jquery.js"></script>        
    </head>
    <body>
        <form:form method="POST" commandName="examForm">
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Exam Time Table</legend> 
                    <table>
                        <tr>                            
                            <td>Class Room :</td>
                            <td>
                                <form:select path="classRoomCode" id="classRoomCode" onchange="getSubject();">
                                    <form:option value="0" label="Select" />
                                    <form:options items="${examForm.classRoomList}" itemValue="classRoomID" itemLabel="classRoomName"/>
                                </form:select>
                            </td>
                        </tr>                

                        <tr>                            
                            <td>Exam :</td>
                            <td>
                                <form:select path="examCode" id="examCode">
                                    <form:option value="0" label="Select" />
                                    <form:options items="${examForm.examList}" itemValue="examID" itemLabel="examName"/>
                                </form:select>
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