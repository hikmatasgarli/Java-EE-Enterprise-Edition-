<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hikmat.model.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $('#teacherTableId').DataTable({
            'searching': false
        });
    });
</script>

<table id="teacherTableId" class="display" style="width:100%">
    <% List<Teacher> teacherList = (List<Teacher>) request.getAttribute("teacherList"); %>

    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Address</th>
        <th>Date of Birth</th>
        <th>Phone</th>
        <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
        <th>Edit</th>
        <th>Delete</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <% for(Teacher teacher: teacherList) { %>
    <tr>
        <td><%=teacher.getId() %></td>
        <td><%=teacher.getName() %></td>
        <td><%=teacher.getSurname() %></td>
        <td><%=teacher.getAddress() %></td>
        <td><%=teacher.getDob() %></td>
        <td><%=teacher.getPhone() %></td>
        <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
            <td><a href="javascript: editTeacher('<%=teacher.getId() %>');">Edit</a></td>
            <td><a href="javascript: deleteTeacher('<%=teacher.getId() %>','<%=teacher.getName() +" "+teacher.getSurname()%>');">Delete</a></td>
        </c:if>


    </tr>
    <% } %>
    </tbody>
    <tfoot>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Address</th>
        <th>Date of Birth</th>
        <th>Phone</th>
    </tr>
    </tfoot>
</table>