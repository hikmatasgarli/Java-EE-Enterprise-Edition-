package hikmat.web;

import hikmat.dao.*;
import hikmat.model.*;
import hikmat.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/cs")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);
        TeacherDao teacherDao = new TeacherDaoImpl();
        TeacherService teacherService = new TeacherServiceImpl(teacherDao);

        PaymentDao paymentDao = new PaymentDaoImpl();
        PaymentService paymentService = new PaymentServiceImpl(paymentDao);

        LessonDao lessonDao = new LessonDaoImpl();
        LessonService lessonService = new LessonServiceImpl(lessonDao);

        LoginDao loginDao = new LoginDaoImpl();
        LoginService loginService = new LoginServiceImpl(loginDao);

        MessageDao messageDao = new MessageDaoImpl();
        MessageService messageService = new MessageServiceImpl(messageDao);

        DateFormat dateFormat = new SimpleDateFormat("yy/mm/dd");

        PrintWriter pw = response.getWriter();
        String action = null;
        String address = null;
        try {
            if (request.getParameter("action") != null) {
                action = request.getParameter("action");
            }
            if (action.equalsIgnoreCase("register")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");

                Login login = new Login();
                login.setUsername(username);
                login.setPassword(password);
                login.setName(name);
                login.setSurname(surname);
                boolean isAdded = loginService.addUser(login);
                response.setContentType("text/html");
                if (isAdded) {
                    pw.write("<a href=\"logout.jsp\"><img src=\"images/logout.png\" height=\"\" width=\"\"></a>");
                    pw.write("<h1 style=\"text-align: center\">Melumat Ugurla yazildi!</h1>");


                } else {
                    pw.write("fail");
                }
            }else if (action.equalsIgnoreCase("getPaymentById")) {
                Payment payment = paymentService.getPaymentById((long) 1);

            }else if(action.equalsIgnoreCase("getTeacherListByLessonId")){
                long lessonId = Long.parseLong(request.getParameter("lessonId"));
                List<Teacher> teacherList = teacherService.getTeacherListByLessonId(lessonId);
                request.setAttribute("teacherList",teacherList);
                address = "WEB-INF/pages/teacherCombo.jsp";
            }else if(action.equalsIgnoreCase("addMessage")){
                String name = request.getParameter("name");
                String message = request.getParameter("message");

                Message messag = new Message();
                messag.setName(name);
                messag.setMessage(message);

                boolean isAdded = messageService.addMessage(messag);
                response.setContentType("text/html");
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }else if(action.equalsIgnoreCase("getMessage")){
                List<Message> messageList = messageService.getMessage();
                request.setAttribute("messageList",messageList);  //requestin icine yiqgim
                address = "chat.jsp";
            }


            else if(action.equalsIgnoreCase("advancedSearchPaymentData")){
                Long advLessonCbmId = Long.parseLong(request.getParameter("advLessonCbmId"));
                Long advTeacherCmbId = Long.parseLong(request.getParameter("advTeacherCmbId"));
                String advMaxAmount = request.getParameter("advMaxAmount");
                String advMinAmount = request.getParameter("advMinAmount");
                String advBeginDataId = request.getParameter("advBeginDataId");
                String advEndDateId = request.getParameter("advEndDateId");
                AdvancedSearch advancedSearch = new AdvancedSearch();
                advancedSearch.setAdvLessonCbmId(advLessonCbmId);
                advancedSearch.setAdvTeacherCmbId(advTeacherCmbId);
                advancedSearch.setAdvMaxAmount(advMaxAmount);
                advancedSearch.setAdvMinAmount(advMinAmount);
                advancedSearch.setAdvBeginDataId(advBeginDataId);
                advancedSearch.setAdvEndDateId(advEndDateId);
                List<Payment> paymentList =  paymentService.advancedSearchPaymentData(advancedSearch);
                request.setAttribute("paymentList",paymentList);
                address = "WEB-INF/pages/paymentData.jsp";
            }else if (action.equalsIgnoreCase("searchStudentData")) {
                String keyword = request.getParameter("keyword");
                List<Student> studentList = studentService.searchStudentData(keyword);
                request.setAttribute("studentList",studentList);
                address = "WEB-INF/pages/studentList.jsp";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (address != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(address); // Servletden Jsp ye yonlendirme edir
            dispatcher.forward(request, response);
        }

    }
}
