<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASGARLI
  Date: 27.11.2019
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#studentCmbIdU').val('${payment.student.id}');
        $('#teacherCmbIdU').val('${payment.teacher.id}');
        $('#lessonCmbIdU').val('${payment.lesson.id}');
    });

</script>

<div class="lblDesign">Student</div>
<select id="studentCmbIdU">
    <option value="0" selected>Select Student</option>
    <c:forEach items="${studentList}" var="sl">
        <option value="${sl.id}"> ${sl.name} ${sl.surname} </option>
    </c:forEach>

</select><br>

<div class="lblDesign">Teacher</div>
<select id="teacherCmbIdU">
    <option value="0" selected>Select Teacher</option>
    <c:forEach items="${teacherList}" var="tl">
        <option value="${tl.id}"> ${tl.name} ${tl.surname} </option>
    </c:forEach>

</select><br>

<div class="lblDesign">Lesson</div>
<select id="lessonCmbIdU">
    <option value="0" selected>Select Lesson</option>
    <c:forEach items="${lessonsList}" var="ll">
        <option value="${ll.id}"> ${ll.lessonName} </option>
    </c:forEach>

</select><br>

<div class="lblDesign">Amount</div>
<input type="text" id="amountIdU" placeholder="amount"  value="${payment.amount}"/>