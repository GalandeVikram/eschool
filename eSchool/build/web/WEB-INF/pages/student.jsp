<%-- 
    Document   : student
    Created on : Jun 8, 2011, 6:48:21 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Info</title>
    </head>
    <body>
        <sf:form action="studentForm.htm" method="POST" commandName="studentEntry">
            <div>                
                <center>
                    <fieldset>
                        <legend>
                            Student Information
                        </legend>
                        <table style="width: 100%;">
                            <tr>
                                <td>
                                    Prefix
                                </td>
                                <td>
                                    <select name="prefix" id="prefix">
                                        <option value="Mr">Mr</option>
                                        <option value="Miss">Miss</option>
                                        <option value="Mrs">Mrs</option>
                                    </select>
                                </td>
                            </tr>                            
                            <tr>
                                <td>
                                    First Name
                                </td>
                                <td>                                    
                                    <input type="text" size="12" name="firstname" id="firstname"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Middle Name
                                </td>
                                <td>                                    
                                    <input type="text" size="12" name="middlename" id="middlename"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Last Name
                                </td>
                                <td>                                    
                                    <input type="text" size="12" name="lastname" id="lastname"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Address1
                                </td>
                                <td>                                    
                                    <input type="text" size="12" name="address1" id="address1"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Address2
                                </td>
                                <td>                                    
                                    <input type="text" size="12" name="address2" id="address2"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    State
                                </td>
                                <td>
                                    <select name="state" id="state">
                                        <option value="MH">Maharashtra</option>
                                        <option value="GJ">Gujrat</option>
                                        <option value="GO">Goa</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    District
                                </td>
                                <td>
                                    <select name="district" id="district">
                                        <option value="1">Pune</option>
                                        <option value="2">Satara</option>
                                        <option value="3">Kolhapur</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    City
                                </td>
                                <td>
                                    <select name="city" id="city">
                                        <option value="1">Indapur</option>
                                        <option value="2">Baramati</option>
                                        <option value="3">Daund</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </fieldset>                    
                </center>
            </div>
        </sf:form>        

    </body>
</html>
