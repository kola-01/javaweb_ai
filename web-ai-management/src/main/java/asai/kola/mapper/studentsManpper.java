package asai.kola.mapper;


import asai.kola.pojo.Student;
import asai.kola.pojo.studentGet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface studentsManpper {

    List<Student> getStudentsList(studentGet studentGet);

    void addStudent(Student student);

    Student getStudentById(int id);

    void updateStudent(Student student);

    void deleteStudent(List<Integer> ids);

    Integer getStudentViolation(int id);

    void updateStudentViolation(int id, int Count, int score);

    Integer getStudentViolationCount(int id);
}
