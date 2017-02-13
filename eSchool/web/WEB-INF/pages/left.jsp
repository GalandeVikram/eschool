
<%-- 
    Document   : left
    Created on : Jun 8, 2011, 5:22:25 PM
    Author     : vikram.galande
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <style type="text/css">
            .arrowgreen{
                width: 180px; /*width of menu*/
                border-style: solid solid none solid;
                border-color: #94AA74;
                border-size: 1px;
                border-width: 1px;
            }

            .arrowgreen ul{
                list-style-type: none;
                margin: 0;
                padding: 0;
            }

            label{
                font: bold 12px Verdana, Arial, Helvetica, sans-serif;
                display: block;
                background: transparent url(images/arrowgreen.gif) 100% 0;
                height: 24px; /*Set to height of bg image- padding within link (ie: 32px - 4px - 4px)*/
                padding: 4px 0 4px 10px;
                line-height: 24px; /*Set line-height of bg image- padding within link (ie: 32px - 4px - 4px)*/
                text-decoration: none;
            }

            .arrowgreen li a{
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 10px;
                display: block;
                background: transparent url(images/arrowblue.gif) 100% 0;
                height: 20px; /*Set to height of bg image- padding within link (ie: 32px - 4px - 4px)*/
                padding: 2px 0 2px 10px;
                line-height: 24px; /*Set line-height of bg image- padding within link (ie: 32px - 4px - 4px)*/
                text-decoration: none;
            }	

            .arrowgreen li a:link, .arrowgreen li a:visited {
                color: #5E7830;
            }

            .arrowgreen li a:hover{
                color: #26370A;
                background-position: 100% -32px;
            }


            .arrowgreen li a.selected{
                color: #26370A;
                background-position: 100% -64px;
            }            

            .arrowgreen li a.deselected{
                color: #5E7830;                
            } 
        </style>        
    </head>
    <body style="margin-left: 0px;margin-right: 0px;margin-bottom: 0px;margin-top: 0px;">
        <div class="arrowgreen">            
            <ul>
                <label>Master Entry</label>
                <li><a href="admission.htm" id="admission" title="Home" target="right">Admission</a></li>                                
                <li><a href="student.htm" id="student" title="Home" target="right">Student</a></li>                
                <li><a href="teacher.htm" id="dashboard" title="Home" target="right">Teacher</a></li>                
                <li><a href="examForm.htm" id="dashboard" title="Home" target="right">Exam Form</a></li>                
            </ul>
            <ul>
                <label>Attendance</label>
                <li><a href="studentAttendance.htm" title="Home" target="right">Student Attendance</a></li>                                
            </ul>
            <ul>
                <label>Examination</label>
                <li><a href="setExam.htm" title="Home" target="right">Set Exam TimeTable</a></li>                                
            </ul>
            <ul>
                <label>Result</label>
                <li><a href="createResult.htm" title="Home" target="right">Create Result</a></li>                                
            </ul>
            <ul>
                <label>Reports</label>
                <li><a href="result.htm" title="Home" target="right">Results</a></li>                                                
            </ul>
            <ul>
                <label>Administration</label>
                <li><a href="user.htm" title="Home" target="right">Create User</a></li>                
                <li><a href="dashboard.htm" title="Home" target="right">Change Password</a></li>                
                <li><a href="dashboard.htm" title="Home" target="right">Configuration</a></li>                                
            </ul>
        </div>
    </body>
</html>
