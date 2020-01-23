<%--
  Created by IntelliJ IDEA.
  User: ASGARLI
  Date: 29.11.2019
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<div style="text-align: center">
    <form action="cs?action=register" method="post">
    <div class="lblDesign">Username:</div> <input type="text" name="username" placeholder="Username" required> <br>
    <div class="lblDesign">Password:</div>  <input type="password" name="password" placeholder="Password" required> <br>
    <div class="lblDesign">Name:</div> <input type="text" name="name" placeholder="Name" required> <br>
    <div class="lblDesign">Surname:</div> <input type="text" name="surname" placeholder="Surname" required> <br>

    <input type="submit" value="Log In"> &nbsp; <input type="reset" value="Clear"> <br>


</form>
</div>

</body>
</html>
