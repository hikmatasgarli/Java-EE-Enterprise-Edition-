<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="lblDesign">Student</div>
<select id="studentCmbId">
    <option value="0" selected>Select Student</option>
    <c:forEach items="${studentList}" var="sl">
        <option value="${sl.id}"> ${sl.name} ${sl.surname} </option>
    </c:forEach>

</select><br>

<div class="lblDesign">Teacher</div>
<select id="teacherCmbId">
    <option value="0" selected>Select Teacher</option>
    <c:forEach items="${teacherList}" var="tl">
        <option value="${tl.id}"> ${tl.name} ${tl.surname} </option>
    </c:forEach>

</select><br>

<div class="lblDesign">Lesson</div>
<select id="lessonCmbId">
    <option value="0" selected>Select Lesson</option>
    <c:forEach items="${lessonList}" var="ll">
        <option value="${ll.id}"> ${ll.lessonName} </option>
    </c:forEach>

</select><br>

<div class="lblDesign">Amount</div>
<input type="text" id="amountId" placeholder="amount">