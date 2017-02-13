<%-- 
    Document   : mainLayout
    Created on : Jun 8, 2011, 3:07:18 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="description" content="Paul Sorvino Foods Product offering page.  This page shows all of t oe products offered by Paul Sorvino Foods." />
        <link rel="stylesheet" type="text/css" href="/SCHOOL/css/main.css"/>
        <script type="text/javascript">
            function adm(){
                document.getElementById("right_col").innerHTML="";
            }
        </script>
    </head>
    <body>
        <div id="header">
            <center>
                <h1>PRIMARY SCHOOL</h1>
            </center>
        </div>
        <div id="module">
            <a href="admission.htm" target="right_col">Admission</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#" target="_top">Attendance</a>&nbsp;&nbsp;
            <a href="#" target="_top">Time Table</a>&nbsp;&nbsp;
            <a href="#" target="_top">Examination</a>&nbsp;&nbsp;
            <a href="#" target="_top">Result</a>&nbsp;&nbsp;
            <a href="#" target="_top">Teachers</a>
        </div>        
        <div id="container">
            <div id="left_col">
                menu
            </div>
            <div id="right_col">
                
            </div>


        </div>
        <div id="footer">
            <center>
                <p>Copy right @ 2011</p>
            </center>

        </div>
    </body>
</html>
