<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="hikmat.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $('#studentTableId').DataTable({
            'searching': false
        });
    });
</script>


<table class="display" id="studentTableId" style="width: 100%">
    <% List<Student> studentList = (List<Student>) request.getAttribute("studentList"); %>
    <!-- 4 - Response qaidir Data shekilinde -->
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Address</th>
        <th>Date of Birth</th>
        <th>Phone</th>
        <th>Date of Registration</th>
        <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
        <th>Edit</th>
        <th>Delete</th>
        </c:if>
    </tr>
    </thead>

    <tbody>
    <%for (Student student : studentList) { %>
    <tr>
        <td><%=student.getId() %>
        </td>
        <td><%=student.getName() %>
        </td>
        <td><%=student.getSurname() %>
        </td>
        <td><%=student.getAddress() %>
        </td>
        <td><%=student.getDob() %>
        </td>
        <td><%=student.getPhone() %>
        </td>
        <td><%=student.getDataDate() %>
        </td>
        <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
            <td><a href="javascript: editStudent('<%=student.getId() %>');">Edit</a></td>
            <td><a href="javascript: deleteStudent('<%=student.getId() %>','<%=student.getName() +" "+student.getSurname()%>');">Delete</a></td>
        </c:if>
    </tr>
    <% } %>
    </tbody>
    <tfoot>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </tfoot>
</table>

