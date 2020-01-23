<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script>
        history.pushState(null,null,'login.jsp');
        window.addEventListener('popstate', function (event) {
            history.pushState(null,null,'login.jsp');
        });
    </script>
</head>
<body>

<div id="login">
    <form action="ls?action=login" method="post">
        <div class="lblDesign">Username:</div> <div id="enter"> <input type="text" name="username" placeholder="Username" required></div> <br>
        <div class="lblDesign">Password:</div> <div id="enter"> <input type="password" name="password" placeholder="Password" required></div> <br>
        <div id="button"><input type="submit" value="Log In"> &nbsp; <input type="reset" value="Clear"></div> <br>
        <a href="forgotPassword.jsp">Forgot Username/Password</a><br>
        <a href="register.jsp">Registration</a>
        <c:if test="${not empty invalid}">
            <label style="color: red">${invalid}</label>
        </c:if>
    </form>
</div>

</body>
</html>
