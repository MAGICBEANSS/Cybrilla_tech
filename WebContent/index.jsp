<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
label{
margin-right:20px;
}
</style>
<form action="myservlet" method="post">
<label for="acno">Account no</label>
<input type="text" name="acno"><br />
<label for="amount">Amount</label>
<input type="text" name="amount"><br />
<label for="date">Date(dd-mm-yyyy)</label>
<input type="text" name="date"><br />
<label for="ifsc">IFSCCODE</label>
<input type="text" name="ifsc"><br />
 <%--  My code flow is index.jsp to collect data and sent it to servlet myservlet 
 My servlet makes a string of all the response and send it to aesdc.java for encrytion ,
 Then  request is forwarded to checkit.java it decodes the data  from aesdc.java and send it to Wwelcome.jsp for displaying 
  --%> 
<input type="hidden" name="data1" value="request.getParameter("acno") +  request.getParameter("amount")+ request.
getParameter("date") +  request.getParameter("ifsc")">

<button type="submit">Submit </button>

</form>
</body>
</html>