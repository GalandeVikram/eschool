<%-- 
    Document   : viewResult
    Created on : Jun 29, 2011, 3:32:00 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table style="width: 100%">
            <tr>
                <td align="center">
                    ${result.examName}
                </td>
            </tr>
            <tr>
                <td>
                    <table style="width: 100%;border: 1px;border-style: double">
                        <tr>
                            <td style="border: 1px;width: 12%;">
                                Student Name
                            </td>
                            <td colspan="3" style="margin-left: 0px;border: 0px;border-style: double">
                                :${result.studentName}
                            </td>
                        </tr>

                        <tr>
                            <td>
                                STD
                            </td>
                            <td align="left">
                                :${result.standardName}
                            </td>
                            <td style="text-align: right">
                                Roll Number:
                            </td>
                            <td style="border:0px;border-style: double;text-align: left;width: 10%">
                                ${result.rollNumber}
                            </td>
                        </tr>

                        <tr>
                            <td>
                                Division
                            </td>
                            <td align="left">
                                :${result.division}
                            </td>
                            <td style="text-align: right">
                                Seat Number:
                            </td>
                            <td style="border:0px;border-style: double;text-align: left;width: 10%">
                                ${result.seatNumber}
                            </td>                            
                        </tr>
                    </table>
                </td>
            </tr>            
            <tr height="300px;">
                <td style="vertical-align: top;">
                    <table style="width: 100%;border: 1px;border-style: double">
                        <tr>
                            <th style="text-align: left">
                                Subject Code
                            </th>
                            <th style="text-align: left">
                                Subject Name
                            </th>
                            <th style="text-align: left">
                                Marks Obtained
                            </th>
                            <th style="text-align: left">
                                Total Marks
                            </th>
                        </tr>
                        <c:forEach var="row" items="${result.subjectList}">
                            <tr>
                                <td><c:out value="${row.subjectID}"/></td>
                                <td><c:out value="${row.subjectName}"/></td>
                                <td><c:out value="${row.marksObtained}"/></td>                    
                                <td>100</td>                    
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>

            <tr>
                <td>
                    <table style="width: 100%">
                        <tr>
                            <td style="width: 10%; border: 0px;border-style: double;">
                                Percentage
                            </td>
                            <td style="width: 40%; border: 0px;border-style: double">
                                :${result.percentage}
                            </td>
                            <td style="width: 35%; border: 0px;border-style: double;text-align: right">
                                Result
                            </td>
                            <td style="width: 15%; border: 0px;border-style: double">
                                :${result.result}
                            </td>
                        </tr>
                        
                        <tr>
                            <td style="width: 10%; border: 0px;border-style: double;">
                                Place
                            </td>
                            <td style="width: 40%; border: 0px;border-style: double">
                                 :${result.place}
                            </td>
                            <td style="width: 35%; border: 0px;border-style: double;text-align: right">
                                Date
                            </td>
                            <td style="width: 15%; border: 0px;border-style: double">
                                :${result.resultDate}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr> 
        </table>
        <%--
        Seat No. :${result.seatNumber}<BR> 
        Student Name : ${result.studentName}<BR> 
        <table border="1" width="100%">
            <tr>
                <th>Exam Code</th>
                <th>Exam Name</th>
                <th>Marks</th>                
            </tr>
            <c:forEach var="row" items="${result.resultDetails}">
                <tr>
                    <td><c:out value="${row.examCode}"/></td>
                    <td><c:out value="${row.examName}"/></td>
                    <td><c:out value="${row.marks}"/></td>                    
                </tr>
            </c:forEach>
        </table>
        Total Marks =${result.totoalMarks}<BR>
        --%>
    </body>
</html>
