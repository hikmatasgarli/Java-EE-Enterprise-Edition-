<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<option value="0" selected>Select Teacher</option>
<c:forEach items="${teacherList}" var="tl">
    <option value="${tl.id}"> ${tl.name} ${tl.surname} </option>
</c:forEach>