<%-- 
    CMIS 440
    index.jsp
    Rolodex Database Final
    05 OCT 2015
    Schulze, Brent
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Contact Manager</title>
    </head>
    <body>
        <%-- 
            Redirects straight to the display contact page
        --%>
        <jsp:forward page="/ContactController?action=displayContact" />
    </body>
</html>
