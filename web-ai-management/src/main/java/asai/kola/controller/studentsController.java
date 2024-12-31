package asai.kola.controller;


import asai.kola.pojo.PageResult;
import asai.kola.pojo.Result;
import asai.kola.pojo.Student;
import asai.kola.pojo.studentGet;
import asai.kola.service.studentsService ;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentsController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(studentsController.class);

 @Autowired
 private studentsService studentsService;

    @GetMapping
    public Result getStudentsList(studentGet studentGet) {
        log.info("getStudentsList:{}", studentGet);
       PageResult<Student>  list=studentsService.getStudentsList(studentGet);
       return Result.success(list);
    }

    @PostMapping
    public Result addStudent(@RequestBody Student Student) {
        log.info("addStudent:{}", Student);
        studentsService.addStudent(Student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable int id) {
        log.info("根据id获取学生信息:{}", id);
        Student student=studentsService.getStudentById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        log.info("修改学生信息:{}", student);
        studentsService.updateStudent(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteStudent(@PathVariable List<Integer> ids) {
        log.info("批量删除学生信息:{}", ids);
        studentsService.deleteStudent(ids);
        return  Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentViolation(@PathVariable int id, @PathVariable int score) {
        log.info("修改学生{}的违纪扣分:{}", id, score);
        studentsService.updateStudentViolation(id, score);
        return Result.success();
    }
}
