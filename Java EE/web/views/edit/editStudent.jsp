<%--
  Created by IntelliJ IDEA.
  User: ASGARLI
  Date: 21.11.2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#dobIdU').datepicker({
            changeMonth: true,
            changeYear: true
        });
    });

</script>

<div class="lblDesign">Name:</div> <input type="text"  id="nameIdU" value="${student.name}"> <br>
<div class="lblDesign">Surname:</div> <input type="text"  id="surnameIdU" value="${student.surname}"> <br>
<div class="lblDesign">Address:</div> <input type="text"  id="addressIdU" value="${student.address}"> <br>
<div class="lblDesign">Dob:</div> <input type="text"  id="dobIdU" value="${student.dob}"> <br>
<div class="lblDesign">Phone:</div> <input type="text"  id="phoneIdU" value="${student.phone}"> <br>