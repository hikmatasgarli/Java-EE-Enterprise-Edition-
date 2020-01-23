
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#dobIdT').datepicker({
            changeMonth: true,
            changeYear: true
        });
    });

</script>

<div class="lblDesign">Name:</div> <input type="text"  id="nameIdT"> <br>
<div class="lblDesign">Surname:</div> <input type="text"  id="surnameIdT"> <br>
<div class="lblDesign">Address:</div> <input type="text"  id="addressIdT"> <br>
<div class="lblDesign">Dob:</div> <input type="text"  id="dobIdT"> <br>
<div class="lblDesign">Phone:</div> <input type="text"  id="phoneIdT"> <br>