<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    $(function () {
        $('#paymentTableId').DataTable({
            'searching': false
        });


    $("#accordion").accordion({
        collapsible: true
    });

    $('.datePicker').datepicker({
        changeMonth: true,
        changeYear: true
    });

    $('#advLessonCmbId').change(function () {
        getTeacherListByLessonId($(this).val());
    });

    $('#advSearchBtnId').click(function () {
        advancedSearchPaymentData();
    });
    });

</script>

<div id="accordion">

    <h3>Advanced Search</h3>
    <div>
        <select id="advLessonCmbId">
            <option value="0" selected>Select Lesson</option>
            <c:forEach items="${lessonsList}" var="ll">
                <option value="${ll.id}"> ${ll.lessonName} </option>
            </c:forEach>
        </select> &nbsp;

        <select id="advTeacherCmbId">
            <option value="0" selected>Select Teacher</option>
            <c:forEach items="${teacherList}" var="tl">
                <option value="${tl.id}"> ${tl.name} ${tl.surname} </option>
            </c:forEach>
        </select> <br>

        <input type="text" id="advMinAmount" placeholder="Min"> &nbsp;
        <input type="text" id="advMaxAmount" placeholder="Max"> <br>
        <input type="text" id="advBeginDataId" class="datePicker" placeholder="Begin Date"> &nbsp;
        <input type="text" id="advEndDateId" class="datePicker" placeholder="End Date">&nbsp;
        <input type="button" id="advSearchBtnId" value="Search">
    </div>

</div>

<div id="paymentDivid">
    <table class="display" id="paymentTableId" style="width: 100%">

        <thead>
        <tr>
            <th>#</th>
            <th>Student Fullname</th>
            <th>Lesson Name</th>
            <th>Teacher Fullname</th>
            <th>Amount</th>
            <th>Payment Date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${paymentList}" var="pl">
            <tr>
                <td>${pl.id}</td>
                <td>${pl.student.name} ${pl.student.surname}</td>
                <td>${pl.lesson.lessonName}</td>
                <td>${pl.teacher.name} ${pl.teacher.surname}</td>
                <td>${pl.amount}</td>
                <td>${pl.payDate}</td>
                <td><a href="javascript: editPayment('${pl.id}');">Edit</a></td>
                <td><a href="javascript: deletePayment('${pl.id}','${pl.student.name} , ${pl.teacher.name}')">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


