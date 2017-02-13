<%-- 
    Document   : admission
    Created on : Jun 22, 2011, 6:44:39 PM
    Author     : vikram.galande
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Admission Registration</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            function validateForm(){                
                if($('#studentId').val() != "" && $('#academicYear').val() != "0" && $('#standard').val() != "0"){
                    return true;
                }else{
                    return false;
                }
            }
            function getStudent() {
                $.ajax({
                    url: 'getStudentInfo.htm',
                    data: ({studentCode : $("#studentId").val()}),
                    success: function(data) {
                        //$('#time').html(data);
                        //alert(data);
                        var studentInfo = data.split(";");
                        $('#studentName').val(studentInfo[0]);
                        $('#gender').val(studentInfo[1]);
                        $('#dob').val(studentInfo[2]);
                        $('#presentAddress').val(studentInfo[3]);
                        $('#permanentAddress').val(studentInfo[4]);
                        $('#country').val(studentInfo[5]);
                        $('#state').val(studentInfo[6]);
                        $('#district').val(studentInfo[7]);
                        $('#taluka').val(studentInfo[8]);
                        $('#pincode').val(studentInfo[9]);
                        $('#landline').val(studentInfo[10]);
                        $('#mobile').val(studentInfo[11]);
                        $('#email').val(studentInfo[12]);
                        
                    }
                });                                
            }    
        </script>

    </head>
    <body style="background-color: #D3D3D3">               
        <form:form method="POST" commandName="admission" onsubmit="return validateForm();">
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Admission Form</legend> 
                    <table cellspacing="10">
                        <tr>
                            <td>Admission Date :</td>
                            <td>
                                <form:input path="admDate" readonly="true"/>
                            </td>
                            <td>Academic Year :</td>
                            <td>
                                <%--
                                <form:input path="academicYear" id="academicYear" readonly="true" size="45"/>
                                --%>                                
                                <form:select path="academicYear" id="academicYear">                                    
                                    <form:option value="${admission.accYearList.academicYearID}" label="${admission.accYearList.academicYearName}" />                                    
                                </form:select>

                                <%--<form:input path="academicYear" readonly="true"/>

                                <form:select path="academicYear" id="academicYear">
                                    <form:option value="0" label="Select" />
                                    <form:options items="${admission.accYearList}" itemValue="acYearCode" itemLabel="acYearName"/>
                                </form:select>
                                --%>
                            </td>
                        </tr>                
                        <tr>
                            <td>Student Name :</td>
                            <td colspan="3">
                                <form:input path="studentId" id="studentId" size="6" onblur="getStudent();"/>
                                <form:input path="studentName" id="studentName" size="45"/>
                            </td>                            
                        </tr>                                        
                        <tr>
                            <td>&nbsp;</td>
                            <td>Code</td>
                            <td colspan="2">Student Name</td>                            
                        </tr>                                        
                        <tr>
                            <td>Gender :</td>
                            <td>
                                <form:input path="gender" id="gender" readonly="true" size="5"/>
                            </td>
                            <td>Date of Birth :</td>
                            <td>
                                <form:input path="dob" id="dob" readonly="true" size="12"/>
                            </td>
                        </tr>                                         
                        <tr>
                            <td>Address1 :</td>
                            <td colspan="3"><form:input path="presentAddress" id="presentAddress" size="45"/></td>                        
                        </tr>
                        <tr>
                            <td>Address2 :</td>
                            <td colspan="3"><form:input path="permanentAddress" id="permanentAddress" size="45"/></td>                        
                        </tr>                                                                                          
                        <tr>
                            <td>Mobile :</td>
                            <td><form:input path="mobile" id="mobile"/></td>                        
                            <td align="right">Email :</td>
                            <td><form:input path="email" id="email"/></td>                        
                        </tr>                                                
                        <tr>
                            <td>Standard :</td>
                            <td colspan="3">
                                <form:select path="standard" id="standard">
                                    <form:option value="0" label="Select" />
                                    <form:options items="${admission.stdDetailsList}" itemValue="stdID" itemLabel="stdName"/>
                                </form:select>
                            </td>                                                    
                        </tr>                        
                        <tr style="height: 50px">
                            <td colspan="4" align="center" style="vertical-align: bottom">
                                <input type="submit" value="Submit">
                            </td>
                        </tr>
                    </table>                    
                </fieldset>
            </div>
            <!--            
            <div style="position: absolute;margin-left: 620px;width: 180px;">                
                <table border="1">
                    <label>Photo</label>
                    <tr style="height: 150px;">
                        <td style="width: 150px;">
                            PHOTO
                        </td>
                    </tr>
                </table>                
                <BR><BR><BR><BR>
                <table border="1">
                    <label>SIGN</label>
                    <tr style="height: 150px;">
                        <td style="width: 150px;">
                            Signature
                        </td>
                    </tr>
                </table>                                
            </div>
            -->
        </form:form>
    </body>
</html>