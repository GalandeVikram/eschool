<%-- 
    Document   : studentAttendance
    Created on : Jun 23, 2011, 2:25:00 PM
    Author     : vikram.galande
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Student Registration</title>
    </head>
    <body>

        <form:form method="POST" commandName="studentAttendance">
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Student Attendance</legend> 
                    <table>
                        <tr>
                            <td>Attendance Date :</td>
                            <td><form:input path="attendanceDate" /></td>                            
                        </tr>                
                        <tr>
                            <td>Standard :</td>
                            <td>
                                <form:input path="stdCode" />
                                <form:select path="stdName">
                                    <form:option value="00" label="IX" />
                                    <form:option value="01" label="X" />                                    
                                </form:select>
                            </td>
                        </tr>                                        
                        <tr>
                            <td>Subject :</td>
                            <td>
                                <form:input path="subCode" />
                                <form:select path="subName">
                                    <form:option value="00" label="Marathi"/>
                                    <form:option value="01" label="English"/>                                    
                                </form:select>
                            </td>
                        </tr>                                        
                        <tr>
                            <td>Teacher :</td>
                            <td>
                                <form:input path="teacherCode"/>
                                <form:select path="teacherName">
                                    <form:option value="00" label="Joshi Sir" />
                                    <form:option value="01" label="Chaudhri Sir" />                                    
                                </form:select>
                            </td>
                        </tr>                                        
                        <tr>
                            <td>Present Roll Number :</td>
                            <td>
                                <form:input path="rollNumbers" />                                
                            </td>
                        </tr>
                        <tr style="height: 50px">
                            <td colspan="2" align="center" style="vertical-align: bottom">
                                <input type="submit" value="Register">
                            </td>
                        </tr>
                    </table>                    
                </fieldset>
            </div>            
        </form:form>
    </body>
</html>
