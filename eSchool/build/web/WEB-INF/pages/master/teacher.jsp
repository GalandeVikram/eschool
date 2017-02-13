<%-- 
    Document   : teacher
    Created on : Jun 23, 2011, 12:15:53 PM
    Author     : vikram.galande
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Teacher Registration</title>
    </head>
    <body>

        <form:form method="POST" commandName="teacher">
            <div style="position: absolute;" align="left">
                <fieldset>
                    <legend>Teacher Registration</legend> 
                    <table>
                        <tr>
                            <td>Teacher Name :</td>
                            <td><form:input path="fname" /></td>
                            <td><form:input path="mname" /></td>
                            <td><form:input path="lname" /></td>
                        </tr>                
                        <tr>
                            <td>&nbsp;</td>
                            <td>FIRST NAME</td>
                            <td>MIDDLE NAME</td>
                            <td>LAST NAME</td>
                        </tr>                
                        <tr>
                            <td>Gender :</td>
                            <td colspan="3">
                                <form:radiobutton path="gender" value="M" label="M"/> 
                                <form:radiobutton path="gender" value="F" label="F" />
                            </td>
                        </tr>                
                        <tr>
                            <td>Date of birth :</td>
                            <td colspan="3"><form:input path="dateOfBirth" /></td>                        
                        </tr>    
                        <tr>
                            <td>Present Address :</td>
                            <td colspan="3"><form:input path="presentAddress" size="45"/></td>                        
                        </tr>
                        <tr>
                            <td>Permanent Address :</td>
                            <td colspan="3"><form:input path="permanentAddress" size="45"/></td>                        
                        </tr>
                        <tr>
                            <td>Country :</td>
                            <td colspan="3">
                                <form:select path="country">
                                    <form:option value="00" label="Select" />
                                    <form:option value="01" label="India" />
                                    <form:option value="02" label="USA" />
                                    <form:option value="03" label="UK" />
                                </form:select>
                            </td>
                        </tr>                    
                        <tr>
                            <td>State :</td>
                            <td colspan="3">
                                <form:select path="state">
                                    <form:option value="0000" label="Select" />
                                    <form:option value="0101" label="MAHARASHTRA" />
                                    <form:option value="0102" label="GOA" />
                                    <form:option value="0103" label="GUJRAT"/>
                                    <form:option value="0104" label="KARNATAKA"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>District :</td>
                            <td colspan="3">
                                <form:select path="district">
                                    <form:option value="000000" label="Select" />
                                    <form:option value="010101" label="PUNE" />
                                    <form:option value="010102" label="SANGLI" />
                                    <form:option value="010103" label="SATARA"/>
                                    <form:option value="010104" label="KOLHPUR"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Taluka :</td>
                            <td colspan="3">
                                <form:select path="taluka">
                                    <form:option value="00000000" label="Select" />
                                    <form:option value="01010101" label="INDAPUR" />
                                    <form:option value="01010102" label="BARAMATI" />
                                    <form:option value="01010103" label="DAUND" />
                                    <form:option value="01010104" label="SHIRUR" />
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Pincode :</td>
                            <td><form:input path="pincode"/></td>                        
                            <td align="right">Landline :</td>
                            <td><form:input path="landline"/></td>                        
                        </tr>                        
                        <tr>
                            <td>Mobile :</td>
                            <td><form:input path="mobile"/></td>                        
                            <td align="right">Email :</td>
                            <td><form:input path="email"/></td>                        
                        </tr>                        
                        <tr>
                            <td>Photo :</td>
                            <td colspan="3">
                                <input type="file" name="photo"/>    
                            </td>                        
                        </tr>
                        <tr>
                            <td>Signature :</td>
                            <td colspan="3">
                                <input type="file" name="signature"/>    
                            </td>                        
                        </tr>
                        <tr style="height: 50px">
                            <td colspan="4" align="center" style="vertical-align: bottom">
                                <input type="submit" value="Register">
                            </td>
                        </tr>
                    </table>                    
                </fieldset>
            </div>
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
        </form:form>
    </body>
</html>