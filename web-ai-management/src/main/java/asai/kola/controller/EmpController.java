package asai.kola.controller;

import asai.kola.pojo.Emp;
import asai.kola.pojo.EmpQueryParam;
import asai.kola.pojo.PageResult;
import asai.kola.pojo.Result;
import asai.kola.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EmpController.class);
    @Autowired
    private EmpService empService;

    /**
     * 分页查询数据
     *
     * @return 分页查询数据
     */
    @GetMapping
    private Result page(EmpQueryParam empQueryParam) {
        if (empQueryParam.getPage() < 1 || empQueryParam.getPageSize() < 1) {
            log.error("分页查询数据{} 参数不合法", empQueryParam);
            return Result.error("参数不合法");
        }
        PageResult<Emp> list = empService.getList(empQueryParam);
        return Result.success(list);
    }

    /**
     * 添加员工
     *
     * @return 添加员工
     */
    @PostMapping
    private Result save(@RequestBody Emp emp) {
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    private Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工：{}", ids);
        empService.delet(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    private Result get(@PathVariable Integer id) {
        log.info("通过Id查询员工：{}", id);
        Emp epm = empService.getById(id);
        return Result.success(epm);
    }

    @PutMapping
    private Result update(@RequestBody Emp emp) {
        log.info("修改员工信息：{}", emp);
        empService.update(emp);
        return Result.success();
    }
}
