package asai.kola.service.impl;

import asai.kola.pojo.PageResult;
import asai.kola.pojo.Student;
import asai.kola.pojo.studentGet;
import asai.kola.service.studentsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import asai.kola.mapper.studentsManpper;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 学生服务实现类
 */
@Service
public class studentsServiceImpl implements studentsService {

    @Autowired
    private studentsManpper studentsManpper;

    /**
     * 获取学生列表，支持分页
     * @param studentGet 包含分页信息和查询条件的对象
     * @return 包含总记录数和学生列表的分页结果对象
     */
    @Override
    public PageResult<Student> getStudentsList(studentGet studentGet) {
        PageHelper.startPage(studentGet.getPage(), studentGet.getPageSize());
        List<Student> list = studentsManpper.getStudentsList(studentGet);
        Page<Student> page = (Page<Student>) list;
        return new PageResult<Student>(page.getTotal(), page.getResult());
    }

    /**
     * 添加学生信息
     * @param student 学生对象
     */
    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentsManpper.addStudent(student);
    }

    /**
     * 根据ID获取学生信息
     * @param id 学生ID
     * @return 学生对象
     */
    @Override
    public Student getStudentById(int id) {
        return studentsManpper.getStudentById(id);
    }

    /**
     * 更新学生信息
     * @param student 学生对象
     */
    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentsManpper.updateStudent(student);
    }

    /**
     * 根据ID列表删除学生信息
     * @param ids 学生ID列表
     */
    @Override
    public void deleteStudent(List<Integer> ids) {
        studentsManpper.deleteStudent(ids);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateStudentViolation(int id, int score) {
       Integer violation= studentsManpper.getStudentViolation(id);
       Integer violationCount=studentsManpper.getStudentViolationCount(id);
       if(violation!=null){
           studentsManpper.updateStudentViolation(id,violationCount+1, score+violation);
       }
    }


}
