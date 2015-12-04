<%-- 
    CMIS 440
    displayContact.jsp
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
        <title>Show All Contacts</title>
    </head>
    <body>
        <%-- 
            Table header for contact information
        --%>
        <table border=1>
            <thead>
                <tr>
                    <th>Contact Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Zip Code</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <%-- 
                    Contact output from database
                --%>
                <c:forEach items="${contacts}" var="contact">
                    <tr>
                        <td><c:out value="${contact.contact_ID}" /></td>
                        <td><c:out value="${contact.nameFirst}" /></td>
                        <td><c:out value="${contact.nameLast}" /></td>
                        <td><c:out value="${contact.address}" /></td>
                        <td><c:out value="${contact.city}" /></td>
                        <td><c:out value="${contact.state}" /></td>
                        <td><c:out value="${contact.zipCode}" /></td>
                        <td><c:out value="${contact.email}" /></td>
                        <td><c:out value="${contact.phoneNumber}" /></td>
                        <td><a href="ContactController?action=edit&contact_ID=<c:out value="${contact.contact_ID}"/>">Update</a></td>
                        <td><a href="ContactController?action=delete&contact_ID=<c:out value="${contact.contact_ID}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                <%-- 
                    Redirect for inputing new contact
                --%>
        <p><a href="ContactController?action=insert">Add Contact</a></p>
        
    </body>
</html>