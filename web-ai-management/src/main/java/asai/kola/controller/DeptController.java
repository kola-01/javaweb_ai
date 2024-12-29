package asai.kola.controller;


import asai.kola.pojo.Dept;
import asai.kola.pojo.Result;
import asai.kola.service.Deptservice;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
//@Slf4j
public class DeptController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DeptController.class);
    // 注入service
    @Autowired
    public Deptservice deptservice;

    /**
     * 获取所有部门列表
     *
     * @return 包含所有部门列表的Result对象
     */
    @GetMapping
    public Result list() {
        List<Dept> deptList = deptservice.findAll();
        //        System.out.println("查询所有部门: " + deptList);
        log.info("查询所有部门: {}", deptList);
        return Result.success(deptList);
    }

    /**
     * 根据ID删除部门
     *
     * @param id 部门ID，必须大于0
     * @return 表示删除结果的Result对象
     */
    @DeleteMapping
    public Result delete(Integer id) {
        if (id <= 0) {
            log.error("id不合法: {}", id);
            return Result.error("id不合法");
        }
        log.info("删除部门ID: {}", id);
        deptservice.deleteById(id);
        return Result.success();
    }

    /**
     * 添加新部门
     *
     * @param dept 待添加的部门对象，其中名称不能为空
     * @return 表示添加结果的Result对象
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        System.out.println(dept.getName());
        if (dept.getName() == null || dept.getName().equals("") || dept.getName().equals(" "))
            return Result.error("部门名不能为空");
        deptservice.add(dept);
        log.info("新增部门: {}", dept);
        return Result.success();
    }

    /**
     * 根据ID获取部门信息
     *
     * @param id 部门ID，必须大于0
     * @return 包含指定部门信息的Result对象
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id) {
        if (id <= 0) return Result.error("id不合法");
        Dept deptList = deptservice.findAll(id);
        log.info("通过Id查询部门: {}", id);
        return Result.success(deptList);
    }

    /**
     * 更新部门信息
     *
     * @param dept 待更新的部门对象，其中ID必须大于0
     * @return 表示更新结果的Result对象
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        if (dept.getId() <= 0) return Result.error("id不合法");
        log.info("修改部门: {}", dept.getName());
        deptservice.update(dept);
        return Result.success();
    }
}

