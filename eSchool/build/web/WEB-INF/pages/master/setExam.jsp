<%-- 
    Document   : setExam
    Created on : Jun 28, 2011, 3:23:40 AM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Admission Registration</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            function validateForm(){
                if($("#academicYear").val() != "0" && 
                    $("#examMaster").val() != "0" && 
                    $("#standard").val() != "0" && 
                    $("#subject").val() != "0" && 
                    $("#examDate").val() != "" && 
                    $("#examName").val() != "" && 
                    $("#examStartTime").val() != "" &&
                    $("#examEndTime").val() != "" &&
                    $("#examMarks").val() != ""){
                    return true;
                }else{
                    return false;
                }
                
            }
            
            function getSubject(){
                //alert($("#classRoomCode").val());
                $.ajax({
                    url: 'getSubject.htm',
                    data: ({classrooID : $("#classRoomCode").val()}),
                    success: function(data) {                        
                        //$('#time').html(data);                        
                        var subjetCombo = document.getElementById("subjectCode");
                        subjetCombo.options.length = 0;
                        var subjets = data.split(";");
                        for(var i=0;i<subjets.length;i++){
                            var option = document.createElement("option");
                            var codeName = subjets[i].split(":");
                            var subjetCode = codeName[0];                            
                            var subjetName = codeName[1];
                            option.text = subjetName;
                            option.value = subjetCode;
                            try {
                                subjetCombo.add(option, null); //Standard
                            }catch(error) {
                                subjetCombo.add(option); // IE only
                            }
                        }
                    }
                });
            }
        </script>
    </head>
    <body>
        <form:form method="POST" commandName="setExam" onsubmit="return validateForm();">
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Exam Time Table</legend> 
                    <table>
                        <tr>                            
                            <td>Class Room :</td>
                            <td>
                                <form:select path="classRoomCode" id="classRoomCode" onchange="getSubject();">
                                    <form:option value="0" label="Select" />
                                    <form:options items="${setExam.classRoomList}" itemValue="classRoomID" itemLabel="classRoomName"/>
                                </form:select>
                            </td>
                        </tr>                
                        
                        <tr>                            
                            <td>Exam :</td>
                            <td>
                                <form:select path="examCode" id="examCode">
                                    <form:option value="0" label="Select" />
                                    <form:options items="${setExam.examList}" itemValue="examID" itemLabel="examName"/>
                                </form:select>
                            </td>
                        </tr>                
                        
                        <tr>
                            <td>Subject :</td>
                            <td>
                                <form:select path="subjectCode" id="subjectCode">
                                    <form:option value="0" label="Select" />                                    
                                </form:select>
                            </td>                                                    
                        </tr> 
                        <tr>
                            <td>Exam Date</td>
                            <td>
                                <form:input path="examDate" id="examDate"/>
                            </td>                                                    
                        </tr>                        
                        <tr>
                            <td>Exam Start Time</td>
                            <td>
                                <form:input path="examStartTime" id="examStartTime"/>
                            </td>                                                    
                        </tr>
                        <tr>
                            <td>Exam End Time</td>
                            <td>
                                <form:input path="examEndTime" id="examEndTime"/>
                            </td>                                                    
                        </tr>
                        <tr>
                            <td>Exam Marks</td>
                            <td>
                                <form:input path="examMaxMarks" id="examMaxMarks"/>
                            </td>                                                    
                        </tr>
                        <tr>
                            <td>Exam Marks</td>
                            <td>
                                <form:input path="examMinMarks" id="examMinMarks"/>
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
