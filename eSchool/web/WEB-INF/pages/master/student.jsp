<%-- 
    Document   : student
    Created on : Jun 22, 2011, 4:44:41 PM
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
        <link rel="stylesheet" type="text/css" media="all" href="js/jsDatePick_ltr.min.css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jsDatePick.jquery.min.1.3.js"></script>
        <script type="text/javascript">
            function doAjax() {
                //alert($('#fname').val());                
                $.ajax({
                    url: 'getState.htm',
                    data: ({countryCode : $("#country").val()}),
                    success: function(data) {
                        //$('#time').html(data);
                        var stateCombo = document.getElementById("state");
                        stateCombo.options.length = 0;
                        var states = data.split(";");
                        for(var i=0;i<states.length;i++){
                            var option = document.createElement("option");
                            var codeName = states[i].split(":");
                            var stateCode = codeName[0];                            
                            var stateName = codeName[1];
                            option.text = stateName;
                            option.value = stateCode;
                            try {
                                stateCombo.add(option, null); //Standard
                            }catch(error) {
                                stateCombo.add(option); // IE only
                            }
                        }
                    }
                });
                                
            }
            
            function getDistrict() {
                $.ajax({
                    url: 'getDistrict.htm',
                    data: ({stateCode : $("#state").val()}),
                    success: function(data) {
                        //$('#time').html(data);
                        var districtCombo = document.getElementById("district");
                        districtCombo.options.length = 0;
                        var districts = data.split(";");
                        for(var i=0;i<districts.length;i++){
                            var option = document.createElement("option");
                            var codeName = districts[i].split(":");
                            var districtCode = codeName[0];                            
                            var districtName = codeName[1];
                            option.text = districtName;
                            option.value = districtCode;
                            try {
                                districtCombo.add(option, null); //Standard
                            }catch(error) {
                                districtCombo.add(option); // IE only
                            }
                        }
                    }
                });
                                
            }
            
            function getTaluka() {
                $.ajax({
                    url: 'getTaluka.htm',
                    data: ({districtCode : $("#district").val()}),
                    success: function(data) {
                        //$('#time').html(data);
                        var talukaCombo = document.getElementById("taluka");
                        talukaCombo.options.length = 0;
                        var talukas = data.split(";");
                        for(var i=0;i<talukas.length;i++){
                            var option = document.createElement("option");
                            var codeName = talukas[i].split(":");
                            var talukaCode = codeName[0];                            
                            var talukaName = codeName[1];
                            option.text = talukaName;
                            option.value = talukaCode;
                            try {
                                talukaCombo.add(option, null); //Standard
                            }catch(error) {
                                talukaCombo.add(option); // IE only
                            }
                        }
                    }
                });                                
            }
            
            function setAddress2(){
                var address2 = "Taluka "+$("#taluka :selected").text()+", Dist "+$("#district :selected").text()+", "+$("#state :selected").text()+" "+$("#pincode").val();
                $("#permanentAddress").val(address2);
            }
            
            function searchStudent(id){
                var searchStr = $("#"+id).val();
                $.ajax({
                    url: 'searchStudent.htm',
                    data: ({studentStr : searchStr}),
                    success: function(data) {   
                        deleteRow("studentListTbl");
                        var studlist = data.split(";");
                        for(var i=1; i<studlist.length; i++){
                            var studenRecord = studlist[i].split(":");
                            addRow("studentListTbl", studenRecord);
                        }
                        
                        
                    }
                }); 
            }
            
            function addRow(tableID, studenRecord) {
 
                var table = document.getElementById(tableID);
 
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);
                //row.onclick = editStudent(studenRecord[0]);
                if(rowCount%2){
                    row.bgColor = "#FFFFFF";
                }else{
                    row.bgColor = "#D6D6D6";
                }

                var cell1 = row.insertCell(0);
                var element1 = document.createElement("input");
                element1.type = "radio";
                element1.id = "student"+rowCount;
                element1.name = "studID";                
                element1.value = studenRecord[0];
                element1.onclick = function(){
                    editStudent(studenRecord[0]);                            
                };

                cell1.appendChild(element1);                
                
                var cell2 = row.insertCell(1);
                cell2.innerHTML = studenRecord[1];
 
                /*
                var cell3 = row.insertCell(2);
                var element2 = document.createElement("input");
                element2.type = "text";
                cell3.appendChild(element2);
                 */
 
            }
            
            function deleteRow(tableID) {
                try {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length; 
                    while(rowCount > 1){
                        table.deleteRow(1);
                        rowCount = table.rows.length;                       
                    }
                }catch(e) {
                    alert(e);
                }
            }
            
            function editStudent(studid){
                //alert("student ID: "+studid);
                $('#studentTempID').val(studid);
                $.ajax({
                    url: 'getStudentInfo.htm',
                    data: ({studentCode : studid}),
                    success: function(data) {
                        //$('#time').html(data);
                        //alert(data);
                        var studentInfo = data.split(";");
                        var studName = studentInfo[0].split(" ");                        
                        $('#fname').val(studName[0]);
                        $('#mname').val(studName[1]);
                        $('#lname').val(studName[2]);
                        
                        
                        //$('#studentName').val(studentInfo[0]);
                        $('#gender').val(studentInfo[1]);
                        $('#dateOfBirth').val(studentInfo[2]);
                        $('#presentAddress').val(studentInfo[4]);
                        $('#permanentAddress').val(studentInfo[3]);
                        //$('#country').val(studentInfo[5]);
                        //$('#state').val(studentInfo[6]);
                        //$('#district').val(studentInfo[7]);
                        //$('#taluka').val(studentInfo[8]);
                        $('#pincode').val(studentInfo[9]);
                        $('#landline').val(studentInfo[10]);
                        $('#mobile').val(studentInfo[11]);
                        $('#email').val(studentInfo[12]);
                        
                    }
                });                                
            
            }
        </script>

        <script type="text/javascript">
            window.onload = function(){
                new JsDatePick({
                    useMode:2,
                    target:"dateOfBirth",
                    dateFormat:"%d-%m-%Y"
                    /*selectedDate:{				This is an example of what the full configuration offers.
                                day:5,						For full documentation about these settings please see the full version of the code.
                                month:9,
                                year:2006
                        },
                        yearsRange:[1978,2020],
                        limitToToday:false,
                        cellColorScheme:"beige",
                        dateFormat:"%m-%d-%Y",
                        imgPath:"img/",
                        weekStartDay:1*/
                });
            };
        </script>
    </head>
    <body style="background-color: #D3D3D3">               
        <form:form method="POST" commandName="student" enctype="multipart/form-data">            
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Student Registration</legend> 
                    <table cellspacing="10">
                        <tr>
                            <td>Student Name :</td>
                            <td><form:input path="fname" id="fname"/></td>
                            <td><form:input path="mname" id="mname"/></td>
                            <td><form:input path="lname" id="lname"/></td>
                        </tr>                
                        <tr>
                            <td>&nbsp;</td>
                            <td>First Name</td>
                            <td>Middle Name</td>
                            <td>Last Name</td>
                        </tr>                
                        <tr>
                            <td>Gender :</td>
                            <td>
                                <form:radiobutton path="gender" value="M" label="M"/> 
                                <form:radiobutton path="gender" value="F" label="F" />
                            </td>
                            <td style="text-align: right">Date of birth :</td>
                            <td style="text-align: right"><form:input path="dateOfBirth" id="dateOfBirth" size="12" readonly="true"/></td>                        
                        </tr>                                        
                        <tr>
                            <td>Address1 :</td>
                            <td colspan="3"><form:input path="presentAddress" id="presentAddress" size="75"/></td>                        
                        </tr>
                        <tr>
                            <td>Address2 :</td>
                            <td colspan="3"><form:input path="permanentAddress" id="permanentAddress" size="75" readonly="true"/></td>                        
                        </tr>
                        <tr>
                            <td>Country :</td>
                            <td>
                                <form:select path="country" id="country" onchange="doAjax();">
                                    <form:option value="0" label="Select" />
                                    <form:options items="${countryList}" itemValue="countryID" itemLabel="countryName"/>
                                </form:select>

                                <%--
                                <form:select path="country">
                                    <form:option value="00" label="Select" />
                                    <form:option value="01" label="India" />
                                    <form:option value="02" label="USA" />
                                    <form:option value="03" label="UK" />
                                </form:select>
                                --%>
                            </td>
                            <td style="text-align: right">State :</td>
                            <td style="text-align: right">
                                <form:select path="state" id="state" onchange="getDistrict();">
                                    <form:option value="0000" label="Select" />                                    
                                </form:select>
                            </td>
                        </tr>                    
                        <tr>                            
                            <td style="text-align: left">District :</td>
                            <td style="text-align: left">
                                <form:select path="district" id="district" onchange="getTaluka();">
                                    <form:option value="000000" label="Select" />                                    
                                </form:select>
                            </td>
                            <td style="text-align: right">Taluka :</td>
                            <td style="text-align: right">
                                <form:select path="taluka" id="taluka">
                                    <form:option value="00000000" label="Select" />                                    
                                </form:select>
                            </td>
                        </tr>                                                
                        <tr>
                            <td>Pincode :</td>
                            <td><form:input path="pincode" id="pincode" size="12" onblur="setAddress2();"/></td>                        
                            <td style="text-align: right">Landline :</td>
                            <td style="text-align: right"><form:input path="landline" size="12"/></td>                        
                        </tr>                        
                        <tr>
                            <td>Mobile :</td>
                            <td><form:input path="mobile" size="12"/></td>                        
                            <td style="text-align: right">Email :</td>
                            <td style="text-align: right"><form:input path="email" size=""/></td>                        
                        </tr>                        
                        <tr>
                            <td><form:label for="photoData" path="photoData">Photo</form:label></td>
                            <td colspan="3">
                                <!--<input type="file" name="photo" size="55"/>                                    -->
                                <form:input path="photoData" id="photo" type="file" size="55"/>
                            </td>                        
                        </tr>
                        <tr>
                            <td><form:label for="signData" path="signData">Signature</form:label></td>
                            <td colspan="3">
                                <form:input path="signData" id="signData" type="file" size="55"/>
                            </td>                        
                        </tr>
                        <tr style="height: 30px">
                            <td colspan="4" align="center" style="vertical-align: bottom">                                
                                <input type="submit" id="saveBtn" value="Save"/>                                
                            </td>
                        </tr>
                    </table>                    
                </fieldset>
            </div>            
            <div style="position: absolute;margin-left: 630px;width: 195px;">                
                <fieldset>
                    <legend>Search Student</legend>
                    <input type="text" name="studentsearch" id="studentsearch" size="12"/>
                    <input type="button" value="Search" onclick="searchStudent('studentsearch')">                                
                    <BR><BR>
                    <input type="button" id="editBtn" value="Edit" disabled="true">                                
                    <input type="button" id="deleteBtn" value="Delete" disabled="true">                                
                    <table id="studentListTbl" style="width: 100%;font-size: small">
                        <tr>
                            <td style="text-align: left">
                                <b>ID</b>
                            </td>                            
                            <td style="text-align: left">
                                <input type="text" id="studentTempID" name="studentTempID" readonly="true" size="5"/>
                                <%--<form:input path="studentID" id="studentID"/>--%>
                            </td>                            
                        </tr>
                    </table>
                </fieldset>
            </div>            
        </form:form>
    </body>
</html>