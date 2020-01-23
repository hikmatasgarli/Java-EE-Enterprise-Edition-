package hikmat.web;

import hikmat.dao.*;
import hikmat.model.Lesson;
import hikmat.model.Student;
import hikmat.model.Teacher;
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
import java.util.List;

@WebServlet(name = "NewServlet", urlPatterns = "/nw")
public class NewServlet extends HttpServlet {
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
            if (request.getParameter("action") != null) {
                action = request.getParameter("action");
            }if (action.equalsIgnoreCase("newPayment")) {
                List<Student> studentList = studentService.getStudentList();
                List<Lesson> lessonList = lessonService.getLessonList();
                List<Teacher> teacherList = teacherService.getTeacherList();
                request.setAttribute("studentList", studentList);
                request.setAttribute("lessonList", lessonList);
                request.setAttribute("teacherList", teacherList);
                address = "views/add/newPayment.jsp";
            }else if (action.equalsIgnoreCase("newLesson")) {
                List<Lesson> lessonList = lessonService.getLessonList();
                request.setAttribute("lessonList", lessonList);
                address = "views/add/newLesson.jsp";
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
