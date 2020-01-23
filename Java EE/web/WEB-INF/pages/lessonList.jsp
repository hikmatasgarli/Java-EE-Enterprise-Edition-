<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" >
    $(function () {
        $('#lessonTableId').DataTable({
            'searching': false
        });
    });
</script>

<table id="lessonTableId" class="display"  style="width: 100%">
    <thead>
    <tr>
        <th>#</th>
        <th>Lesson Name</th>
        <th>Lesson Time</th>
        <th>Lesson Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${lessonList}" var="ms">
    <tr>
        <td>${ms.id}</td>
        <td>${ms.lessonName}</td>
        <td>${ms.lessonTime}</td>
        <td>${ms.lessonPrice}</td>
        <td><a href="javascript: editLesson('${ms.id}');">Edit</a></td>
        <td><a href="javascript: deleteLesson('${ms.id}','${ms.lessonName}')">Delete</a></td>

    </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <th>#</th>
        <th>Lesson Name</th>
        <th>Lesson Time</th>
        <th>Lesson Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </tfoot>
</table>
