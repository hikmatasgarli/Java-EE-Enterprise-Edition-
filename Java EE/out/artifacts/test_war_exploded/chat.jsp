<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hikmat.model.Message" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ASGARLI
  Date: 29.11.2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<% List<Message> messageList = (List<Message>) request.getAttribute("messageList"); %>
<% for (Message message: messageList){ %>
    <%=message.getName() %>
   <%=message.getMessage() %>

<% } %>

<div>  Yazi - ${name} </div>



    <form action="cs?action=addMessage" method="post">

        <div class="lblDesign">Name:</div> <input type="text" name="name"> <br>
        <div class="lblDesign">Message:</div> <input type="text" name="message"> <br>



        <input type="submit" value="Log In"> &nbsp; <input type="reset" value="Clear"> <br>


    </form>



</body>
</html>
