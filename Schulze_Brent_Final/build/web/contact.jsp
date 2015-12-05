<%-- 
    CMIS 440
    index.jsp
    Rolodex Database Final
    05 OCT 2015
    Schulze, Brent
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link type="text/css"
              href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Add new contact</title>
    </head>
    <body>
        <%-- 
            Form to accept input of new contact
        --%>
        <form method="POST" action='ContactController' name="frmAddContact">
            Contact ID : <input type="text" readonly="readonly" name="contact_ID"
                             value="<c:out value="${contact.contact_ID}" />" /> <br /> 
            First Name : <input
                type="text" name="nameFirst"
                value="<c:out value="${contact.nameFirst}" />" /> <br /> 
            Last Name : <input
                type="text" name="nameLast"
                value="<c:out value="${contact.nameLast}" />" /> <br /> 
            Address : <input
                type="text" name="address"
                value="<c:out value="${contact.address}" />" /> <br /> 
            City : <input
                type="text" name="city"
                value="<c:out value="${contact.city}" />" /> <br /> 
            State : <input
                type="text" name="state"
                value="<c:out value="${contact.state}" />" /> <br />
            Zip Code : <input
                type="text" name="zipCode"
                value="<c:out value="${contact.zipCode}" />" /> <br /> 
            Email : <input type="text" name="email"
               value="<c:out value="${contact.email}" />" /> <br /> 
            Phone Number : <input
                type="text" name="phoneNumber"
                value="<c:out value="${contact.phoneNumber}" />" /> <br /> 
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
