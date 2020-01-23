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

@WebServlet(name = "AddServlet",urlPatterns = "/ad")
public class AddServlet extends HttpServlet {
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
            }
            if(action.equalsIgnoreCase("addStudent")){
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String adress = request.getParameter("address");
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                Student student = new Student();
                student.setName(name);
                student.setSurname(surname);
                student.setAddress(adress);
                student.setDob(dateFormat.parse(dob));
                student.setPhone(phone);
                boolean isAdded = studentService.addStudent(student);
                response.setContentType("text/html");
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }else if(action.equalsIgnoreCase("addTeacher")){
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String adress = request.getParameter("address");
                String dob = request.getParameter("dob");
                String phone = request.getParameter("phone");
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setSurname(surname);
                teacher.setAddress(adress);
                teacher.setDob(dateFormat.parse(dob));
                teacher.setPhone(phone);
                boolean isAdded = teacherService.addTeacher(teacher);
                response.setContentType("text/html");
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
            }else if(action.equalsIgnoreCase("addPayment")){
                Payment payment = new Payment();
                Student student = new Student();
                student.setId(Long.parseLong(request.getParameter("studentId")));

                Teacher teacher = new Teacher();
                teacher.setId(Long.parseLong(request.getParameter("teacherId")));

                Lesson lesson = new Lesson();
                lesson.setId(Long.parseLong(request.getParameter("lessonId")));

                payment.setStudent(student);
                payment.setTeacher(teacher);
                payment.setLesson(lesson);
                payment.setAmount(Double.parseDouble(request.getParameter("amountId")));
                boolean isAdded = paymentService.addPayment(payment);
                response.setContentType("text/html");
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("error");
                }
            }else if(action.equalsIgnoreCase("addLesson")){
                String lessonname = request.getParameter("lessonname");
                String lessontime = request.getParameter("lessontime");
                String lessonprice = request.getParameter("lessonprice");

                Lesson lesson = new Lesson();
                lesson.setLessonName(lessonname);
                lesson.setLessonTime(lessontime);
                lesson.setLessonPrice(lessonprice);
                boolean isAdded = lessonService.addLesson(lesson);
                response.setContentType("text/html");
                if (isAdded) {
                    pw.write("success");
                } else {
                    pw.write("fail");
                }
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
