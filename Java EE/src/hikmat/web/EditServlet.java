package hikmat.web;

import hikmat.dao.*;
import hikmat.model.Lesson;
import hikmat.model.Payment;
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

@WebServlet(name = "EditServlet",urlPatterns = "/ed")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);

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
        try{
            if(request.getParameter("action") != null) {
                action = request.getParameter("action");
            }if(action.equalsIgnoreCase("editStudent")){
                Long studentId = Long.parseLong(request.getParameter("studentId"));
                Student student = studentService.getStudentById(studentId);
                request.setAttribute("student", student);
                address = "views/edit/editStudent.jsp";
            }else if (action.equalsIgnoreCase("editTeacher")){
                Long teacherId = Long.parseLong(request.getParameter("teacherId"));
                Teacher teacher = teacherService.getTeacherById(teacherId);
                request.setAttribute("teacher", teacher);
                address = "views/edit/editTeacher.jsp";
            }else if(action.equalsIgnoreCase("editLesson")){
                Long lessonId = Long.parseLong(request.getParameter("lessonId"));
                Lesson lesson = lessonService.getLessonById(lessonId);
                request.setAttribute("lesson", lesson);
                address = "views/edit/editLesson.jsp";
            }else if (action.equalsIgnoreCase("editPayment")){
                Long paymentId = Long.parseLong(request.getParameter("paymentId"));
                Payment payment = paymentService.getPaymentById(paymentId);
                List<Student> studentList = studentService.getStudentList();
                List<Lesson> lessonsList = lessonService.getLessonList();
                List<Teacher> teacherList = teacherService.getTeacherList();
                request.setAttribute("studentList",studentList);
                request.setAttribute("lessonsList",lessonsList);
                request.setAttribute("teacherList",teacherList);
                request.setAttribute("payment",payment);
                address = "views/edit/editPayment.jsp";
            }
            if (address != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(address); // Servletden Jsp ye yonlendirme edir
                dispatcher.forward(request, response);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
