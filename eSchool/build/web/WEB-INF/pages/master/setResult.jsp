<%-- 
    Document   : setResult
    Created on : Oct 20, 2011, 12:30:44 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form action="setResult.htm" method="POST" commandName="setResult">
            <table style="width: 100%">
                <tr>
                    <td>
                        Seat Number: 
                    </td>
                    <td>

                        <form:input path="seatNumber" value="${setResult.seatNumber}" readonly="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Student Name:
                    </td>
                    <td>
                        ${setResult.studentName}                        
                    </td>
                </tr>

                <tr>
                    <td>
                        Examination:
                    </td>
                    <td>
                        ${setResult.examName}                              
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <table style="width: 100%">
                            <tr>
                                <td>
                                    Subject ID
                                </td>
                                <td>                                    
                                    Subject Name
                                </td>
                                <td>
                                    Marks Obtained
                                </td>
                            </tr>                            
                            <c:forEach varStatus="row" items="${setResult.subjectList}">
                                
                                <spring:bind path="setResult.subjectList[${row.index}].examTXNID">                                    
                                    <input type="hidden" name="<c:out value="${status.expression}"/>"
                                           id="<c:out value="${status.expression}"/>"
                                           value="<c:out value="${status.value}"/>" />
                                </spring:bind>
                                    
                                <tr>
                                    <td>                                                                                
                                        <spring:bind path="setResult.subjectList[${row.index}].subjectID">
                                            <c:out value="${status.value}"/>
                                            <input type="hidden" name="<c:out value="${status.expression}"/>"
                                                   id="<c:out value="${status.expression}"/>"
                                                   value="<c:out value="${status.value}"/>" />
                                        </spring:bind>
                                    </td>
                                    <td>
                                        <spring:bind path="setResult.subjectList[${row.index}].subjectName">
                                            <c:out value="${status.value}"/>
                                            <input type="hidden" name="<c:out value="${status.expression}"/>"
                                                   id="<c:out value="${status.expression}"/>"
                                                   value="<c:out value="${status.value}"/>" />
                                        </spring:bind>                                        
                                    </td>                                    
                                    <td>
                                        <spring:bind path="setResult.subjectList[${row.index}].marksObtained">
                                            <%--<c:out value="${status.value}"/>--%>
                                            <input type="text" name="<c:out value="${status.expression}"/>"
                                                   id="<c:out value="${status.expression}"/>"
                                                   value="<c:out value="${status.value}"/>" />
                                        </spring:bind>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>                    
                </tr>

                <tr style="height: 50px">
                    <td colspan="2" align="center" style="vertical-align: bottom">
                        <input type="submit" value="Submit">
                    </td>
                </tr>
            </table>        
        </form:form>
    </body>
</html>
