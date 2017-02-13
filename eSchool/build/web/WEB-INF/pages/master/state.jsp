<%-- 
    Document   : state
    Created on : Jun 9, 2011, 11:30:50 AM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="/SCHOOL/js/jquery.js"></script>
        <script type="text/javascript">
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            
            
            function doAjax() {                
                $.ajax({
                    url: 'time.htm',
                    data: ({name : "me"}),
                    success: function(data) {
                        $('#time').html(data);
                    }
                });
            }
    
            function onchangeCountry(countryid){                              
                xmlhttp.onreadystatechange=function()
                {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                        $("#stateCode").val(xmlhttp.responseText);
                    }
                }
                xmlhttp.open("GET","/SCHOOL/GetState?countryID="+countryid,true);
                xmlhttp.send();
                
                /*
                $.ajax({
                    type: "POST",
                    url: "some.php",
                    data: "name=John&location=Boston",
                    success: function(msg){
                        alert( "Data Saved: " + msg );
                    }
                });
                 */
            }
        </script>
    </head>
    <body>
        <sf:form commandName="state">
            <div id="divstate" style="position: absolute;">
                <fieldset>
                    <legend>State Master</legend>
                    <table>
                        <tr>
                            <td>
                                Country
                            </td>
                            <td>
                                <sf:select path="country" onchange="onchangeCountry(this.value);">
                                    <sf:option value="0" label="Select" />
                                    <sf:options items="${countryList}" itemValue="countryId" itemLabel="countryName" />
                                </sf:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                State Code
                            </td>
                            <td>
                                <input type="text" id="stateCode" name="stateCode" size="12"  readonly="true"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                State
                            </td>
                            <td>
                                <input type="text" id="state" name="state" size="12"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="ADD"/>
                            </td>                        
                        </tr>
                    </table>
                </fieldset>
            </div>
            <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>            
        </sf:form>
        <button id="demo" onclick="doAjax()" title="Button">Get the time!</button>
        <div id="time">
        </div>
    </body>
</html>
