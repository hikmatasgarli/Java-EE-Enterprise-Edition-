<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>www.Asgarli.com</title>

    <script type="text/javascript" src="js/jquery/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
    <script type="text/javascript" src="js/search.js"></script>
    <script type="text/javascript" src="js/advanceSearch.js"></script>

    <script type="text/javascript" src="js/studentScript.js"></script>
    <script type="text/javascript" src="js/teacherScript.js"></script>
    <script type="text/javascript" src="js/lessonScript.js"></script>
    <script type="text/javascript" src="js/paymentScript.js"></script>

    <script type="text/javascript" src="js/main.js"></script>

    <link href="css/jquery.dataTables.min.css" type="text/css" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/jquery-ui.css" type="text/css" rel="stylesheet">

</head>

<body>
<%
    HttpSession session1 = request.getSession(false);
    if(session1.getAttribute("login") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<dir class="wrapper">
    <header>
        <nav class="clear">
                        <ul>
                            <c:choose>
                                <c:when test="${login.role.roleName eq 'ROLE_ADMIN'}">
                                    <li><a href="index.jsp">Main</a></li>
                                    <li><a href="#" class="btnDesign" id="studentDataBtnId">Student Data</a></li>
                                    <li><a href="#" class="btnDesign" id="teacherDataBtnId">Teacher Data</a></li>
                                    <li><a href="#" class="btnDesign" id="lessonDataBtnId">Lesson Data</a></li>
                                    <li><a href="#" class="btnDesign" id="paymentDataBtnId">Payment Data</a></li>

                                </c:when>
                                <c:when test="${login.role.roleName eq 'ROLE_TEACHER'}">
                                    <li><a href="index.jsp">Main</a></li>
                                    <li><a href="#" class="btnDesign" id="studentDataBtnId">Student Data</a></li>
                                    <li><a href="#" class="btnDesign" id="lessonDataBtnId">Lesson Data</a></li>
                                </c:when>
                                <c:when test="${login.role.roleName eq 'ROLE_STUDENT'}">
                                    <li><a href="index.jsp">Main</a></li>
                                    <li><a href="#" class="btnDesign" id="teacherDataBtnId">Teacher Data</a></li>
                                    <li><a href="#" class="btnDesign" id="lessonDataBtnId">Lesson Data</a></li>
                                </c:when>

                            </c:choose>




                            <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                                <li><a href="#" class="btnDesign1" id="newBtnId">ADD NEW</a></li>
                                <li><a href="#" class="test" id="test">TEST</a></li>
                            </c:if>
                        </ul>

        </nav>
        <h1>SStudent Management System</h1>
        <div class="welcome">Welcome, ${login.name} ${login.surname}
        <a href="logout.jsp"><img src="images/logout.png" height="20" width="20"></a>
        </div>
        <div class="sarch">
            <input type="button" value="Search" id="searchBtnId">
            <input type="text" placeholder="Search..." id="keywordId">
        </div>

    </header>

    <div class="content-wrapper">
        <!-- первая левая боковая панель -->
        <aside class="sidebar1">
            <h2>Боковая панель 1</h2>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean
                orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor. </p>
            <h3>Второстепенный заголовок</h3>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. </p>
            <h3>Второстепенный заголовок</h3>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. </p>
        </aside>
        <!-- основной контент -->
        <article id="main" class="main">

            <h2>Название</h2>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean
                orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor. Suspendisse vitae quam lorem, in
                tempus velit. Sed vitae ante quis felis fringilla condimentum.</p>
            <p>Aenean orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor. </p>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean
                orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor. Suspendisse vitae quam lorem, in
                tempus velit. Sed vitae ante quis felis fringilla condimentum. </p>
            <h3>Подзаголовок</h3>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean
                orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor. Suspendisse vitae quam lorem, in
                tempus velit. Sed vitae ante quis felis fringilla condimentum. </p>
            <h3>Подзаголовок</h3>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean
                orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor. Suspendisse vitae quam lorem, in
                tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean orci ante, venenatis non
                adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus imperdiet, nunc sem pharetra
                mi, vel faucibus elit risus id tortor. Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante
                quis felis fringilla condimentum. Aenean orci ante, venenatis non adipiscing vitae, fringilla et neque.
                In pharetra, eros imperdiet luctus imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor.
                Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean
                orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tor</p>
        </article>

        <!-- вторая правая боковая панель -->
        <aside id="sidebar2" class="sidebar2">
            <h2>Боковая панель 2 </h2>
            <ul>
                <li>Aenean orci ante</li>
                <li>Venenatis non adipiscing vita</li>
                <li> Fringilla et neque</li>
                <li>Aenean orci ante</li>
                <li>Venenatis non adipiscing vita</li>
                <li> Fringilla et neque</li>
            </ul>
            <p>Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla condimentum. Aenean
                orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros imperdiet luctus
                imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor.Suspendisse vitae quam lorem, in
                tempus velit. </p>
            <p>Sed vitae ante quis felis fringilla condimentum. Aenean orci ante, venenatis non adipiscing vitae,
                fringilla et neque. In pharetra, eros imperdiet luctus imperdiet, nunc sem pharetra mi, vel faucibus
                elit risus id tortor.Suspendisse vitae quam lorem, in tempus velit. Sed vitae ante quis felis fringilla
                condimentum. Aenean orci ante, venenatis non adipiscing vitae, fringilla et neque. In pharetra, eros
                imperdiet luctus imperdiet, nunc sem pharetra mi, vel faucibus elit risus id tortor.</p>
        </aside>
    </div>

    <footer>
        <p>Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной
            "рыбой" для текстов на латинице с начала XVI века. В то время некий безымянный печатник создал большую
            коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов. Lorem Ipsum не только
            успешно пережил без заметных изменений пять веков, но и перешагнул в электронный дизайн.</p>
        <p>Контакты: <a href="mailto:nobody@nowhere.com">e-mail@here.com</a></p>
    </footer>
    <div id="newStudentDialogId"></div>
    <div id="newTeacherDialogId"></div>
    <div id="newPaymentDialogId"></div>
    <div id="newLessonDialogId"></div>

    <div id="editStudentDialogId"></div>
    <div id="editPaymentDialogId"></div>
    <div id="editLessonDialogId"></div>
    <div id="editTeacherDialogId"></div>

</dir>
</body>
</html>

