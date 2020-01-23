package hikmat.web;

import hikmat.dao.*;
import hikmat.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(name = "DeleteServlet",urlPatterns = "/dl")
public class DeleteServlet extends HttpServlet {
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


        DateFormat dateFormat = new SimpleDateFormat("yy/mm/dd");

        PrintWriter pw = response.getWriter();
        String action = null;
        String address = null;
        try {
            if(request.getParameter("action") != null) {
                action = request.getParameter("action");
            }if(action.equalsIgnoreCase("deleteStudent")){
                long studentId = Long.parseLong(request.getParameter("studentId"));
                boolean isDeleted = studentService.deleteStudent(studentId);
                response.setContentType("text/html");
                if (isDeleted) {
                    pw.write("success");
                } else {
                    pw.write("error");
                }
            }else if(action.equalsIgnoreCase("deleteTeacher")){
                long teacherId = Long.parseLong(request.getParameter("teacherId"));
                boolean isDeleted = teacherService.deleteTeacher(teacherId);
                response.setContentType("text/html");
                if (isDeleted) {
                    pw.write("success");
                } else {
                    pw.write("error");
                }
            }else if(action.equalsIgnoreCase("deletePayment")){
                long paymentId = Long.parseLong(request.getParameter("paymentId"));
                boolean isDeleted = paymentService.deletePayment(paymentId);
                response.setContentType("text/html");
                if(isDeleted) {
                    pw.write("success");
                }else {
                    pw.write("error");
                }
            }else if(action.equalsIgnoreCase("deleteLesson")){
                long lessonId = Long.parseLong(request.getParameter("lessonId"));
                boolean isDeleted = lessonService.deleteLesson(lessonId);
                response.setContentType("text/html");
                if (isDeleted) {
                    pw.write("success");
                } else {
                    pw.write("error");
                }
            }
            if (address != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(address); // Servletden Jsp ye yonlendirme edir
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
