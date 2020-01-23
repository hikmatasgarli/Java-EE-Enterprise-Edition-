<%--
  Created by IntelliJ IDEA.
  User: ASGARLI
  Date: 25.11.2019
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.removeAttribute("login");
    session.invalidate();
    response.sendRedirect("login.jsp");

%>