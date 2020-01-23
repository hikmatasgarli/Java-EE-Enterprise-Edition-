<%--
  Created by IntelliJ IDEA.
  User: ASGARLI
  Date: 21.11.2019
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#dobIdT').datepicker({
            changeMonth: true,
            changeYear: true
        });
    });

</script>

<div class="lblDesign">Name:</div> <input type="text"  id="nameIdT" value="${teacher.name}"> <br>
<div class="lblDesign">Surname:</div> <input type="text"  id="surnameIdT" value="${teacher.surname}"> <br>
<div class="lblDesign">Address:</div> <input type="text"  id="addressIdT" value="${teacher.address}"> <br>
<div class="lblDesign">Dob:</div> <input type="text"  id="dobIdT" value="${teacher.dob}"> <br>
<div class="lblDesign">Phone:</div> <input type="text"  id="phoneIdT" value="${teacher.phone}"> <br>