package asai.kola.service;


import asai.kola.pojo.PageResult;
import asai.kola.pojo.Student;
import asai.kola.pojo.studentGet;
import org.springframework.stereotype.Service;

import java.util.List;


public interface studentsService {
    PageResult<Student> getStudentsList(studentGet studentGet);

    void addStudent(Student student);

    Student getStudentById(int id);

    void updateStudent(Student student);

    void deleteStudent(List<Integer> ids);

    void updateStudentViolation(int id, int score);
}
