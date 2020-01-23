package hikmat.dao;

import hikmat.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudentList() throws Exception;
    boolean addStudent (Student student) throws Exception;
    Student getStudentById(Long studentId) throws Exception;
    boolean updateStudent(Student student,Long studentId) throws Exception;
    boolean deleteStudent(Long studentId) throws Exception;
    List<Student> searchStudentData(String keyword) throws Exception;
}
